package com.example.dao;

import com.example.entity.MstEmployee;
import com.example.entity.UserEntity;
import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

/** 従業員マスタのDaoインターフェース. */
@ConfigAutowireable
@Dao
public interface MstEmployeeDao {

  @Select
  List<MstEmployee> selectAll();

  @Select
  MstEmployee selectOne(String id);

  @Select
  UserEntity selectUser(String id);

  @Insert
  @Transactional
  int insert(MstEmployee mstEmployee);
}
