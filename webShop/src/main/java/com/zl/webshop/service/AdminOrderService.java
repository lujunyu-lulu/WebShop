/**
 * <p>
 * Title: AdminOrderService.java
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
import com.zl.webshop.dto.OrderExecution;
import com.zl.webshop.enums.OrderStatusEnum;

/**
 * <p>
 * Title: AdminOrderService
 * </p>
 * <p>
 * Description: ����Ա����ҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 */
public interface AdminOrderService {
  /**
   * 
   * <p>
   * Title: getOrderInfos
   * </p>
   * <p>
   * Description: ��ȡ������ʷ
   * </p>
   * 
   * @param searchText �����ؼ��� ѡ��
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ������ʷ��
   */
  List<OrderExecution> getOrderInfos(String searchText, int offset, int limit);

  /**
   * 
   * <p>
   * Title: getOrderDetail
   * </p>
   * <p>
   * Description: ��ȡ������ϸ��Ϣ
   * </p>
   * 
   * @param orderNum �������
   * @return ������ϸ��Ϣ
   */
  OrderExecution getOrderDetail(String orderNum);

  /**
   * 
   * <p>
   * Title: updateOrderStatus
   * </p>
   * <p>
   * Description: ���¶���״̬
   * </p>
   * 
   * @param statusEnum ����״̬
   * @param orderNum �������
   * @return ���º�Ķ�����Ϣ
   */
  OrderExecution updateOrderStatus(OrderStatusEnum statusEnum, String orderNum);

  /**
   * 
   * <p>
   * Title: deleteOrderHistory
   * </p>
   * <p>
   * Description: ɾ��������ʷ
   * </p>
   * 
   * @param orderNum �������
   * @return �������µĶ�����ʷ����
   */
  int deleteOrderHistory(String orderNum);
}
