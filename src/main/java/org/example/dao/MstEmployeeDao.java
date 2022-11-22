package org.example.dao;

import org.example.entity.MstEmployee;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

/** */
@ConfigAutowireable
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
  @Transactional
  int insert(MstEmployee entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  @Transactional
  int update(MstEmployee entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  @Transactional
  int delete(MstEmployee entity);
}
