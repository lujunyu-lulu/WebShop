/**
 * <p>
 * Title: Product.java
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
 * Title: Product
 * </p>
 * <p>
 * Description: ��Ʒ��ʵ����
 * </p>
 * @author zyd @date 2020��3��11��
 */
public class Product {
  /**
   * ���
   */
  private long id;
  /**
   * ��Ʒ��
   */
  private String productName;
  /**
   * ��Ʒ˵��
   */
  private String explain;
  /**
   * ������
   */
  private int categoryId;
  /**
   * ���ڼ۸�
   */
  private float shopPrice;
  /**
   * �г��۸�
   */
  private float price;
  /**
   * ����
   */
  private int quantity;
  /**
   * ͼƬ
   */
  private String image;
  /**
   * ����ʱ��
   */
  private LocalDateTime createTime;
  /**
   * ����ʱ��
   */
  private LocalDateTime updateTime;
  /**
   * ��������
   */
  private String createUserName;
  /**
   * ��������
   */
  private String updateUserName;

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
   * @return the explain ��Ʒ˵��
   */
  public String getExplain() {
    return explain;
  }

  /**
   * @param explain the explain to set
   */
  public void setExplain(String explain) {
    this.explain = explain;
  }

  /**
   * @return the categoryId ������
   */
  public int getCategoryId() {
    return categoryId;
  }

  /**
   * @param categoryId the categoryId to set
   */
  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  /**
   * @return the shopPrice ���ڼ۸�
   */
  public float getShopPrice() {
    return shopPrice;
  }

  /**
   * @param shopPrice the shopPrice to set
   */
  public void setShopPrice(float shopPrice) {
    this.shopPrice = shopPrice;
  }

  /**
   * @return the price �۸�
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

  /**
   * @return the image ͼƬ
   */
  public String getImage() {
    return image;
  }

  /**
   * @param image the image to set
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * @return the createTime ������Ʒʱ��
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

  /**
   * @return the updateTime ������Ʒʱ��
   */
  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  /**
   * @param updateTime the updateTime to set
   */
  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * @return the createUserName ��������
   */
  public String getCreateUserName() {
    return createUserName;
  }

  /**
   * @param createUserName the createUserName to set
   */
  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  /**
   * @return the updateUserName ��������
   */
  public String getUpdateUserName() {
    return updateUserName;
  }

  /**
   * @param updateUserName the updateUserName to set
   */
  public void setUpdateUserId(String updateUserName) {
    this.updateUserName = updateUserName;
  }

 
  @Override
  public String toString() {
    return "Product [id=" + id + ", productName=" + productName + ", explain=" + explain
        + ", categoryId=" + categoryId + ", shopPrice=" + shopPrice + ", price=" + price
        + ", quantity=" + quantity + ", image=" + image + ", createTime=" + createTime
        + ", updateTime=" + updateTime + ", createUserName=" + createUserName + ", updateUserName="
        + updateUserName + "]";
  }

}
