/**
 * <p>
 * Title: NoUserException.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 * @version 1.0
 */
package com.zl.webshop.exception;

/**
 * <p>
 * Title: NoUserException
 * </p>
 * <p>
 * Description: û�д��û���Ϣ �쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public class NoUserException extends RuntimeException {
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public NoUserException(String message) {
    super(message);
  }

  public NoUserException(String message, Throwable cause) {
    super(message, cause);
  }
}
