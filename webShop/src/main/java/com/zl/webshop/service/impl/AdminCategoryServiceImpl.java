package com.zl.webshop.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zl.webshop.dao.ProductCategoryDao;
import com.zl.webshop.entity.ProductCategory;
import com.zl.webshop.service.AdminCategoryService;

/**
 * 
 * <p>
 * Title: AdminCategoryServiceImpl
 * </p>
 * <p>
 * Description: ����Ա����ҵ��ӿ�ʵ��
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��31��
 * </p>
 */
@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ProductCategoryDao categoryDao;

  @Override
  public List<ProductCategory> getCategories(String searchText, int offset, int limit) {
    return categoryDao.fuzzyQueryAllByText(searchText, offset, limit);
  }

  @Override
  public int addCategory(ProductCategory category) {
    int count = 0;
    try {
      categoryDao.addProductCategory(category);
      count = categoryDao.count();
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }
    return count;
  }

  @Override
  public ProductCategory updateCategory(ProductCategory category) {
    ProductCategory resultCategory = null;
    try {
      categoryDao.updateProductCategory(category);
      resultCategory = categoryDao.queryById(category.getId());
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }
    return resultCategory;
  }

  @Override
  public int deleteCateGory(ProductCategory category) {
    int count = 0;
    try {
      categoryDao.deleteProductCategory(category);
      count = categoryDao.count();
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }
    return count;
  }

}
