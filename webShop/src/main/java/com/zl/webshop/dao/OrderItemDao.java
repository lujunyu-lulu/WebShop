/**
 * <p>
 * Title: OrderItemDao.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��14��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.OrderItem;

/**
 * <p>
 * Title: OrderItemDao
 * </p>
 * <p>
 * Description: ������ĿDao
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��14��
 *         </p>
 */
public interface OrderItemDao {
  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description: ��ȡ������Ŀ����
   * </p>
   * 
   * @return ������Ŀ����
   */
  int count();

  /**
   * 
   * <p>
   * Title: countByOrderNum
   * </p>
   * <p>
   * Description: ���ݶ�����Ż�ȡ��Ŀ��
   * </p>
   * 
   * @param orderNum �������
   * @return ��Ŀ��
   */
  int countByOrderNum(@Param("orderNum") String orderNum);

  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ͨ���������Լ��û�����ѯ������Ŀ
   * </p>
   * 
   * @param userName �û���
   * @param orderNum �������
   * @return ������Ŀ�б�
   */
  List<OrderItem> queryByUserNameAndOrderNum(@Param("userName") String userName,
      @Param("orderNum") String orderNum);

  /**
   * 
   * <p>
   * Title: queryById
   * </p>
   * <p>
   * Description:ͨ��������Ŀ��Ų�ѯ
   * </p>
   * 
   * @param id ���
   * @return OrderItem ʵ�����
   */
  OrderItem queryById(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: addOrderItem
   * </p>
   * <p>
   * Description: ��Ӷ�����Ŀ
   * </p>
   * 
   * @param orderItem ������Ŀʵ�����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addOrderItem(@Param("orderItem") OrderItem orderItem);

  /**
   * 
   * <p>
   * Title: updateOrderItemByProduct
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ��������޸Ķ�����Ŀ�Ĳ�Ʒ��Ϣ Ps:���޸Ĳ�Ʒ������Ʒ��������Ʒ����
   * </p>
   * 
   * @param productId ��Ʒ���
   * @param orderItem ������Ŀʵ�����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateOrderItemByProduct(@Param("productId") long productId,
      @Param("orderItem") OrderItem orderItem);

  /**
   * 
   * <p>
   * Title: updateOrderItem
   * </p>
   * <p>
   * Description: ���µ���������Ŀ��Ϣ
   * </p>
   * 
   * @param orderItem ������Ŀʵ�����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateOrderItem(@Param("orderItem") OrderItem orderItem);

  /**
   * 
   * <p>
   * Title: deleteOrdetItem
   * </p>
   * <p>
   * Description: ɾ��һ��������Ŀ
   * </p>
   * 
   * @param orderItem ������Ŀʵ�����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderItem(@Param("orderItem") OrderItem orderItem);

  /**
   * 
   * <p>
   * Title: deleteOrderItemByProduct
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ�������ɾ��������Ŀ
   * </p>
   * 
   * @param productId ��Ʒ���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderItemByProduct(@Param("productId") long productId);

  /**
   * 
   * <p>
   * Title: deleteOrderItemByUserName
   * </p>
   * <p>
   * Description: �����û���ɾ��������Ŀ
   * </p>
   * 
   * @param userName �û���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderItemByUserName(@Param("userName") String userName);

  /**
   * 
   * <p>
   * Title: deleteOrderItemByOrderNum
   * </p>
   * <p>
   * Description: ���ݶ������ɾ��������Ŀ
   * </p>
   * 
   * @param orderNum �������
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderItemByOrderNum(@Param("orderNum") String orderNum);
}
