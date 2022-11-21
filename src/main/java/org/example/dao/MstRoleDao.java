package org.example.dao;

import org.example.entity.MstRole;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/** */
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
  int insert(MstRole entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  int update(MstRole entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  int delete(MstRole entity);
}
