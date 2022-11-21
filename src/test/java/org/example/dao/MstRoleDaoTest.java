package org.example.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFile;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;

/** */
public class MstRoleDaoTest {

  /** */
  protected SqlFileRepository repository;

  /** */
  protected Dialect dialect;

  /** */
  protected Driver driver;

  /** */
  protected String url;

  /** */
  protected String user;

  /** */
  protected String password;

  @BeforeEach
  protected void setUp() throws Exception {
    repository = new NoCacheSqlFileRepository();
    dialect = new org.seasar.doma.jdbc.dialect.H2Dialect();
    url = "jdbc:h2:file:/home/taniyama/work/spring-demo/work/db/db;MODE=MySQL";
    user = "";
    password = "";
  }

  /**
   * @param sqlFile
   * @throws Exception
   */
  protected void execute(SqlFile sqlFile) throws Exception {
    Connection connection = getConnection();
    try {
      connection.setAutoCommit(false);
      Statement statement = connection.createStatement();
      try {
        statement.execute(sqlFile.getSql());
      } finally {
        statement.close();
      }
    } finally {
      try {
        connection.rollback();
      } finally {
        connection.close();
      }
    }
  }

  /**
   * @return
   * @throws Exception
   */
  protected Connection getConnection() throws Exception {
    return DriverManager.getConnection(url, user, password);
  }

  /**
   * @throws Exception
   */
  @Test
  public void testSelectById(TestInfo testInfo) throws Exception {
    SqlFile sqlFile =
        repository.getSqlFile(
            testInfo.getTestMethod().get(),
            "META-INF/org/example/dao/MstRoleDao/selectById.sql",
            dialect);
    execute(sqlFile);
  }

  /**
   * @throws Exception
   */
  @Test
  public void testSelectByIdAndVersion(TestInfo testInfo) throws Exception {
    SqlFile sqlFile =
        repository.getSqlFile(
            testInfo.getTestMethod().get(),
            "META-INF/org/example/dao/MstRoleDao/selectByIdAndVersion.sql",
            dialect);
    execute(sqlFile);
  }
}
