/**
 * <p>
 * Title: ProductCategory.java
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
 * Title: ProductCategory
 * </p>
 * <p>
 * Description: ��Ʒ����ʵ����
 * </p>
 * @author zyd @date 2020��3��11��
 */
public class ProductCategory {
  /**
   * ���
   */
  private long id;
  /**
   * �����
   */
  private String categoryName;
  /**
   * �������
   */
  private int sortOrder;
  /**
   * ���˵��
   */
  private String description;
  /**
   * ͼƬ
   */
  private String image;
  /**
   * ����ʱ��
   */
  private LocalDateTime upDateTime;

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
   * @return the categoryName �����
   */
  public String getCategoryName() {
    return categoryName;
  }

  /**
   * @param categoryName the categoryName to set
   */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  /**
   * @return the sortOrder �������
   */
  public int getSortOrder() {
    return sortOrder;
  }

  /**
   * @param sortOrder the sortOrder to set
   */
  public void setSortOrder(int sortOrder) {
    this.sortOrder = sortOrder;
  }

  /**
   * @return the description ���˵��
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
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
   * @return the upDateTime ����ʱ��
   */
  public LocalDateTime getUpDateTime() {
    return upDateTime;
  }

  /**
   * @param upDateTime the upDateTime to set
   */
  public void setUpDateTime(LocalDateTime upDateTime) {
    this.upDateTime = upDateTime;
  }


  @Override
  public String toString() {
    return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", sortOrder="
        + sortOrder + ", description=" + description + ", image=" + image + ", upDateTime="
        + upDateTime + "]";
  }

}
