/**
 * <p>
 * Title: ProductService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��16��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service;

import java.util.List;
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.entity.ProductCategory;

/**
 * <p>
 * Title: ProductService
 * </p>
 * <p>
 * Description: ��Ʒҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��16��
 *         </p>
 */
public interface ProductService {
  /**
   * 
   * <p>
   * Title: getCategories
   * </p>
   * <p>
   * Description: ��ȡ���в�Ʒ���
   * </p>
   * 
   * @return ���в�Ʒ���
   */
  List<ProductCategory> getCategories();

  /**
   * 
   * <p>
   * Title: getProducts
   * </p>
   * <p>
   * Description: ͨ�������Ż�ȡ��Ʒ�б�
   * </p>
   * 
   * @param categoryId ��Ʒ������
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ProductExecution
   */
  ProductExecution getProducts(long categoryId, int offset, int limit);

  /**
   * 
   * <p>
   * Title: getProductsRandom
   * </p>
   * <p>
   * Description: ͨ�������Ż�ȡ�����Ʒ�б�
   * </p>
   * 
   * @param categoryId ��Ʒ������
   * @param limit ��ѯ����
   * @return ProductExecution
   */
  ProductExecution getProductsRandom(long categoryId, int limit);

  /**
   * 
   * <p>
   * Title: getProductsRandom
   * </p>
   * <p>
   * Description: �����ȡ��Ʒ�б�
   * </p>
   * 
   * @param limit ��ѯ����
   * @return ProductExecution
   */
  ProductExecution getProductsRandom(int limit);

  /**
   * 
   * <p>
   * Title: searchByText
   * </p>
   * <p>
   * Description: ͨ���ؼ��ʻ�ò�Ʒ
   * </p>
   * 
   * @param searchText �����ؼ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��Ʒ�б�
   */
  ProductExecution searchByText(String searchText, int offset, int limit);

  /**
   * 
   * <p>
   * Title: getProduct
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ��Ż��߲�Ʒ����ȡ��Ʒ��������Ȼ�ȡ����ȡʧ����ͨ����Ʒ����ȡ
   * </p>
   * 
   * @param productId ��Ʒ���
   * @param productName ��Ʒ��
   * @return ProductExecution
   */
  ProductExecution getProduct(long productId, String productName);

}
