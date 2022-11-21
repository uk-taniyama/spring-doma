package org.example.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/** */
@Entity(listener = MstRoleListener.class, metamodel = @Metamodel)
@Table(name = "MST_ROLE")
public class MstRole extends AbstractMstRole {

  /** 権限ID */
  @Id
  @Column(name = "ROLE_ID")
  String roleId;

  /** 権限名 */
  @Column(name = "ROLE_NAME")
  String roleName;

  /** バージョン */
  @Version
  @Column(name = "VERSION")
  Integer version;

  /** 登録ユーザ */
  @Column(name = "INSERT_USER")
  String insertUser;

  /** insert_date */
  @Column(name = "INSERT_DATE")
  LocalDateTime insertDate;

  /** 更新ユーザ */
  @Column(name = "UPDATE_USER")
  String updateUser;

  /** update_date */
  @Column(name = "UPDATE_DATE")
  LocalDateTime updateDate;

  /**
   * Returns the roleId.
   *
   * @return the roleId
   */
  public String getRoleId() {
    return roleId;
  }

  /**
   * Sets the roleId.
   *
   * @param roleId the roleId
   */
  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  /**
   * Returns the roleName.
   *
   * @return the roleName
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * Sets the roleName.
   *
   * @param roleName the roleName
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  /**
   * Returns the version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets the version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Returns the insertUser.
   *
   * @return the insertUser
   */
  public String getInsertUser() {
    return insertUser;
  }

  /**
   * Sets the insertUser.
   *
   * @param insertUser the insertUser
   */
  public void setInsertUser(String insertUser) {
    this.insertUser = insertUser;
  }

  /**
   * Returns the insertDate.
   *
   * @return the insertDate
   */
  public LocalDateTime getInsertDate() {
    return insertDate;
  }

  /**
   * Sets the insertDate.
   *
   * @param insertDate the insertDate
   */
  public void setInsertDate(LocalDateTime insertDate) {
    this.insertDate = insertDate;
  }

  /**
   * Returns the updateUser.
   *
   * @return the updateUser
   */
  public String getUpdateUser() {
    return updateUser;
  }

  /**
   * Sets the updateUser.
   *
   * @param updateUser the updateUser
   */
  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  /**
   * Returns the updateDate.
   *
   * @return the updateDate
   */
  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  /**
   * Sets the updateDate.
   *
   * @param updateDate the updateDate
   */
  public void setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
  }
}
