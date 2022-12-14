package com.example.service;

import com.example.dao.MstRoleDao;
import com.example.dto.RoleDto;
import com.example.entity.MstRole;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 権限機能を操作するサービスクラス. */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired private MstRoleDao mstRoleDao;

  /**
   * 権限名称に一致する権限を検索します.
   *
   * @param roleNm:権限名称
   * @return
   */
  @Override
  public List<RoleDto> findRole(String roleNm) {

    List<MstRole> msts = mstRoleDao.selectByRoleName(roleNm);
    ArrayList<RoleDto> dtos = new ArrayList<>();
    msts.stream()
        .forEach(
            mst -> {
              RoleDto dto = new RoleDto();
              dto.setRoleId(mst.getRoleId());
              dto.setRoleNm(mst.getRoleName());
              dtos.add(dto);
            });
    return dtos;
  }
}
