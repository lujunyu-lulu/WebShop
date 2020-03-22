/**
 * <p>
 * Title: OrderInfoDao.java
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
import com.zl.webshop.entity.OrderInfo;

/**
 * <p>
 * Title: OrderInfoDao
 * </p>
 * <p>
 * Description: ������ϢDao
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��14��
 *         </p>
 */
public interface OrderInfoDao {
  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description: ��ȡ�ö�������
   * </p>
   * 
   * @return ��������
   */
  int count();

  /**
   * 
   * <p>
   * Title: countByUserName
   * </p>
   * <p>
   * Description: �����û�����ȡ��������
   * </p>
   * @param userName �û���
   *  @return ������
   */
  int countByUserName(@Param("userName") String userName);

  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ���ж�����Ϣ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ������Ϣ�б�
   */
  List<OrderInfo> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByUserName
   * </p>
   * <p>
   * Description: �����û�����ѯ������Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ������Ϣ�б�
   */
  List<OrderInfo> queryByUserName(@Param("userName") String userName, @Param("offset") int offset,
      @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByOrderNum
   * </p>
   * <p>
   * Description: ���ݶ�����Ų�ѯ������Ϣ
   * </p>
   * 
   * @param orderNum �������
   * @return OrderInfo ������Ϣ����
   */
  OrderInfo queryByOrderNum(@Param("orderNum") String orderNum);

  /**
   * 
   * <p>
   * Title: addOrderInfo
   * </p>
   * <p>
   * Description: ���һ��������Ϣ
   * </p>
   * 
   * @param orderInfo ������Ϣ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addOrderInfo(@Param("orderInfo") OrderInfo orderInfo);

  /**
   * 
   * <p>
   * Title: updateOrderInfo
   * </p>
   * <p>
   * Description: ����һ��������Ϣ
   * </p>
   * 
   * @param orderInfo ������Ϣ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateOrderInfo(@Param("orderInfo") OrderInfo orderInfo);

  /**
   * 
   * <p>
   * Title: deleteOrderInfo
   * </p>
   * <p>
   * Description: ɾ��һ��������Ϣ
   * </p>
   * 
   * @param orderInfo ������Ϣ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderInfo(@Param("orderInfo") OrderInfo orderInfo);

  /**
   * 
   * <p>
   * Title: deleteOrderInfoByUserName
   * </p>
   * <p>
   * Description: �����û���ɾ������
   * </p>
   * 
   * @param userName �û���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderInfoByUserName(@Param("userName") String userName);
}
