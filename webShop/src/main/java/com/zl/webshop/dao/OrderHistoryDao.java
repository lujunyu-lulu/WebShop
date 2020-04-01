/**
 * <p>
 * Title: OrderHistoryDao.java
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
import com.zl.webshop.entity.OrderHistory;

/**
 * <p>
 * Title: OrderHistoryDao
 * </p>
 * <p>
 * Description: ������ʷ��Dao
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ� 2020��3��14��
 *         </p>
 */
public interface OrderHistoryDao {
  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description: ��ȡ�ö�����ʷ����
   * </p>
   * 
   * @return ������ʷ����
   */
  int count();

  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ���ж�����ʷ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ������ʷ�б�
   */
  List<OrderHistory> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryAllByUpdateUserName
   * </p>
   * <p>
   * Description: ��ѯ�˸������������ж�����ʷ
   * </p>
   * 
   * @param updateUserName ��������
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ������ʷ�б�
   */
  List<OrderHistory> queryAllByUpdateUserName(@Param("updateUserName") String updateUserName,
      @Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByOrderNum
   * </p>
   * <p>
   * Description: ͨ��������Ų�ѯ������ʷ
   * </p>
   * 
   * @param orderNum �������
   * @return ������ʷ����
   */
  OrderHistory queryByOrderNum(@Param("orderNum") String orderNum);

  /**
   * 
   * <p>
   * Title: queryById
   * </p>
   * <p>
   * Description: ͨ��id��ѯ������ʷ
   * </p>
   * 
   * @param id ���
   * @return ������ʷ����
   */
  OrderHistory queryById(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: addOrderHistory
   * </p>
   * <p>
   * Description: ����һ��������ʷ
   * </p>
   * 
   * @param orderHistory ������ʷ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addOrderHistory(@Param("orderHistory") OrderHistory orderHistory);

  /**
   * 
   * <p>
   * Title: updateOrderHistory
   * </p>
   * <p>
   * Description: ����һ��������ʷ
   * </p>
   * 
   * @param orderHistory ������ʷ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateOrderHistory(@Param("orderHistory") OrderHistory orderHistory);

  /**
   * 
   * <p>
   * Title: deleteOrderHistory
   * </p>
   * <p>
   * Description: ɾ��һ��������ʷ
   * </p>
   * 
   * @param orderHistory ������ʷ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteOrderHistory(@Param("orderHistory") OrderHistory orderHistory);

  /**
   * 
   * <p>
   * Title: deleteByOrderNum
   * </p>
   * <p>
   * Description: ���ݶ������ɾ��������ʷ
   * </p>
   * 
   * @param orderNum �������
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteByOrderNum(@Param("orderNum") String orderNum);

  /**
   * 
   * <p>
   * Title: fuzzyQueryAllByText
   * </p>
   * <p>
   * Description: ģ����ѯ���в�Ʒ
   * </p>
   * 
   * @param searchText �ؼ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��Ʒ�б�
   */
  List<OrderHistory> fuzzyQueryAllByText(@Param("searchText") String searchText,
      @Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: fuzzyCount
   * </p>
   * <p>
   * Description: ��ȡģ����ѯ�ĸ���
   * </p>
   * 
   * @param searchText �����ؼ���
   * @return ����
   */
  int fuzzyCount(@Param("searchText") String searchText);
}
