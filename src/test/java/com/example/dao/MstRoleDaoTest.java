package com.example.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.seasar.doma.jdbc.SqlFile;

/** */
public class MstRoleDaoTest extends DaoTestBase {

  /**
   * @throws Exception
   */
  @Test
  public void testSelectByRoleName(TestInfo testInfo) throws Exception {
    SqlFile sqlFile =
        repository.getSqlFile(
            testInfo.getTestMethod().get(),
            "META-INF/com/example/dao/MstRoleDao/selectByRoleName.sql",
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
            "META-INF/com/example/dao/MstRoleDao/selectAll.sql",
            dialect);
    execute(sqlFile);
  }
}
