/** 
�� * <p>Title: NoProductException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: NoProductException</p> 
�� * <p>Description: û����ز�Ʒ�쳣</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
*/
public class NoProductException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public NoProductException(String message) {
    super(message);
  }

  public NoProductException(String message, Throwable cause) {
    super(message, cause);
  }
}
