package com.example;

import com.github.database.rider.core.api.dataset.DataSetExecutor;
import com.github.database.rider.core.api.exporter.DataSetExportConfig;
import com.github.database.rider.core.connection.ConnectionHolderImpl;
import com.github.database.rider.core.dataset.DataSetExecutorImpl;
import com.github.database.rider.core.exporter.DataSetExporter;
import com.github.springtestdbunit.DatabaseConnections;
import com.github.springtestdbunit.assertion.DatabaseAssertion;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.filter.IColumnFilter;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

@Slf4j
public class DBSnapshotExecutionListener extends AbstractTestExecutionListener {
  static final String CONN_NAME =
      "com.github.springtestdbunit.DbUnitTestExecutionListener.connection";
  // TestContextの属性用のPREFIX
  static final String ATTR_PREFIX = DBSnapshotExecutionListener.class.toString();

  @Override
  public void afterTestMethod(TestContext testContext) throws Exception {
    Method m = testContext.getTestMethod();
    Class<?> c = m.getDeclaringClass();

    // TODO MethodのDBSnapshotとClassのDBSnapshotをマージしていい感じにする。
    DBSnapshot config = findAnnotation(DBSnapshot.class, m);
    if (config == null || config.tableNames().length == 0) {
      log.warn("@DBSnapshotでtableNamesが指定されていない( ﾉД`)ｼｸｼｸ…");
      return;
    }
    if (config.skip()) {
      return;
    }

    // Bean経由でとりたいけど......
    String dataSourceName = config.value();
    DatabaseConnections conns = (DatabaseConnections) testContext.getAttribute(CONN_NAME);
    if (conns == null) {
      log.warn("DatabaseConnectionsが取れない( ﾉД`)ｼｸｼｸ…");
      return;
    }
    IDatabaseConnection conn = conns.get(dataSourceName);
    if (conn == null) {
      log.warn("IDatabaseConnection(" + dataSourceName + ")が取れない( ﾉД`)ｼｸｼｸ…");
      return;
    }
    // NOTE Bean経由で取得すると、connectionが違うらしく、正しい情報が取れない.....
    // DataSource dataSource =
    // testContext.getApplicationContext().getBean(dataSourceName,
    // DataSource.class);
    // if (dataSource == null) {
    // log.warn("DataSource(" + dataSource + ")が取れない( ﾉД`)ｼｸｼｸ…");
    // return;
    // }

    String[] tableNames = config.tableNames();
    String actualName = expandTemplate(config.actual(), c, m);
    String expectedName = expandTemplate(config.expected(), c, m);

    // export
    DataSetExportConfig exportConfig = new DataSetExportConfig();
    exportConfig.builderType(config.builderType());
    exportConfig.dataSetFormat(config.actualFormat());
    exportConfig.includeTables(config.tableNames());
    exportConfig.outputFileName(actualName);
    DataSetExporter.getInstance().export(conn.getConnection(), exportConfig);

    // verify
    DataSetExecutor executor =
        DataSetExecutorImpl.instance(new ConnectionHolderImpl(conn.getConnection()));
    IDataSet expectedDataSet = executor.loadDataSet(expectedName);
    IDataSet actualDataSet = conn.createDataSet(tableNames);
    verifyExpected(
        expectedDataSet,
        actualDataSet,
        config.tableNames(),
        newInstanceList(config.columnFilters()),
        config.assertionMode());
  }

  public String expandTemplate(String template, Class<?> c, Method m) {
    return template.replace("${class}", c.getSimpleName()).replace("${method}", m.getName());
  }

  public static <T> List<T> newInstanceList(Class<? extends T>[] classes)
      throws InstantiationException, IllegalAccessException, IllegalArgumentException,
          InvocationTargetException, NoSuchMethodException, SecurityException {
    List<T> columnFilters = new ArrayList<>();
    for (Class<? extends T> c : classes) {
      columnFilters.add(c.getDeclaredConstructor().newInstance());
    }
    return columnFilters;
  }

  void verifyExpected(
      IDataSet expectedDataSet,
      IDataSet actualDataSet,
      String[] tableNames,
      List<IColumnFilter> columnFilters,
      DatabaseAssertionMode assertionMode)
      throws DataSetException, DatabaseUnitException {
    DatabaseAssertion assertion = assertionMode.getDatabaseAssertion();
    for (String tableName : tableNames) {
      assertion.assertEquals(
          expectedDataSet.getTable(tableName), actualDataSet.getTable(tableName), columnFilters);
    }
  }

  public static <T> T findAnnotation(Class<T> klass, Method method) {
    T item = findAnnotation(klass, method.getAnnotations());
    if (item != null) {
      return item;
    }
    Class<?> methodClass = method.getDeclaringClass();
    return findAnnotation(klass, methodClass.getDeclaredAnnotations());
  }

  public static <T> T findAnnotation(Class<T> klass, Annotation[] array) {
    for (Annotation item : array) {
      if (klass.isAssignableFrom(item.getClass())) {
        return (T) item;
      }
    }
    return null;
  }
}
