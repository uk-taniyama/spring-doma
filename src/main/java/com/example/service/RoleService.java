package com.example.service;

import com.example.dto.RoleDto;
import java.util.List;

/** 権限機能を操作するサービスインターフェース. */
public interface RoleService {

  /**
   * 権限情報を検索します.
   *
   * @param roleNm:権限名称
   * @return 権限情報
   */
  List<RoleDto> findRole(String roleNm);
}
