/**
 * <p>
 * Title: OrderItem.java
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
 * Title: OrderItem
 * </p>
 * <p>
 * Description: ������Ŀ��ʵ����
 * </p>
 * 
 * @author zyd @date 2020��3��11��
 */
public class OrderItem {
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
   * ��Ʒ��
   */
  private String productName;
  /**
   * ��Ʒ���
   */
  private long productId;
  /**
   * ����
   */
  private float price;
  /**
   * ����
   */
  private int quantity;

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
   * @return the productName ��Ʒ��
   */
  public String getProductName() {
    return productName;
  }

  /**
   * @param productName the productName to set
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * @return the productId ��Ʒ���
   */
  public long getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(long productId) {
    this.productId = productId;
  }

  /**
   * @return the price ����
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
   * @return the quantity ����
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

 
  @Override
  public String toString() {
    return "OrderItem [id=" + id + ", orderNum=" + orderNum + ", userName=" + userName
        + ", productName=" + productName + ", productId=" + productId + ", price=" + price
        + ", quantity=" + quantity + "]";
  }

}
