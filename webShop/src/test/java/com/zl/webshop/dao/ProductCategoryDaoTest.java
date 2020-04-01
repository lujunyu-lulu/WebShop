package com.zl.webshop.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.zl.webshop.BaseTest;
import com.zl.webshop.entity.ProductCategory;
/**
 * 
�� * <p>Title: ProductCategoryDaoTest</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��15�� </p>
 */
@Deprecated
public class ProductCategoryDaoTest extends BaseTest{

  @Autowired
  ProductCategoryDao productCategoryDao;
  
  @Test@Ignore
  public void testAddProductCategory() {
    ProductCategory productCategory=new ProductCategory();
    productCategory.setCategoryName("�ֻ�");
    productCategory.setDescription("�ֻ��Լ�������");
    productCategory.setSortOrder(5);
    int count=productCategoryDao.addProductCategory(productCategory);
    System.out.println(count);
  }
  @Test@Ignore
  public void testUpdateProductCategory() {
  /*  ProductCategory productCategory=productCategoryDao.queryById(2);
    productCategory.setDescription("�ֻ�һ����");
    int count=productCategoryDao.updateProductCategory(productCategory);*/
   // System.out.println(count);
    ProductCategory category=new ProductCategory();
    category.setId(1);
    category.setSortOrder(6);
    productCategoryDao.updateProductCategory(category);
  }
  @Test@Ignore
  public void testQueryAll() {
    List<ProductCategory>list=productCategoryDao.queryAll(0, 10);
    System.err.println(list);
  }
  @Test@Ignore
  public void testQueryById() {
    ProductCategory productCategory=productCategoryDao.queryById(2);
    System.out.println(productCategory);
  }
  @Test@Ignore
  public void testDeleteProductCategory() {
    ProductCategory productCategory=productCategoryDao.queryById(2);
    int count=productCategoryDao.deleteProductCategory(productCategory);
    System.out.println(count);
  }
  @Test@Ignore
  public void testFuzzySearch() {
    System.out.println(productCategoryDao.fuzzyQueryAllByText("װ", 0, 10));
  }
}
