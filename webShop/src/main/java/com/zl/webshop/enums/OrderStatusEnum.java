/**
 * <p>
 * Title: OrderStatusEnum.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 * @version 1.0
 */
package com.zl.webshop.enums;

/**
 * <p>
 * Title: OrderStatusEnum
 * </p>
 * <p>
 * Description: ����״̬ö��
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public enum OrderStatusEnum {
  /**
   * �Ѹ���
   */
  ORDER_PAYED(0, "�Ѹ���"),
  /**
   * ���µ�
   */
  ORDER_PLACED(1, "���µ�"),
  /**
   * ������
   */
  ORDER_SHIPED(2, "������"),
  /**
   * �Ѽĵ�
   */
  ORDER_DONE(3, "�Ѽĵ�"),
  /**
   * ���ﳵ
   */
  SHOPPING_CART(4,"���ﳵ"),
  /**
   * �ղؼ�
   */
  STAR(5,"�ղؼ�");
  /**
   * ����
   */
  private int state;
  /**
   * ö����Ϣ
   */
  private String stateInfo;

  private OrderStatusEnum(int state, String stateInfo) {
    setState(state);
    setStateInfo(stateInfo);
  }

  /**
   * 
   * <p>
   * Title: stateOf
   * </p>
   * <p>
   * Description:����������ȡö��
   * </p>
   * @param index ����
   *  @return ����״̬ö��
   */
  public static OrderStatusEnum stateOf(int index) {
    for (OrderStatusEnum state : values()) {
      if (state.getState() == index) {
        return state;
      }
    }
    return null;
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

}
