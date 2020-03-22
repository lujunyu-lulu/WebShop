package com.zl.webshop.dto;



/**
 * 
 * <p>
 * Title: Result
 * </p>
 * <p>
 * Description:��װjson�������ڷ��ؽ��
 * </p>
 * 
 * @author ���ȷ�
 */
public class Result<T> {

  /**
   * �Ƿ�ɹ���־
   */
  private boolean success;

  /**
   * �ɹ�ʱ���ص�����
   */
  private T data;

  /**
   * ������Ϣ
   */
  private String error;

  public Result() {}

  /**
   * 
   * <p>
   * Title:Result
   * </p>
   * <p>
   * Description:�ɹ�ʱ�Ĺ�����
   * </p>
   * 
   * @param success �Ƿ�ɹ���־
   * @param data �ɹ�ʱ���ص�����
   */
  public Result(boolean success, T data) {
    this.success = success;
    this.data = data;
  }

  /**
   * 
   * <p>
   * Title: Result
   * </p>
   * <p>
   * Description: ����ʱ�Ĺ�����
   * </p>
   * 
   * @param success �Ƿ�ɹ���־
   * @param error ������Ϣ
   */
  public Result(boolean success, String error) {
    this.success = success;
    this.error = error;
  }

  /**
   * @return the success
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * @param success the success to set
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * @return the data
   */
  public T getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * @param error the error to set
   */
  public void setError(String error) {
    this.error = error;
  }


}
