/**
 * <p>
 * Title: ProductExecution.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��15��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.dto;

import java.util.List;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.ProductImage;

/**
 * <p>
 * Title: ProductExecution
 * </p>
 * <p>
 * Description: ��Ʒֵ���ݶ��󣬱����˲�Ʒ��𣬲�Ʒ����Լ���Ʒ����
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��15��
 *         </p>
 */
public class ProductExecution {
  /**
   * ��Ʒ�����
   */
  private String categoryName;
  /**
   * ��Ʒ������
   */
  private long categoryId;
  /**
   * ��Ʒ������
   */
  private long productMaxCount;
  /**
   * ��Ʒ�б�
   */
  private List<Product> productList;
  /**
   * ������Ʒ
   */
  private Product product;
  /**
   * ������Ʒ������ͼƬ
   */
  private List<ProductImage>productImages;

  /**
   * 
   * <p>
   * Title:
   * </p>
   * <p>
   * Description: �з���Ĺ�����
   * </p>
   * 
   * @param categoryId �������
   * @param categoryName ������
   * @param productList ��Ʒ�б�
   */
  public ProductExecution(long categoryId, String categoryName, List<Product> productList) {
    setCategoryId(categoryId);
    setCategoryName(categoryName);
    setProductList(productList);
  }
  /**
   * 
  �� * <p>Title: Ĭ�Ϲ�����</p> 
  �� * <p>Description: Ĭ�Ϲ�����</p>
   */
  public ProductExecution() {};
  /**
   * 
   * <p>
   * Title:
   * </p>
   * <p>
   * Description: �޷���Ĺ�����
   * </p>
   * 
   * @param productList ��Ʒ�б�
   */
  public ProductExecution(List<Product> productList) {
    setProductList(productList);
  }

  /**
   * 
   * <p>
   * Title:
   * </p>
   * <p>
   * Description: ������Ʒ�Ĺ�����
   * </p>
   * 
   * @param categoryId �������
   * @param categoryName ������
   * @param product ��Ʒ
   */
  public ProductExecution(long categoryId, String categoryName, Product product) {
    setCategoryId(categoryId);
    setCategoryName(categoryName);
    setProduct(product);
  }

  /**
   * @return the categoryId ��Ʒ������
   */
  public long getCategoryId() {
    return categoryId;
  }

  /**
   * @param categoryId the categoryId to set
   */
  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  /**
   * @return the productList ��Ʒ�б�
   */
  public List<Product> getProductList() {
    return productList;
  }

  /**
   * @param productList the productList to set
   */
  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  /**
   * @return the categoryName ��Ʒ�����
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
   * @return the productMaxCount
   */
  public long getProductMaxCount() {
    return productMaxCount;
  }

  /**
   * @param productMaxCount the productMaxCount to set
   */
  public void setProductMaxCount(long productMaxCount) {
    this.productMaxCount = productMaxCount;
  }

  /**
   * @return the product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * @param product the product to set
   */
  public void setProduct(Product product) {
    this.product = product;
  }

  public List<ProductImage> getProductImages() {
    return productImages;
  }
  public void setProductImages(List<ProductImage> productImages) {
    this.productImages = productImages;
  }
  @Override
  public String toString() {
    return "ProductExecution [categoryName=" + categoryName + ", categoryId=" + categoryId
        + ", productMaxCount=" + productMaxCount + ", productList=" + productList + ", product="
        + product + ", productImages=" + productImages + "]";
  }

}
