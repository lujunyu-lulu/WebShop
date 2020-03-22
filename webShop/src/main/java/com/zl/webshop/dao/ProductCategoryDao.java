/**
 * <p>
 * Title: ProductCategoryDao.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 * @date 2020��3��13��
 * @version 1.0
 */
package com.zl.webshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.ProductCategory;

/**
 * <p>
 * Title: ProductCategoryDao
 * </p>
 * <p>
 * Description: ��Ʒ����Dao
 * </p>
 * 
 * @author zyd
 * <p>�������ڣ�2020��3��13��</p>
 */
public interface ProductCategoryDao {
  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description: ��ȡ��Ʒ�������
   * </p>
   * @return ��Ʒ�������
   */
  int count();
  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ���в�Ʒ���
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ����б�
   */
  List<ProductCategory> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryById
   * </p>
   * <p>
   * Description: ʹ��id��ѯ��Ʒ���
   * </p>
   * 
   * @param id ��Ʒ������
   * @return ��Ʒ������
   */
  ProductCategory queryById(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: addProductCategory
   * </p>
   * <p>
   * Description: ���һ����Ʒ���
   * </p>
   * 
   * @param productCategory ��Ʒ������
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addProductCategory(@Param("productCategory") ProductCategory productCategory);

  /**
   * 
   * <p>
   * Title: updateProductCategory
   * </p>
   * <p>
   * Description: ����һ����Ʒ���
   * </p>
   * 
   * @param productCategory ��Ʒ������
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateProductCategory(@Param("productCategory") ProductCategory productCategory);

  /**
   * 
   * <p>
   * Title: deleteProductCategory
   * </p>
   * <p>
   * Description: ɾ��һ����Ʒ���
   * </p>
   * 
   * @param productCategory ��Ʒ������
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteProductCategory(@Param("productCategory") ProductCategory productCategory);
}
