/**
 * <p>
 * Title: RegisterException.java
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
 * Title: RegisterException
 * </p>
 * <p>
 * Description: �û�ע���쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public class RegisterException extends RuntimeException {
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public RegisterException(String message) {
    super(message);
  }

  public RegisterException(String message, Throwable cause) {
    super(message, cause);
  }
}
