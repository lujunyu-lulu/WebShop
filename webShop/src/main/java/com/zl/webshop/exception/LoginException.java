/**
 * <p>
 * Title: LoginException.java
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
 * Title: LoginException
 * </p>
 * <p>
 * Description: �û���¼�쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public class LoginException extends RuntimeException {

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public LoginException(String message) {
    super(message);
  }

  public LoginException(String message, Throwable cause) {
    super(message, cause);
  }
}
