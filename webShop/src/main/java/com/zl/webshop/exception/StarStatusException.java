/** 
�� * <p>Title: StarStatusException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��26�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: StarStatusException</p> 
�� * <p>Description: �ղؼ�״̬�쳣</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��26�� </p>
*/
public class StarStatusException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public StarStatusException(String message) {
    super(message);
  }

  public StarStatusException(String message, Throwable cause) {
    super(message, cause);
  }
}
