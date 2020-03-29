/**
 * <p>
 * Title: CommentStarEnum.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��29��
 * </p>
 * @version 1.0
 */
package com.zl.webshop.enums;

/**
 * <p>
 * Title: CommentStarEnum
 * </p>
 * <p>
 * Description: �����Ƽ��Ǽ�ö����
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��29��
 * </p>
 */
public enum CommentStarEnum {
  /**
   * һ��
   */
  ONE(1, "һ��"),
  /**
   * ����
   */
  TWO(2, "����"),
  /**
   * ����
   */
  THREE(3, "����"),
  /**
   * ����
   */
  FOUR(4, "����"),
  /**
   * ����
   */
  FIVE(5, "����");

  /**
   * ����
   */
  private int state;
  /**
   * ö����Ϣ
   */
  private String stateInfo;

  private CommentStarEnum(int state, String stateInfo) {
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
  public static CommentStarEnum stateOf(int index) {
    for (CommentStarEnum state : values()) {
      if (state.getState() == index) {
        return state;
      }
    }
    return null;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getStateInfo() {
    return stateInfo;
  }

  public void setStateInfo(String stateInfo) {
    this.stateInfo = stateInfo;
  }

}
