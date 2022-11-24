package org.example.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.seasar.doma.jdbc.NoCacheSqlFileRepository;
import org.seasar.doma.jdbc.SqlFile;
import org.seasar.doma.jdbc.SqlFileRepository;
import org.seasar.doma.jdbc.dialect.Dialect;

public class DaoTestBase {
  /** */
  static SqlFileRepository repository;

  /** */
  static Dialect dialect;

  /** */
  static Driver driver;

  /** */
  static String url;

  /** */
  static String user;

  /** */
  static String password;

  @BeforeAll
  static void setUp() throws Exception {
    repository = new NoCacheSqlFileRepository();
    dialect = new org.seasar.doma.jdbc.dialect.H2Dialect();
    url = "jdbc:h2:mem:db;MODE=MySQL;DB_CLOSE_DELAY=-1";
    user = "";
    password = "";

    Flyway.configure().dataSource(url, user, password).load().migrate();
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
}
