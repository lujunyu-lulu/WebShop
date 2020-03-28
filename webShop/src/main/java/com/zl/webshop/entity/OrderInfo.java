/**
 * <p>
 * Title: OrderInfo.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd @date 2020��3��11�� @version 1.0
 */
package com.zl.webshop.entity;

import java.time.LocalDateTime;

/**
 * <p>
 * Title: OrderInfo
 * </p>
 * <p>
 * Description: ������Ϣ��ʵ����
 * </p>
 * @author zyd @date 2020��3��11��
 */
public class OrderInfo {
  /**
   * ���
   */
  private long id;
  /**
   * �������
   */
  private String orderNum;
  /**
   * �û���
   */
  private String userName;
  /**
   * �ϼƽ��
   */
  private float price;
  /**
   * ����״̬���µ�0/����1/�ĵ�2��
   */
  private int status;
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
   * ������ע
   */
  private String message;
  /**
   * ��������ʱ��
   */
  private LocalDateTime createTime;

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
   * @return the orderNum �������
   */
  public String getOrderNum() {
    return orderNum;
  }

  /**
   * @param orderNum the orderNum to set
   */
  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
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
   * @return the price �ϼƽ��
   */
  public float getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(float price) {
    this.price = price;
  }

  /**
   * @return the status ����״̬
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
   * @return the message ������ע
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the createDateTime ����ʱ��
   */
  public LocalDateTime getCreateTime() {
    return createTime;
  }

  /**
   * @param createTime the createTime to set
   */
  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }


  @Override
  public String toString() {
    return "OrderInfo [id=" + id + ", orderNum=" + orderNum + ", userName=" + userName + ", price="
        + price + ", status=" + status + ", contactName=" + contactName + ", contactMobile="
        + contactMobile + ", contactAddress=" + contactAddress + ", message=" + message
        + ", createTime=" + createTime + "]";
  }

}
