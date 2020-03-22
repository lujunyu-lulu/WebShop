package com.zl.webshop.entity;

import java.time.LocalDateTime;

/**
 * <p>
 * Title: User
 * </p>
 * <p>
 * Description:User��ʵ����
 * </p>
 * @author zyd @date 2020��3��11��
 */
public class User {
  /**
   * id ���
   */
  private long id;
  /**
   * userName �û���
   */
  private String userName;
  /**
   * password ����
   */
  private String password;
  /**
   * nickName �ǳ�
   */
  private String nickName;
  /**
   * email ����
   */
  private String email;
  /**
   * registerTime ע��ʱ��
   */
  private LocalDateTime registerTime;
  /**
  * @return the id ���
  */
  public long getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }
  /**
  * @return the userName �û���
  */
  public String getUserName() {
    return userName;
  }
  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }
  /**
  * @return the password ����
  */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
  /**
  * @return the nickName �ǳ�
  */
  public String getNickName() {
    return nickName;
  }
  /**
   * @param nickName the nickName to set
   */
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  /**
  * @return the email ����
  */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
  * @return the registerTime ע��ʱ��
  */
  public LocalDateTime getRegisterTime() {
    return registerTime;
  }
  /**
   * @param registerTime the registerTime to set
   */
  public void setRegisterTime(LocalDateTime registerTime) {
    this.registerTime = registerTime;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", nickName="
        + nickName + ", email=" + email + ", registerTime=" + registerTime + "]";
  }

}
