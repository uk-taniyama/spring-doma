package org.example.dao;

import org.example.entity.MstNews;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/** */
@Dao
public interface MstNewsDao {

  /**
   * @param mstNewsId
   * @return the MstNews entity
   */
  @Select
  MstNews selectById(Integer mstNewsId);

  /**
   * @param mstNewsId
   * @param version
   * @return the MstNews entity
   */
  @Select(ensureResult = true)
  MstNews selectByIdAndVersion(Integer mstNewsId, Integer version);

  /**
   * @param entity
   * @return affected rows
   */
  @Insert
  int insert(MstNews entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  int update(MstNews entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  int delete(MstNews entity);
}
