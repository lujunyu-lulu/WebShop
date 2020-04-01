/**
 * <p>
 * Title: CommentExecution.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��31��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.dto;

import com.zl.webshop.entity.Comment;
import com.zl.webshop.enums.CommentAuditEnum;
import com.zl.webshop.enums.CommentStarEnum;

/**
 * <p>
 * Title: CommentExecution
 * </p>
 * <p>
 * Description: ���۱�dto
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��31��
 *         </p>
 */
public class CommentExecution {

  /**
   * ���۱�
   */
  private Comment comment;
  /**
   * �������״̬
   */
  private int state;
  /**
   * �������״̬����Ϣ
   */
  private String stateInfo;
  /**
   * ������
   */
  private int starState;
  /**
   * ��������Ϣ
   */
  private String starStateInfo;

  public CommentExecution() {}

  /**
   * 
   * <p>
   * Title: ������
   * </p>
   * <p>
   * Description: ������
   * </p>
   * @param comment ���۱���� 
   * @param auditEnum ����״̬ö��
   * @param starEnum ���ۺ�����ö��
   */
  public CommentExecution(Comment comment, CommentAuditEnum auditEnum, CommentStarEnum starEnum) {
    setComment(comment);
    setState(auditEnum.getState());
    setStateInfo(auditEnum.getStateInfo());
    setStarState(starEnum.getState());
    setStarStateInfo(starEnum.getStateInfo());
  }

  public int getStarState() {
    return starState;
  }

  public void setStarState(int starState) {
    this.starState = starState;
  }

  public String getStarStateInfo() {
    return starStateInfo;
  }

  public void setStarStateInfo(String starStateInfo) {
    this.starStateInfo = starStateInfo;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
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

  @Override
  public String toString() {
    return "CommentExecution [comment=" + comment + ", state=" + state + ", stateInfo=" + stateInfo
        + ", starState=" + starState + ", starStateInfo=" + starStateInfo + "]";
  }

}
