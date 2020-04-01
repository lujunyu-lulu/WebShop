/** 
�� * <p>Title: CommentAuditEnum.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��31�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.enums;

/** 
�� * <p>Title: CommentAuditEnum</p> 
�� * <p>Description: ��������ö��</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��31�� </p>
*/
public enum CommentAuditEnum {
  /**
   * ������
   */
  AUDIT(1,"������"),
  /**
   * ��׼
   */
  RATIFY(2,"��׼");
  /**
   * ����
   */
  private int state;
  /**
   * ö����Ϣ
   */
  private String stateInfo;

  private CommentAuditEnum(int state, String stateInfo) {
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
  public static CommentAuditEnum stateOf(int index) {
    for (CommentAuditEnum state : values()) {
      if (state.getState() == index) {
        return state;
      }
    }
    return null;
  }

  public static CommentAuditEnum stateOf(String index) {
    for (CommentAuditEnum state : values()) {
      if (state.getStateInfo().equals(index)) {
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
