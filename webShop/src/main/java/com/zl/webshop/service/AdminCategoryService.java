/**
 * <p>
 * Title: AdminCategoryService.java
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
import com.zl.webshop.entity.ProductCategory;

/**
 * <p>
 * Title: AdminCategoryService
 * </p>
 * <p>
 * Description: ����Ա��Ʒ����ҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 */
public interface AdminCategoryService {

  /**
   * 
   * <p>
   * Title: getCategories
   * </p>
   * <p>
   * Description: ��ȡ����
   * </p>
   * 
   * @param searchText �����ؼ��� �ɲ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return �����б�
   */
  List<ProductCategory> getCategories(String searchText, int offset, int limit);

  /**
   * 
   * <p>
   * Title: addCategory
   * </p>
   * <p>
   * Description: ����һ�����
   * </p>
   * 
   * @param category ���
   * @return ����������������
   */
  int addCategory(ProductCategory category);

  /**
   * 
   * <p>
   * Title: updateCategory
   * </p>
   * <p>
   * Description: ����һ�����
   * </p>
   * 
   * @param category ���
   * @return ���º�Ĵ���������
   */
  ProductCategory updateCategory(ProductCategory category);

  /**
   * 
   * <p>
   * Title: deleteCateGory
   * </p>
   * <p>
   * Description: ɾ��һ�����
   * </p>
   * 
   * @param category ���
   * @return ����������������
   */
  int deleteCateGory(ProductCategory category);
}
