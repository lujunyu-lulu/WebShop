/**
 * <p>
 * Title: UserRolesEnum.java
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
 * Title: UserRolesEnum
 * </p>
 * <p>
 * Description: �û�Ȩ��ö��
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public enum UserRolesEnum {
  /**
   * ����Ա
   */
  ADMIN(0, "ADMIN"),
  /**
   * ע���û�
   */
  CUSTOM(1, "CUSTOM");

  /**
   * ����
   */
  private int state;
  /**
   * ö����Ϣ
   */
  private String stateInfo;

  private UserRolesEnum(int state, String stateInfo) {
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
  public static UserRolesEnum stateOf(int index) {
    for (UserRolesEnum state : values()) {
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
