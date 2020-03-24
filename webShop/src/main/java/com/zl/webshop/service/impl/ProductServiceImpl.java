/**
 * <p>
 * Title: ProductServiceImpl.java
 * </p>
 * <p>
 * Description: ProductService�ӿ�ʵ��
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��23��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zl.webshop.dao.ProductCategoryDao;
import com.zl.webshop.dao.ProductDao;
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.ProductCategory;
import com.zl.webshop.exception.NoCategoryException;
import com.zl.webshop.exception.NoProductException;
import com.zl.webshop.service.ProductService;
import cn.hutool.core.util.ObjectUtil;

/**
 * <p>
 * Title: ProductServiceImpl
 * </p>
 * <p>
 * Description: ��Ʒҵ��ӿ�ʵ��
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��23��
 *         </p>
 */
@Service
public class ProductServiceImpl implements ProductService {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ProductCategoryDao productCategoryDao;
  @Autowired
  private ProductDao productDao;

  @Override
  public List<ProductCategory> getCategories() {
    List<ProductCategory> productCategories = productCategoryDao.queryAll(0, 1000);
    return productCategories;
  }

  @Override
  public ProductExecution getProducts(long categoryId, int offset, int limit) {
    ProductExecution productExecution = null;
    try {
      ProductCategory productCategory = productCategoryDao.queryById(categoryId);
      if (ObjectUtil.isNull(productCategory)) {
        throw new NoCategoryException("no category");
      }
      List<Product> products = productDao.queryByCategoryId(categoryId, offset, limit);
      if (products.size() < 1) {
        throw new NoProductException("no product");
      }
      productExecution =
          new ProductExecution(categoryId, productCategory.getCategoryName(), products);
    } catch (NoCategoryException e) {
      throw e;
    } catch (NoProductException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }

    return productExecution;
  }

  @Override
  public ProductExecution searchByText(String searchText, int offset, int limit) {
    List<Product> products = productDao.fuzzyQueryAllByText(searchText, offset, limit);
    if(products.size()<1) {
      throw new NoProductException("no product");
    }
    ProductExecution productExecution=new ProductExecution(products);
    productExecution.setProductMaxCount(productDao.fuzzyCount(searchText));
    return productExecution;
  }

  @Override
  public ProductExecution getProduct(long productId, String productName) {
    ProductExecution productExecution = null;
    try {
      //��ʹ�ò�Ʒ��Ż�ȡ��Ʒ
      Product product = productDao.queryById(productId);
      if (ObjectUtil.isNull(product)) {
        //ʧ������ʹ�ò�Ʒ�����л�ȡ
        product=productDao.queryByProductName(productName).stream().findAny().get();
        if(ObjectUtil.isNull(product)) {
          throw new NoProductException("no product");
        }
      }
      ProductCategory productCategory = productCategoryDao.queryById(product.getCategoryId());
      if (ObjectUtil.isNull(productCategory)) {
        throw new NoCategoryException("product's category has been not found");
      }
      productExecution =
          new ProductExecution(productCategory.getId(), productCategory.getCategoryName(), product);
    } catch (NoCategoryException e) {
      throw e;
    } catch (NoProductException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }
    return productExecution;
  }

  @Override
  public ProductExecution getProductsRandom(long categoryId,int limit) {
    ProductExecution productExecution = null;
    try {
      ProductCategory productCategory = productCategoryDao.queryById(categoryId);
      if (ObjectUtil.isNull(productCategory)) {
        throw new NoCategoryException("no category");
      }
      List<Product> products = productDao.randomByCategoryId(categoryId, limit);
      if (products.size() < 1) {
        throw new NoProductException("no product");
      }
      productExecution =
          new ProductExecution(categoryId, productCategory.getCategoryName(), products);
    } catch (NoCategoryException e) {
      throw e;
    } catch (NoProductException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }

    return productExecution;
  }

  @Override
  public ProductExecution getProductsRandom(int limit) {
    ProductExecution productExecution = null;
    try {
      List<Product> products = productDao.randomAll(limit);
      if (products.size() < 1) {
        throw new NoProductException("no product");
      }
      productExecution =
          new ProductExecution(products);
      
    } catch (NoProductException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }
    return productExecution;
  
  }

}
