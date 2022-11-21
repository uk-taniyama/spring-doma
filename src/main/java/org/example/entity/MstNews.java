package org.example.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/** */
@Entity(listener = MstNewsListener.class, metamodel = @Metamodel)
@Table(name = "MST_NEWS")
public class MstNews extends AbstractMstNews {

  /** mst_news_id */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MST_NEWS_ID")
  Integer mstNewsId;

  /** 権限ID */
  @Column(name = "ROLE_ID")
  String roleId;

  /** subject */
  @Column(name = "SUBJECT")
  String subject;

  /** url */
  @Column(name = "URL")
  String url;

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
   * Returns the mstNewsId.
   *
   * @return the mstNewsId
   */
  public Integer getMstNewsId() {
    return mstNewsId;
  }

  /**
   * Sets the mstNewsId.
   *
   * @param mstNewsId the mstNewsId
   */
  public void setMstNewsId(Integer mstNewsId) {
    this.mstNewsId = mstNewsId;
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
   * Returns the subject.
   *
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Sets the subject.
   *
   * @param subject the subject
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Returns the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the url.
   *
   * @param url the url
   */
  public void setUrl(String url) {
    this.url = url;
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
