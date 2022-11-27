package com.example;

import com.github.springtestdbunit.DatabaseConnections;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.annotation.ExpectedDatabases;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class CustomTestExecutionListener extends AbstractTestExecutionListener {
  static final String CONN_NAME =
      "com.github.springtestdbunit.DbUnitTestExecutionListener.connection";

  @Override
  public void afterTestMethod(TestContext testContext) throws Exception {
    Method m = testContext.getTestMethod();
    List<ExpectedDatabase> list = getExpectedDatabase(m);
    if (list.size() == 0) {
      return;
    }
    DatabaseConnections obj = (DatabaseConnections) testContext.getAttribute(CONN_NAME);
    if (obj == null) {
      return;
    }
    for (ExpectedDatabase item : list) {
      IDatabaseConnection conn = obj.get(item.connection());
      if (conn == null) {
        return;
      }
      String tableName = item.table();
      String[] tableNames = new String[] {tableName};
      IDataSet depDataSet = conn.createDataSet(tableNames);
      String pathName =
          m.getDeclaringClass().getCanonicalName() + "#" + m.getName() + '#' + tableName + ".xml";
      FlatXmlDataSet.write(depDataSet, new FileOutputStream(pathName));
      System.out.println(m.getDeclaringClass().getCanonicalName());
    }
  }

  List<ExpectedDatabase> getExpectedDatabase(Method method) {
    List<ExpectedDatabase> items = new ArrayList<>();
    Annotation[] array = method.getAnnotations();
    for (Annotation item : array) {
      if (item instanceof ExpectedDatabase) {
        items.add((ExpectedDatabase) item);
      }
      if (item instanceof ExpectedDatabases) {
        ExpectedDatabases anno = (ExpectedDatabases) item;
        items.addAll(Arrays.asList(anno.value()));
      }
    }
    return items;
  }
}
