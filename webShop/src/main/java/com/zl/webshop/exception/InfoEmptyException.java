/** 
�� * <p>Title: InfoEmptyException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: InfoEmptyException</p> 
�� * <p>Description: �ύ��ϢΪ��</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
*/
public class InfoEmptyException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public InfoEmptyException(String message) {
    super(message);
  }

  public InfoEmptyException(String message, Throwable cause) {
    super(message, cause);
  }
}
