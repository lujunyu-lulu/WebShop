/**
 * <p>
 * Title: ProductDao.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd @date 2020��3��12�� @version 1.0
 */
package com.zl.webshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.Product;

/**
 * <p>
 * Title: ProductDao
 * </p>
 * <p>
 * Description: ��Ʒ��Dao
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��12��
 *         </p>
 */
public interface ProductDao {
  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description: ��ȡ��Ʒ����
   * </p>
   * @return ��Ʒ����
   */
  int count();

  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ���в�Ʒ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��Ʒ�б�
   */
  List<Product> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: fuzzyQueryAllByText
   * </p>
   * <p>
   * Description: ģ����ѯ���в�Ʒ
   * </p>
   * 
   * @param searchText �ؼ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��Ʒ�б�
   */
  List<Product> fuzzyQueryAllByText(@Param("searchText") String searchText,
      @Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryById
   * </p>
   * <p>
   * Description: ʹ��id��ѯ������Ʒ
   * </p>
   * 
   * @param id ��Ʒ���
   * @return ��Ʒ����
   */
  Product queryById(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: queryByProductName
   * </p>
   * <p>
   * Description: ʹ�ò�Ʒ����ѯ������Ʒ
   * </p>
   * 
   * @param productName ��Ʒ��
   * @return ��Ʒ����
   */
  Product queryByProductName(@Param("productName") String productName);

  /**
   * 
   * <p>
   * Title: addProduct
   * </p>
   * <p>
   * Description: ���Ӳ�Ʒ
   * </p>
   * 
   * @param product ��Ʒ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addProduct(@Param("product") Product product);

  /**
   * 
   * <p>
   * Title: updateProduct
   * </p>
   * <p>
   * Description: ���²�Ʒ
   * </p>
   * 
   * @param product ��Ʒ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateProduct(@Param("product") Product product);

  /**
   * 
   * <p>
   * Title: deleteProduct
   * </p>
   * <p>
   * Description: ɾ����Ʒ
   * </p>
   * 
   * @param product ��Ʒ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteProduct(@Param("product") Product product);
}