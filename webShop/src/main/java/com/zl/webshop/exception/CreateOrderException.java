/** 
�� * <p>Title: CreateOrderException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: CreateOrderException</p> 
�� * <p>Description: ���������쳣</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
*/
public class CreateOrderException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public CreateOrderException(String message) {
    super(message);
  }

  public CreateOrderException(String message, Throwable cause) {
    super(message, cause);
  }

}
