/**
 * <p>
 * Title: AdminProductService.java
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
package com.zl.webshop.service;

import java.util.List;
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.entity.Product;

/**
 * <p>
 * Title: AdminProductService
 * </p>
 * <p>
 * Description: ����Ա��Ʒҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 */
public interface AdminProductService {

  /**
   * 
   * <p>
   * Title: getProducts
   * </p>
   * <p>
   * Description:
   * </p>
   * 
   * @param searchText �����ؼ��� ����ɲ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��Ʒ�б�
   */
  List<ProductExecution> getProducts(String searchText, int offset, int limit);

  /**
   * 
   * <p>
   * Title: updateProduct
   * </p>
   * <p>
   * Description: ����һ����Ʒ
   * </p>
   * 
   * @param product ��Ʒ����
   * @return ���³ɹ���Ĳ�Ʒ����
   */
  ProductExecution updateProduct(Product product);

  /**
   * 
   * <p>
   * Title: deleteProduct
   * </p>
   * <p>
   * Description: ɾ��һ����Ʒ
   * </p>
   * 
   * @param product ��Ʒ
   * @return ����������Ʒ����
   */
  ProductExecution deleteProduct(Product product);

  /**
   * 
   * <p>
   * Title: addProduct
   * </p>
   * <p>
   * Description: ����һ����Ʒ
   * </p>
   * 
   * @param product ��Ʒ
   * @return ����������Ʒ����
   */
  ProductExecution addProduct(Product product);
}
