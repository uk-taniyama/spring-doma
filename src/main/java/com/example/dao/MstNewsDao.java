package com.example.dao;

import com.example.dto.NewsDto;
import com.example.entity.MstNews;
import java.util.List;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.transaction.annotation.Transactional;

/** お知らせマスタのDaoインターフェース. */
@ConfigAutowireable
@Dao
public interface MstNewsDao {

  @Select
  List<MstNews> selectAll();

  @Select
  List<NewsDto> selectNewsDtoByCond(
      String subject, String roleId, String url, SelectOptions selectOptions);

  @Select
  NewsDto selectOneNewsDto(Long id);

  @Insert
  @Transactional
  int insert(MstNews trn);

  @Update
  @Transactional
  int update(MstNews trn);

  @Delete
  @Transactional
  int delete(MstNews trn);
}
