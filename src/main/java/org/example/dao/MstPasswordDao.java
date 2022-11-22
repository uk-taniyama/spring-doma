package org.example.dao;

import org.example.entity.MstPassword;
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
public interface MstPasswordDao {

  /**
   * @param mstPasswordId
   * @return the MstPassword entity
   */
  @Select
  MstPassword selectById(Integer mstPasswordId);

  /**
   * @param mstPasswordId
   * @param version
   * @return the MstPassword entity
   */
  @Select(ensureResult = true)
  MstPassword selectByIdAndVersion(Integer mstPasswordId, Integer version);

  /**
   * @param entity
   * @return affected rows
   */
  @Insert
  @Transactional
  int insert(MstPassword entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  @Transactional
  int update(MstPassword entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  @Transactional
  int delete(MstPassword entity);
}
