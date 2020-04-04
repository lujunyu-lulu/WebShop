/**
 * <p>
 * Title: AdminProductServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zl.webshop.dao.ProductCategoryDao;
import com.zl.webshop.dao.ProductDao;
import com.zl.webshop.dao.ProductImageDao;
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.ProductCategory;
import com.zl.webshop.entity.ProductImage;
import com.zl.webshop.service.AdminProductService;
import com.zl.webshop.service.FileService;

/**
 * <p>
 * Title: AdminProductServiceImpl
 * </p>
 * <p>
 * Description: ����Ա��Ʒҵ��ӿ�ʵ��
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 */
@Service
public class AdminProductServiceImpl implements AdminProductService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ProductDao productDao;
  @Autowired
  private ProductCategoryDao productCategoryDao;
  @Autowired
  private ProductImageDao productImageDao;
  @Autowired
private FileService fileService;
  @Override
  public List<ProductExecution> getProducts(String searchText, int offset, int limit) {
    // ��ȡ��Ʒ�����
    List<Product> products = productDao.fuzzyQueryAllByText(searchText, offset, limit);
    List<ProductCategory> categories = new ArrayList<ProductCategory>();
    products.stream().forEach(x -> categories.add(productCategoryDao.queryById(x.getCategoryId())));
    // ���뷵�ؽ��
    List<ProductExecution> result = new ArrayList<ProductExecution>();
    ProductExecution productExecution = null;
    for (int i = 0; i < products.size(); ++i) {
      productExecution = new ProductExecution(categories.get(i).getId(),
          categories.get(i).getCategoryName(), products.get(i));
      //��ȡ��Ʒ������ͼƬ
      productExecution.setProductImages(productImageDao.queryByProductId(products.get(i).getId()));
      result.add(productExecution);
    }
    return result;
  }


  @Override@Transactional(rollbackFor = RuntimeException.class)
  public ProductExecution updateProduct(Product product,List<ProductImage>otherImages) {
    ProductExecution productExecution = null;
    Product oldProduct=null;
    List<ProductImage>oldImages=null;
    try {
      //��ȡ�ɲ�Ʒ����
      oldProduct=productDao.queryById(product.getId());
      oldImages=productImageDao.queryByProductId(product.getId());
      //�ȸ��²�Ʒ�����������ʼ����ͼƬ�ļ�
      productDao.updateProduct(product);
      //��ɾ��ͼƬ��ԭ��ͼƬ���������ͼƬ�����ɾ��ԭ��ͼƬ�������ļ�
      if(otherImages.size()>0) {
        productImageDao.deleteByProductId(product.getId());
        otherImages.stream().forEach(x->{
          x.setProductId(product.getId());
          productImageDao.addImage(x);});
        oldImages.stream().forEach(x->fileService.deleteFile(x.getImage()));
      }
    //������ͼƬ ɾ������ͼƬ
      if(product.getImage()!=null&&oldProduct.getImage()!=null) {
        fileService.deleteFile(oldProduct.getImage());
      }
     
      //װ��ؽ��
      ProductCategory category = productCategoryDao.queryById(product.getCategoryId());
      productExecution = new ProductExecution(category.getId(), category.getCategoryName(),
          productDao.queryById(product.getId()));
      productExecution.setProductImages(productImageDao.queryByProductId(product.getId()));
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return productExecution;
  }


  @Override@Transactional(rollbackFor = RuntimeException.class)
  public ProductExecution deleteProduct(Product product) {
    ProductExecution productExecution = null;
    Product oldProduct=null;
    try {
      //��ȡ�й���Ʒ��ͼƬ��Ϣ
      oldProduct=productDao.queryById(product.getId());
      List<ProductImage>images=productImageDao.queryByProductId(product.getId());
      //ɾ����������
      productImageDao.deleteByProductId(product.getId());
      productDao.deleteProduct(product);
      //��ɾ����ɹ���ִ��ɾ���ļ�����
      images.stream().forEach(x->fileService.deleteFile(x.getImage()));
      if(oldProduct.getImage()!=null) {
        fileService.deleteFile(oldProduct.getImage());
      }
      int count = productDao.count();
      productExecution = new ProductExecution();
      productExecution.setProductMaxCount(count);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return productExecution;
  }


  @Override@Transactional(rollbackFor = RuntimeException.class)
  public ProductExecution addProduct(Product product) {
    ProductExecution productExecution = null;
    try {
      //�����Ʒ����ƷͼƬ
      productDao.addProduct(product);
      //װ��ؽ��
      productExecution = new ProductExecution();
      productExecution.setProductMaxCount(productDao.count());
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return productExecution;
  }


  @Override
  public ProductExecution addOtherImages(Product product, List<ProductImage> otherImages) {
    ProductExecution productExecution = null;
    try {
      //�����ͼƬ
     otherImages.stream().forEach(x->{
       x.setProductId(product.getId());
       productImageDao.addImage(x);
     });
      
      ProductCategory category = productCategoryDao.queryById(product.getCategoryId());
      productExecution = new ProductExecution(category.getId(), category.getCategoryName(),
          productDao.queryById(product.getId()));
      productExecution.setProductImages(productImageDao.queryByProductId(productExecution.getProduct().getId()));
      productExecution.setProductMaxCount(productDao.count());
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return productExecution;
  }


  @Override
  public ProductExecution deleteOtherImages(Product product) {
    ProductExecution productExecution = null;
    try {
      productImageDao.deleteByProductId(product.getId());
      ProductCategory category = productCategoryDao.queryById(product.getCategoryId());
      productExecution = new ProductExecution(category.getId(), category.getCategoryName(),
          productDao.queryById(product.getId()));
      productExecution.setProductImages(productImageDao.queryByProductId(productExecution.getProduct().getId()));
      productExecution.setProductMaxCount(productDao.count());
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return productExecution;
  }


  @Override
  public ProductExecution updateOtherImages(Product product, List<ProductImage> otherImages) {
    ProductExecution productExecution = null;
    
    try {
     
      if(otherImages.size()>0) {
        //��ȡԭ��ͼƬ����ɾ�������ļ�
        List<ProductImage> oldImages=productImageDao.queryByProductId(product.getId());
        //ɾ��ԭ��ͼƬ�����������ͼƬ
        productImageDao.deleteByProductId(product.getId());
        otherImages.stream().forEach(x->productImageDao.addImage(x));
        //ɾ��ԭ��ͼƬ�������ļ�
        oldImages.stream().forEach(x->fileService.deleteFile(x.getImage()));
      }
     //װ����
      ProductCategory category = productCategoryDao.queryById(product.getCategoryId());
      productExecution = new ProductExecution(category.getId(), category.getCategoryName(),
          productDao.queryById(product.getId()));
      productExecution.setProductImages(productImageDao.queryByProductId(productExecution.getProduct().getId()));
      productExecution.setProductMaxCount(productDao.count());
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return productExecution;
  }

}
