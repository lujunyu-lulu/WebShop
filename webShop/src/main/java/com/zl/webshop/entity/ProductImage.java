/**
 * <p>
 * Title: ProductImage.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��4��3��
 * </p>
 * @version 1.0
 */
package com.zl.webshop.entity;

/**
 * <p>
 * Title: ProductImage
 * </p>
 * <p>
 * Description: ��ƷͼƬ��ʵ����
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��4��3��
 * </p>
 */
public class ProductImage {
  /**
   * ���
   */
  private long id;
  /**
   * ��Ʒ���
   */
  private long productId;
  /**
   * ͼƬ
   */
  private String image;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "ProductImage [id=" + id + ", productId=" + productId + ", image=" + image + "]";
  }

}
