package org.example.dao;

import org.example.entity.MstEmployee;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/** */
@Dao
public interface MstEmployeeDao {

  /**
   * @param employeeId
   * @return the MstEmployee entity
   */
  @Select
  MstEmployee selectById(String employeeId);

  /**
   * @param employeeId
   * @param version
   * @return the MstEmployee entity
   */
  @Select(ensureResult = true)
  MstEmployee selectByIdAndVersion(String employeeId, Integer version);

  /**
   * @param entity
   * @return affected rows
   */
  @Insert
  int insert(MstEmployee entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  int update(MstEmployee entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  int delete(MstEmployee entity);
}
