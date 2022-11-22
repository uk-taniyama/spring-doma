package com.example.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.seasar.doma.jdbc.SqlFile;

/** */
public class MstEmployeeDaoTest extends DaoTestBase {

  /**
   * @throws Exception
   */
  @Test
  public void testSelectOne(TestInfo testInfo) throws Exception {
    SqlFile sqlFile =
        repository.getSqlFile(
            testInfo.getTestMethod().get(),
            "META-INF/com/example/dao/MstEmployeeDao/selectOne.sql",
            dialect);
    execute(sqlFile);
  }

  /**
   * @throws Exception
   */
  @Test
  public void testSelectUser(TestInfo testInfo) throws Exception {
    SqlFile sqlFile =
        repository.getSqlFile(
            testInfo.getTestMethod().get(),
            "META-INF/com/example/dao/MstEmployeeDao/selectUser.sql",
            dialect);
    execute(sqlFile);
  }

  /**
   * @throws Exception
   */
  @Test
  public void testSelectAll(TestInfo testInfo) throws Exception {
    SqlFile sqlFile =
        repository.getSqlFile(
            testInfo.getTestMethod().get(),
            "META-INF/com/example/dao/MstEmployeeDao/selectAll.sql",
            dialect);
    execute(sqlFile);
  }
}
