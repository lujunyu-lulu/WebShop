/** 
�� * <p>Title: NoStarException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��26�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: NoStarException</p> 
�� * <p>Description: �ղؼ�Ϊ���쳣</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��26�� </p>
*/
public class NoStarException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public NoStarException(String message) {
    super(message);
  }

  public NoStarException(String message, Throwable cause) {
    super(message, cause);
  }
}
