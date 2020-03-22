/**
 * <p>
 * Title: OrderHistory.java
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
 * Title: OrderHistory
 * </p>
 * <p>
 * Description: ������ʷ��ʵ����
 * </p>
 * @author zyd @date 2020��3��11��
 */
public class OrderHistory {
  /**
   * ���
   */
  private long id;
  /**
   * �������
   */
  private String orderNum;
  /**
   * �������û���
   */
  private String updateUserName;
  /**
   * ����״̬
   */
  private int status;
  /**
   * ����ʱ��
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
   * @return the updateUserName �������û���
   */
  public String getUpdateUserName() {
    return updateUserName;
  }

  /**
   * @param updateUserName the updateUserName to set
   */
  public void setUpdateUserName(String updateUserName) {
    this.updateUserName = updateUserName;
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
   * @return the createTime ����ʱ��
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
    return "OrderHistory [id=" + id + ", orderNum=" + orderNum + ", updateUserName="
        + updateUserName + ", status=" + status + ", createTime=" + createTime + "]";
  }

}
