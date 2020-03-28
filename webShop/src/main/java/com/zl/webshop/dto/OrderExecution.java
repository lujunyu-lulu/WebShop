/**
 * <p>
 * Title: OrderExecution.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��15��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.dto;

import java.util.List;
import com.zl.webshop.entity.OrderInfo;
import com.zl.webshop.entity.OrderItem;
import com.zl.webshop.entity.Product;
import com.zl.webshop.enums.OrderStatusEnum;

/**
 * <p>
 * Title: OrderExecution
 * </p>
 * <p>
 * Description: �����˶�����Ϣ������û����Լ�������Ŀ�б�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��15��
 *         </p>
 */
public class OrderExecution {
  /**
   * �������
   */
  private String orderNum;
  /**
   * �û���
   */
  private String userName;
  /**
   * ����״̬��Ϣ
   */
  private String stateInfo;
  /**
   * ����״̬ö������
   */
  private int state;
  /**
   * ������Ŀ�б�
   */
  private List<OrderItem> orderItemList;
  private List<Product> productList;
  /**
   * ������Ϣ
   */
  private OrderInfo orderInfo;
  /**
   * �����б�
   */
  private List<OrderInfo> orderInfos;

  /**
   * 
   * <p>
   * Title:OrderExecution ��ȡ����ʧ�ܵĹ�����
   * </p>
   * <p>
   * Description:��ȡ������Ϣʧ�ܣ������涩����ź��û���
   * </p>
   * 
   * @param orderNum �������
   * @param userName �û���
   */
  public OrderExecution(String orderNum, String userName) {
    setOrderNum(orderNum);
    setUserName(userName);
  }

  /**
   * 
   * <p>
   * Title:
   * </p>
   * <p>
   * Description: ������Ϣ�Ĺ�����
   * </p>
   * 
   * @param orderInfo ������Ϣ
   * @param orderStatusEnum ����״̬
   */
  public OrderExecution(OrderInfo orderInfo, OrderStatusEnum orderStatusEnum) {
    setOrderInfo(orderInfo);
    setOrderNum(orderInfo.getOrderNum());
    setUserName(orderInfo.getUserName());
    setState(orderStatusEnum.getState());
    setStateInfo(orderStatusEnum.getStateInfo());
  }

  /**
   * 
   * <p>
   * Title: OrderExecution ��ȡ�����ɹ��Ĺ�����
   * </p>
   * <p>
   * Description: ��ȡ������Ϣ�ɹ������涩�����������Ϣ
   * </p>
   * 
   * @param orderInfo ������Ϣ
   * @param orderItems ������Ŀ�б�
   * @param orderStatusEnum ����״̬
   * @param products ��Ŀ��Ӧ�Ĳ�Ʒ��Ϣ
   */
  public OrderExecution(OrderInfo orderInfo, List<OrderItem> orderItems, List<Product> products,
      OrderStatusEnum orderStatusEnum) {
    setOrderInfo(orderInfo);
    setOrderItemList(orderItems);
    setProductList(products);
    setOrderNum(orderInfo.getOrderNum());
    setUserName(orderInfo.getUserName());
    setState(orderStatusEnum.getState());
    setStateInfo(orderStatusEnum.getStateInfo());
  }

  /**
   * 
   * <p>
   * Title: ��ȡ�����ɹ��Ĺ�����2
   * </p>
   * <p>
   * Description: ���涩����Ϣ�Լ�������Ŀ
   * </p>
   * 
   * @param orderInfo ������Ϣ
   * @param orderItems ������Ŀ�б�
   * @param orderStatusEnum ����״̬
   */
  public OrderExecution(OrderInfo orderInfo, List<OrderItem> orderItems,
      OrderStatusEnum orderStatusEnum) {
    setOrderInfo(orderInfo);
    setOrderItemList(orderItems);
    setOrderNum(orderInfo.getOrderNum());
    setUserName(orderInfo.getUserName());
    setState(orderStatusEnum.getState());
    setStateInfo(orderStatusEnum.getStateInfo());
  }

  /**
   * 
   * <p>
   * Title:
   * </p>
   * <p>
   * Description: ������Ŀ�Ĺ�����
   * </p>
   * 
   * @param userName �û���
   * @param orderNum �������
   * @param orderItems ������Ŀ�б�
   */
  public OrderExecution(String userName, String orderNum, List<OrderItem> orderItems) {
    setUserName(userName);
    setOrderNum(orderNum);
    setOrderItemList(orderItems);
  }

  /**
   * 
   * <p>
   * Title: Ĭ�Ϲ�����
   * </p>
   * <p>
   * Description: Ĭ�Ϲ�����
   * </p>
   */
  public OrderExecution() {}

  /**
   * @return the orderNum
   */
  public String getOrderNum() {
    return orderNum;
  }

  /**
   * @param orderNum the orderNum to set
   */
  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the stateInfo
   */
  public String getStateInfo() {
    return stateInfo;
  }

  /**
   * @param stateInfo the stateInfo to set
   */
  public void setStateInfo(String stateInfo) {
    this.stateInfo = stateInfo;
  }

  /**
   * @return the state
   */
  public int getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(int state) {
    this.state = state;
  }

  /**
   * @return the orderItemList
   */
  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  /**
   * @param orderItemList the orderItemList to set
   */
  public void setOrderItemList(List<OrderItem> orderItemList) {
    this.orderItemList = orderItemList;
  }

  /**
   * @return the orderInfo
   */
  public OrderInfo getOrderInfo() {
    return orderInfo;
  }

  /**
   * @param orderInfo the orderInfo to set
   */
  public void setOrderInfo(OrderInfo orderInfo) {
    this.orderInfo = orderInfo;
  }

  /**
   * @return the productList
   */
  public List<Product> getProductList() {
    return productList;
  }

  /**
   * @param productList the productList to set
   */
  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }


  /**
   * @return the orderInfos
   */
  public List<OrderInfo> getOrderInfos() {
    return orderInfos;
  }

  /**
   * @param orderInfos the orderInfos to set
   */
  public void setOrderInfos(List<OrderInfo> orderInfos) {
    this.orderInfos = orderInfos;
  }

  @Override
  public String toString() {
    return "OrderExecution [orderNum=" + orderNum + ", userName=" + userName + ", stateInfo="
        + stateInfo + ", state=" + state + ", orderItemList=" + orderItemList + ", productList="
        + productList + ", orderInfo=" + orderInfo + "]";
  }



}
