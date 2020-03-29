/**
 * <p>
 * Title: Comment.java
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
package com.zl.webshop.entity;


import java.time.LocalDateTime;


/**
 * <p>
 * Title: Comment
 * </p>
 * <p>
 * Description: ���۱�ʵ��
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��29��
 * </p>
 */
public class Comment {
  /**
   * ���
   */
  private long id;
  /**
   * �û���
   */
  private String userName;
  /**
   * ��Ʒ���
   */
  private long productId;
  /**
   * ��������
   */
  private String content;
  /**
   * ������
   */
  private int star;
  /**
   * ����ʱ��
   */
  private LocalDateTime createTime;

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
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
   * @return the productId
   */
  public long getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(long productId) {
    this.productId = productId;
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return the star
   */
  public int getStar() {
    return star;
  }

  /**
   * @param star the star to set
   */
  public void setStar(int star) {
    this.star = star;
  }

  /**
   * @return the createTime
   */
  public LocalDateTime getCreateTime() {
    return createTime;
  }

  /**
   * @param createTime the createTime to set
   */
  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Comment [id=" + id + ", userName=" + userName + ", productId=" + productId
        + ", content=" + content + ", star=" + star + ", createTime=" + createTime + "]";
  }

}
