/** 
�� * <p>Title: NotEnoughQuantityException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��22�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: NotEnoughQuantityException</p> 
�� * <p>Description: ��������������Ʒ����쳣</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��22�� </p>
*/
public class NotEnoughQuantityException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public NotEnoughQuantityException(String message) {
    super(message);
  }

  public NotEnoughQuantityException(String message, Throwable cause) {
    super(message, cause);
  }
}
