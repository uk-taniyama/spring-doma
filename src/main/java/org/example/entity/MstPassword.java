package org.example.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/** */
@Entity(listener = MstPasswordListener.class, metamodel = @Metamodel)
@Table(name = "MST_PASSWORD")
public class MstPassword extends AbstractMstPassword {

  /** パスワードマスタID */
  @Id
  @Column(name = "MST_PASSWORD_ID")
  Integer mstPasswordId;

  /** 従業員番号 */
  @Column(name = "EMPLOYEE_ID")
  String employeeId;

  /** パスワード */
  @Column(name = "PASSWORD")
  String password;

  /** パスワード世代 */
  @Column(name = "GENERATION")
  String generation;

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
   * Returns the mstPasswordId.
   *
   * @return the mstPasswordId
   */
  public Integer getMstPasswordId() {
    return mstPasswordId;
  }

  /**
   * Sets the mstPasswordId.
   *
   * @param mstPasswordId the mstPasswordId
   */
  public void setMstPasswordId(Integer mstPasswordId) {
    this.mstPasswordId = mstPasswordId;
  }

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
   * Returns the password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Returns the generation.
   *
   * @return the generation
   */
  public String getGeneration() {
    return generation;
  }

  /**
   * Sets the generation.
   *
   * @param generation the generation
   */
  public void setGeneration(String generation) {
    this.generation = generation;
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
