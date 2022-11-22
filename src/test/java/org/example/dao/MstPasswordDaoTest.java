package org.example.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.seasar.doma.jdbc.SqlFile;

/** */
public class MstPasswordDaoTest extends DaoTestBase {

  /**
   * @throws Exception
   */
  @Test
  public void testSelectById(TestInfo testInfo) throws Exception {
    SqlFile sqlFile =
        repository.getSqlFile(
            testInfo.getTestMethod().get(),
            "META-INF/org/example/dao/MstPasswordDao/selectById.sql",
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
            "META-INF/org/example/dao/MstPasswordDao/selectByIdAndVersion.sql",
            dialect);
    execute(sqlFile);
  }
}
