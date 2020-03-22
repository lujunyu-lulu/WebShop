/**
 * <p>
 * Title: Contact.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd @date 2020��3��11�� @version 1.0
 */
package com.zl.webshop.entity;

/**
 * <p>
 * Title: Contact
 * </p>
 * <p>
 * Description: ��ϵ��Ϣ��ʵ��
 * </p>
 * @author zyd @date 2020��3��11��
 */
public class Contact {
  /**
   * ���
   */
  private long id;
  /**
   * �û���
   */
  private String userName;
  /**
   * ��ϵ��
   */
  private String contactName;
  /**
   * ��ϵ�绰
   */
  private String contactMobile;
  /**
   * ��ϵ��ַ
   */
  private String contactAddress;
  /**
   * ��ϵ��Ϣ״̬ 0Ĭ�ϵ�ַ/1��Ĭ�ϵ�ַ
   */
  private int status;

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
   * @return the contactName ��ϵ��
   */
  public String getContactName() {
    return contactName;
  }

  /**
   * @param contactName the contactName to set
   */
  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  /**
   * @return the contactMobile ��ϵ�绰
   */
  public String getContactMobile() {
    return contactMobile;
  }

  /**
   * @param contactMobile the contactMobile to set
   */
  public void setContactMobile(String contactMobile) {
    this.contactMobile = contactMobile;
  }

  /**
   * @return the contactAddress ��ϵ��ַ
   */
  public String getContactAddress() {
    return contactAddress;
  }

  /**
   * @param contactAddress the contactAddress to set
   */
  public void setContactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
  }

  /**
   * @return the status ��ϵ��Ϣ����״̬0Ĭ�ϵ�ַ/1��Ĭ�ϵ�ַ
   */
  public int getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(int status) {
    this.status = status;
  }


  @Override
  public String toString() {
    return "Contact [id=" + id + ", userName=" + userName + ", contactName=" + contactName
        + ", contactMobile=" + contactMobile + ", contactAddress=" + contactAddress + ", status="
        + status + "]";
  }

}
