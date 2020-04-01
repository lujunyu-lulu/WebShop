package com.zl.webshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zl.webshop.dao.OrderHistoryDao;
import com.zl.webshop.dao.OrderInfoDao;
import com.zl.webshop.dao.OrderItemDao;
import com.zl.webshop.dto.OrderExecution;
import com.zl.webshop.entity.OrderHistory;
import com.zl.webshop.entity.OrderInfo;
import com.zl.webshop.enums.OrderStatusEnum;
import com.zl.webshop.service.AdminOrderService;

/**
 * 
 * <p>
 * Title: AdminOrderServiceImpl
 * </p>
 * <p>
 * Description: ����Ա����ҵ��ӿ�ʵ��
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��1��
 *         </p>
 */
@Service
public class AdminOrderServiceImpl implements AdminOrderService {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private OrderInfoDao orderInfoDao;
  @Autowired
  private OrderHistoryDao orderHistoryDao;
  @Autowired
  private OrderItemDao orderItemDao;

  @Override
  public List<OrderExecution> getOrderInfos(String searchText, int offset, int limit) {
    List<OrderExecution> list = new ArrayList<OrderExecution>();

    for (OrderHistory orderHistory : orderHistoryDao.fuzzyQueryAllByText(searchText, offset,
        limit)) {
      OrderInfo orderInfo = orderInfoDao.queryByOrderNum(orderHistory.getOrderNum());
      list.add(new OrderExecution(orderInfo, OrderStatusEnum.stateOf(orderInfo.getStatus())));
    }
    return list;
  }

  @Override
  public OrderExecution getOrderDetail(String orderNum) {
    // ����
    return null;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public OrderExecution updateOrderStatus(OrderStatusEnum statusEnum, String orderNum) {
    OrderExecution orderExecution = null;
    try {
      // ���¶���״̬
      OrderInfo orderInfo = new OrderInfo();
      orderInfo.setOrderNum(orderNum);
      orderInfo.setStatus(statusEnum.getState());
      orderInfoDao.updateOrderInfo(orderInfo);
      // ���¶�����ʷ״̬
      OrderHistory orderHistory = new OrderHistory();
      orderHistory.setOrderNum(orderNum);
      orderHistory.setStatus(statusEnum.getState());
      orderHistoryDao.updateOrderHistory(orderHistory);
      // ���ظ��º�Ķ�����Ϣ
      orderExecution = new OrderExecution();
      orderExecution.setOrderInfo(orderInfoDao.queryByOrderNum(orderNum));
      orderExecution.setState(orderExecution.getOrderInfo().getStatus());
      orderExecution.setStateInfo(
          OrderStatusEnum.stateOf(orderExecution.getOrderInfo().getStatus()).getStateInfo());
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return orderExecution;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public int deleteOrderHistory(String orderNum) {
    int count = 0;
    try {
      // ɾ��������Ŀ
      orderItemDao.deleteOrderItemByOrderNum(orderNum);
      // ɾ��������ʷ
      orderHistoryDao.deleteByOrderNum(orderNum);
      // ɾ������
      orderInfoDao.deleteByOrderNum(orderNum);
      // ��ȡ��������
      count = orderHistoryDao.count();

    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return count;
  }

}
