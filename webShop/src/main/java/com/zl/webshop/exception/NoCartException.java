package com.zl.webshop.exception;
/**
 * 
�� * <p>Title: NoCartException</p> 
�� * <p>Description: ��ȡ���ﳵ����ʧ��</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
 */
public class NoCartException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public NoCartException(String message) {
    super(message);
  }

  public NoCartException(String message, Throwable cause) {
    super(message, cause);
  }
}
