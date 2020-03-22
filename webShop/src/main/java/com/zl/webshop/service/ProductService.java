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
import com.zl.webshop.entity.Product;
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
   * Description: ͨ�������Ż�ȡ��Ʒ
   * </p>
   * 
   * @param categoryId ��Ʒ������
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ProductExecution
   */
  ProductExecution getProducts(int categoryId, int offset, int limit);

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
  List<Product> searchByText(String searchText, int offset, int limit);
}
