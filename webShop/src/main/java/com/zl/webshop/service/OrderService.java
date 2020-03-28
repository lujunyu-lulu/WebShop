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
import com.zl.webshop.enums.OrderStatusEnum;

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
   * @return ����0��ʾ��ӳɹ�
   */
  int addToCart(OrderItem orderItem, String userName);

  /**
   * 
   * <p>
   * Title: addToStar
   * </p>
   * <p>
   * Description: �����Ʒ���ղؼ�
   * </p>
   * 
   * @param orderItem ��Ʒ
   * @param userName �û���
   * @return ����0��ʾ��ӳɹ�
   */
  int addToStar(OrderItem orderItem, String userName);

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
   * @return ����0��ʾ��ӳɹ�
   */
  int removeFromCart(OrderItem orderItem, String userName);

  /**
   * 
   * <p>
   * Title: removeFromStar
   * </p>
   * <p>
   * Description: ���ղؼ���ɾ��һ����Ʒ
   * </p>
   * 
   * @param orderItem ��Ʒ�Լ���������
   * @param userName �û���
   * @return ����0��ʾ��ӳɹ�
   */
  int removeFromStar(OrderItem orderItem, String userName);

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
   * @return ����0��ʾ���³ɹ�
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
  OrderExecution buyOneNow(OrderItem orderItem, String userName, Contact contact, String message);

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

  /**
   * 
   * <p>
   * Title: getStar
   * </p>
   * <p>
   * Description: ��ȡ�ղؼ��б�
   * </p>
   * 
   * @param userName �û���
   * @return OrderExecution
   */
  OrderExecution getStar(String userName);

  /**
   * 
   * <p>
   * Title: getOderInfoByUserName
   * </p>
   * <p>
   * Description: �����û�������ѯ������Ϣ��ͬʱ֧��ʹ�� OrderStatusEnum �����˶���
   * </p>
   * 
   * @param userName �û���
   * @param status ����״̬
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return OrderExecution
   */
  OrderExecution getOderInfoByUserName(String userName, OrderStatusEnum status, int offset,
      int limit);

  /**
   * 
   * <p>
   * Title: getOrderDetail
   * </p>
   * <p>
   * Description: ��ȡ�˶�����ŵ���ϸ��Ϣ
   * </p>
   * 
   * @param orderNum �������
   * @param userName �û���
   * @return OrderExecution
   */
  OrderExecution getOrderDetail(String orderNum,String userName);

  /**
   * 
   * <p>
   * Title: deleteOrder
   * </p>
   * <p>
   * Description: ɾ���йش˶�����һ����Ϣ
   * </p>
   * @param orderNum ������� 
   * @return ����0��ʾɾ���ɹ�
   */
  int deleteOrder(String orderNum);
}
