/** 
�� * <p>Title: CartStatusException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: CartStatusException</p> 
�� * <p>Description: ���ﳵ����״̬�쳣</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
*/
public class CartStatusException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public CartStatusException(String message) {
    super(message);
  }

  public CartStatusException(String message, Throwable cause) {
    super(message, cause);
  }
}
