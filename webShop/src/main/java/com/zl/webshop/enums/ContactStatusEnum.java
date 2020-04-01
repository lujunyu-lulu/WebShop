/**
 * <p>
 * Title: ContactStatusEnum.java
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
 * Title: ContactStatusEnum
 * </p>
 * <p>
 * Description: ��ϵ��Ϣö��
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public enum ContactStatusEnum {
  /**
   * Ĭ�ϵ�ַ
   */
  DEFAULT(0, "Ĭ�ϵ�ַ"),
  /**
   * ������ַ
   */
  OTHER(1, "������ַ");

  /**
   * ����
   */
  private int state;
  /**
   * ö����Ϣ
   */
  private String stateInfo;

  private ContactStatusEnum(int state, String stateInfo) {
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
   * 
   * @param index ���� 
   * @return ����״̬ö��
   */
  public static ContactStatusEnum stateOf(int index) {
    for (ContactStatusEnum state : values()) {
      if (state.getState() == index) {
        return state;
      }
    }
    return null;
  }
  public static ContactStatusEnum stateOf(String index) {
    for (ContactStatusEnum state : values()) {
      if (state.getStateInfo().equals(index)) {
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
