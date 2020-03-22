/**
 * <p>
 * Title: OrderService.java
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

import com.zl.webshop.dto.OrderExecution;
import com.zl.webshop.entity.Contact;
import com.zl.webshop.entity.OrderItem;

/**
 * <p>
 * Title: OrderService
 * </p>
 * <p>
 * Description: ����ҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��16��
 *         </p>
 */
public interface OrderService {
  /**
   * 
   * <p>
   * Title: addToCart
   * </p>
   * <p>
   * Description: �����Ʒ�빺�ﳵ
   * </p>
   * 
   * @param orderItem ��Ʒ�Լ���������
   * @param userName �û���
   * @return ���ڵ���0��ʾ��ӳɹ�
   */
  int addToCart(OrderItem orderItem, String userName);

  /**
   * 
   * <p>
   * Title: removeFromCart
   * </p>
   * <p>
   * Description: ɾ��һ����Ʒ�ӹ��ﳵ��
   * </p>
   * 
   * @param orderItem ��Ʒ�Լ���������
   * @param userName �û���
   * @return ���ڵ���0��ʾ��ӳɹ�
   */
  int removeFromCart(OrderItem orderItem, String userName);

  /**
   * 
   * <p>
   * Title: updateProductQuantityInCart
   * </p>
   * <p>
   * Description: �����ڹ��ﳵ�е���Ʒ����
   * </p>
   * 
   * @param orderItem ��Ʒ��Ŀ
   * @param userName �û���
   * @return ���ڵ���0��ʾ���³ɹ�
   */
  int updateProductQuantityInCart(OrderItem orderItem, String userName);

  /**
   * 
   * <p>
   * Title: buyOneNow
   * </p>
   * <p>
   * Description: �����µ�����һ����Ʒ
   * </p>
   * 
   * @param orderItem ��Ʒ��Ŀ
   * @param userName �û���
   * @param contact ��ϵ��Ϣ
   * @param message ��ע
   * @return OrderExecution
   */
  OrderExecution buyOneNow(OrderItem orderItem, String userName, Contact contact,String message);

  /**
   * 
   * <p>
   * Title: buyGoods
   * </p>
   * <p>
   * Description: ����ѡ���ĸ�����Ʒ
   * </p>
   * 
   * @param orderExecution ����DTO ������Ʒ�嵥������û���Ϣ
   * @return OrderExecution
   */
  OrderExecution buyGoods(OrderExecution orderExecution);

  /**
   * 
   * <p>
   * Title: getCart
   * </p>
   * <p>
   * Description: ��ȡ���ﳵ����
   * </p>
   * 
   * @param userName �û���
   * @return OrderExecution
   */
  OrderExecution getCart(String userName);
}
