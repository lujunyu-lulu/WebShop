/** 
�� * <p>Title: AdminCategoryServiceTest.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.zl.webshop.BaseTest;
import com.zl.webshop.entity.ProductCategory;

/** 
�� * <p>Title: AdminCategoryServiceTest</p> 
�� * <p>Description: ������������</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
*/
public class AdminCategoryServiceTest extends BaseTest{

  @Autowired
  private AdminCategoryService categoryService;
  @Test@Ignore
  public void testGetCategories() {
    categoryService.getCategories(null, 0, 20).forEach(System.out::println);
  }
  @Test@Ignore
  public void testUpdateCategory() {
    ProductCategory category=new ProductCategory();
    category.setId(41);
    category.setDescription("��������");
    categoryService.updateCategory(category);
  }
  @Test@Ignore
  public void testDeleteCateGory() {
    ProductCategory category=new ProductCategory();
    category.setId(41);
    categoryService.deleteCateGory(category);
  }
  @Test@Ignore
  public void testAddCategory() {
    ProductCategory category=new ProductCategory();
    category.setCategoryName("ҵ�����");
    category.setSortOrder(123);
    categoryService.addCategory(category);
  }
}
