package org.example.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/** */
@Entity(listener = MstEmployeeListener.class, metamodel = @Metamodel)
@Table(name = "MST_EMPLOYEE")
public class MstEmployee extends AbstractMstEmployee {

  /** 従業員番号 */
  @Id
  @Column(name = "EMPLOYEE_ID")
  String employeeId;

  /** 姓 */
  @Column(name = "EMPLOYEE_LAST_NAME")
  String employeeLastName;

  /** 名 */
  @Column(name = "EMPLOYEE_FIRST_NAME")
  String employeeFirstName;

  /** 権限ID */
  @Column(name = "ROLE_ID")
  String roleId;

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
   * Returns the employeeId.
   *
   * @return the employeeId
   */
  public String getEmployeeId() {
    return employeeId;
  }

  /**
   * Sets the employeeId.
   *
   * @param employeeId the employeeId
   */
  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  /**
   * Returns the employeeLastName.
   *
   * @return the employeeLastName
   */
  public String getEmployeeLastName() {
    return employeeLastName;
  }

  /**
   * Sets the employeeLastName.
   *
   * @param employeeLastName the employeeLastName
   */
  public void setEmployeeLastName(String employeeLastName) {
    this.employeeLastName = employeeLastName;
  }

  /**
   * Returns the employeeFirstName.
   *
   * @return the employeeFirstName
   */
  public String getEmployeeFirstName() {
    return employeeFirstName;
  }

  /**
   * Sets the employeeFirstName.
   *
   * @param employeeFirstName the employeeFirstName
   */
  public void setEmployeeFirstName(String employeeFirstName) {
    this.employeeFirstName = employeeFirstName;
  }

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
