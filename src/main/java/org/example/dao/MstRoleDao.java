package org.example.dao;

import org.example.entity.MstRole;
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
public interface MstRoleDao {

  /**
   * @param roleId
   * @return the MstRole entity
   */
  @Select
  MstRole selectById(String roleId);

  /**
   * @param roleId
   * @param version
   * @return the MstRole entity
   */
  @Select(ensureResult = true)
  MstRole selectByIdAndVersion(String roleId, Integer version);

  /**
   * @param entity
   * @return affected rows
   */
  @Insert
  @Transactional
  int insert(MstRole entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  @Transactional
  int update(MstRole entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  @Transactional
  int delete(MstRole entity);
}
