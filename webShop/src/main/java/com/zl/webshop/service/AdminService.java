/**
 * <p>
 * Title: AdminService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��19��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service;

import java.util.List;
import com.zl.webshop.dto.OrderExecution;
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.dto.UserExecution;
import com.zl.webshop.entity.Contact;
import com.zl.webshop.entity.OrderHistory;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.ProductCategory;
import com.zl.webshop.entity.User;
import com.zl.webshop.enums.OrderStatusEnum;
import com.zl.webshop.enums.UserRolesEnum;

/**
 * <p>
 * Title: AdminService
 * </p>
 * <p>
 * Description: ����Աҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��19��
 *         </p>
 */
public interface AdminService {
  /**
   * 
   * <p>
   * Title: login
   * </p>
   * <p>
   * Description: ����Ա��¼
   * </p>
   * 
   * @param admin ����Ա
   * @return ��¼�ɹ�����true
   */
  boolean login(User admin);

  /**
   * 
   * <p>
   * Title: getCategories
   * </p>
   * <p>
   * Description:
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return �����б�
   */
  List<ProductCategory> getCategories(int offset, int limit);

  /**
   * 
   * <p>
   * Title: addProductCategory
   * </p>
   * <p>
   * Description: ���һ���µķ���
   * </p>
   * 
   * @param category ��Ʒ���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addProductCategory(ProductCategory category);

  /**
   * 
   * <p>
   * Title: deleteProductCategory
   * </p>
   * <p>
   * Description: ɾ��һ�����࣬ͬʱԭ�������Ĳ�Ʒ������������
   * </p>
   * 
   * @param category ���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteProductCategory(ProductCategory category);

  /**
   * 
   * <p>
   * Title: updateProductCategory
   * </p>
   * <p>
   * Description: ����һ�����
   * </p>
   * 
   * @param category ���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateProductCategory(ProductCategory category);

  /**
   * 
   * <p>
   * Title: getProductsByCategory
   * </p>
   * <p>
   * Description: ���ݷ����ȡ��Ʒ
   * </p>
   * 
   * @param categoryId ��Ʒ������
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ProductExecution
   */
  ProductExecution getProductsByCategory(int categoryId, int offset, int limit);

  /**
   * 
   * <p>
   * Title: getProducts
   * </p>
   * <p>
   * Description: ��ȡ��Ʒ�б�
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ProductExecution
   */
  ProductExecution getProducts(int offset, int limit);

  /**
   * 
   * <p>
   * Title: getProduct
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ��Ż��һ����Ʒ�������Ϣ
   * </p>
   * 
   * @param productId ��Ʒ���
   * @return ProductExecution
   */
  ProductExecution getProduct(long productId);

  /**
   * 
   * <p>
   * Title: updateProduct
   * </p>
   * <p>
   * Description: ����һ��������Ʒ
   * </p>
   * 
   * @param products ��Ʒ�б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateProduct(Product... products);

  /**
   * 
   * <p>
   * Title: deleteProduct
   * </p>
   * <p>
   * Description: ɾ��һ��������Ʒ
   * </p>
   * 
   * @param products ��Ʒ�б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteProduct(Product... products);

  /**
   * 
   * <p>
   * Title: addProduct
   * </p>
   * <p>
   * Description: ���һ��������Ʒ
   * </p>
   * 
   * @param products ��Ʒ�б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addProduct(Product... products);

  /**
   * 
   * <p>
   * Title: getUsers
   * </p>
   * <p>
   * Description: ��ȡ�û�
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return UserExecution
   */
  UserExecution getUsers(int offset, int limit);

  /**
   * 
   * <p>
   * Title: getUsersByRole
   * </p>
   * <p>
   * Description: ����Ȩ�޻�ȡ�û�
   * </p>
   * 
   * @param role �û�Ȩ��
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return UserExecution
   */
  UserExecution getUsersByRole(UserRolesEnum role, int offset, int limit);

  /**
   * 
   * <p>
   * Title: getUser
   * </p>
   * <p>
   * Description: �����û�����ȡ�û������Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return UserExecution
   */
  UserExecution getUser(String userName);

  /**
   * 
   * <p>
   * Title: updateUser
   * </p>
   * <p>
   * Description: ����һ�������û���Ϣ
   * </p>
   * 
   * @param users �û��б� 
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateUser(User... users);

  /**
   * 
   * <p>
   * Title: deleteUser
   * </p>
   * <p>
   * Description: ɾ��һ�������û���Ϣ
   * </p>
   * 
   * @param users �û��б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteUser(User... users);

  /**
   * 
   * <p>
   * Title: addUser
   * </p>
   * <p>
   * Description: ���һ�������û���Ϣ
   * </p>
   * 
   * @param users �û��б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addUser(User... users);

  /**
   * 
   * <p>
   * Title: getOrderInfo
   * </p>
   * <p>
   * Description: �����û����Ͷ�����Ż�ȡ�˶��������Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param orderNum �������
   * @return OrderExecution
   */
  OrderExecution getOrderInfo(String userName, String orderNum);

  /**
   * 
   * <p>
   * Title: getOrderItem
   * </p>
   * <p>
   * Description: �����û����Ͷ�����Ż�ȡ������Ŀ
   * </p>
   * 
   * @param userName �û���
   * @param orderNum �������
   * @return OrderExecution
   */
  OrderExecution getOrderItem(String userName, String orderNum);

  /**
   * 
   * <p>
   * Title: getOrderInfoIem
   * </p>
   * <p>
   * Description: �����û�����ȡ������Ϣ�Ͷ�����Ŀ��Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param orderNum �������
   * @return OrderExecution
   */
  OrderExecution getOrderInfoIem(String userName, String orderNum);

  /**
   * 
   * <p>
   * Title: getOrderHistories
   * </p>
   * <p>
   * Description: ��ȡ������ʷ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ������ʷ�б�
   */
  List<OrderHistory> getOrderHistories(int offset, int limit);

  /**
   * 
   * <p>
   * Title: updateOrderStatus
   * </p>
   * <p>
   * Description: ���¶���״̬
   * </p>
   * 
   * @param orderNum �������
   * @param status ����״̬
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateOrderStatus(String orderNum, OrderStatusEnum status);

  /**
   * 
   * <p>
   * Title: updateOrderItem
   * </p>
   * <p>
   * Description: �����й��������Ʒ�Ķ�����Ŀ��Ϣ,��������˼۸��ǻ�Ѷ�����Ϣ���ܽ��������
   * </p>
   * 
   * @param product ��Ʒ
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateOrderItem(Product product);

  /**
   * 
   * <p>
   * Title: deleteOrderInfo
   * </p>
   * <p>
   * Description:ɾ��һ������
   * </p>
   * 
   * @param orderNum �������
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderInfo(String orderNum);

  /**
   * 
   * <p>
   * Title: deleteOrderItem
   * </p>
   * <p>
   * Description: ɾ���˶�������µ����ж�����Ŀ
   * </p>
   * 
   * @param orderNum ������Ŀ
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderItem(String orderNum);

  /**
   * 
   * <p>
   * Title: deleteOrderHistory
   * </p>
   * <p>
   * Description: ���ݶ������ɾ��������ʷ
   * </p>
   * 
   * @param orderNum �������
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderHistory(String orderNum);

  /**
   * 
   * <p>
   * Title: addOrderHistory
   * </p>
   * <p>
   * Description: ���һ��������ʷ
   * </p>
   * 
   * @param orderHistory ������ʷ
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addOrderHistory(OrderHistory orderHistory);

  /**
   * 
   * <p>
   * Title: getContacts
   * </p>
   * <p>
   * Description: ��ȡ������ϵ��Ϣ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ϵ��Ϣ�б�
   */
  List<Contact> getContacts(int offset, int limit);

  /**
   * 
   * <p>
   * Title: updateContact
   * </p>
   * <p>
   * Description: ����һ��������ϵ��Ϣ
   * </p>
   * 
   * @param contacts ��ϵ��Ϣ�б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateContact(Contact... contacts);

  /**
   * 
   * <p>
   * Title: deleteContact
   * </p>
   * <p>
   * Description: ɾ��һ��������ϵ��Ϣ
   * </p>
   * 
   * @param contacts ��ϵ��Ϣ�б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteContact(Contact... contacts);

  /**
   * 
   * <p>
   * Title: addContact
   * </p>
   * <p>
   * Description: ���һ��������ϵ��Ϣ
   * </p>
   * 
   * @param contacts ��ϵ��Ϣ�б�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addContact(Contact... contacts);
}
