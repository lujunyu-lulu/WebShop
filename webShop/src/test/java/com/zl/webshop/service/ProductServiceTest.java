/** 
�� * <p>Title: ProductServiceTest.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��23�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.zl.webshop.BaseTest;

/** 
�� * <p>Title: ProductServiceTest</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��23�� </p>
*/
public class ProductServiceTest extends BaseTest{

  @Autowired
  private ProductService productService;
  
  @Test
  public void testGetCategories() {
    System.out.println(productService.getCategories()); 
  }
  @Test
  public void testGetProducts() {
    System.out.println(productService.getProducts(1, 0, 1000));
  }
  @Test
  public void testSearchByText() {
    System.out.println(productService.searchByText("����", 0, 1000));
  }
  @Test@Ignore
  public void testGetProduct() {
    System.out.println(productService.getProduct(8, "��������"));
  }
}
