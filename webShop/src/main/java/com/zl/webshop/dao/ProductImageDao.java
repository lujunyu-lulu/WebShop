/**
 * <p>
 * Title: ProductImageDao.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��3��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.ProductImage;

/**
 * <p>
 * Title: ProductImageDao
 * </p>
 * <p>
 * Description: ��ƷͼƬ��Dao
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��3��
 *         </p>
 */
public interface ProductImageDao {

  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description:��ȡͼƬ����
   * </p>
   * 
   * @return ͼƬ����
   */
  int count();

  /**
   * 
   * <p>
   * Title: countByProductId
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ��ż���ͼƬ����
   * </p>
   * 
   * @param productId ��Ʒ���
   * @return ͼƬ����
   */
  int countByProductId(@Param("productId") long productId);

  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ȡ����ͼƬ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ͼƬ�б�
   */
  List<ProductImage> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByProductId
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ��Ż�ȡͼƬ
   * </p>
   * 
   * @param productId ��Ʒ���
   * @return ͼƬ�б�
   */
  List<ProductImage> queryByProductId(@Param("productId") long productId);

  /**
   * 
   * <p>
   * Title: deleteImage
   * </p>
   * <p>
   * Description: �������ɾ��ͼƬ
   * </p>
   * 
   * @param id ���
   * @return ���ڵ���1��ʾɾ���ɹ�
   */
  int deleteImage(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: deleteByProductId
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ�������ɾ��ͼƬ
   * </p>
   * 
   * @param productId ��Ʒ���
   * @return ���ڵ���1��ʾɾ���ɹ�
   */
  int deleteByProductId(@Param("productId") long productId);

  /**
   * 
   * <p>
   * Title: addImage
   * </p>
   * <p>
   * Description: ���һ��ͼƬ
   * </p>
   * 
   * @param productImage ��ƷͼƬ����
   * @return ���ڵ���1��ʾ��ӳɹ�
   */
  int addImage(@Param("productImage") ProductImage productImage);

  /**
   * 
   * <p>
   * Title: updateImage
   * </p>
   * <p>
   * Description: ���´���ű����ͼƬ
   * </p>
   * 
   * @param id ���
   * @param image ͼƬ
   * @return ���ڵ���1��ʾ���³ɹ�
   */
  int updateImage(@Param("id") long id, @Param("image") String image);
}
