/**
 * <p>
 * Title: UserRoles.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd @date 2020��3��11�� @version 1.0
 */
package com.zl.webshop.entity;

/**
 * <p>
 * Title: UserRoles
 * </p>
 * <p>
 * Description: �û�Ȩ�ޱ�ʵ����
 * </p>
 * 
 * @author zyd @date 2020��3��11��
 */
public class UserRoles {
  /**
   * id ���
   */
  private long id;
  /**
   * role Ȩ��
   */
  private String role;
  /**
   * userName �û���
   */
  private String userName;


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
   * @return the role Ȩ����
   */
  public String getRole() {
    return role;
  }


  /**
   * @param role the role to set
   */
  public void setRole(String role) {
    this.role = role;
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


  @Override
  public String toString() {
    return "UserRoles [id=" + id + ", role=" + role + ", userName=" + userName + "]";
  }

}
