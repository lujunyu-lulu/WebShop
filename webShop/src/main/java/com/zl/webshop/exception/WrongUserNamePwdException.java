/**
 * <p>
 * Title: WrongUserNamePwdException.java
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
 * Title: WrongUserNamePwdException
 * </p>
 * <p>
 * Description: �û������������ �쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public class WrongUserNamePwdException extends RuntimeException {

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public WrongUserNamePwdException(String message) {
    super(message);
  }

  public WrongUserNamePwdException(String message, Throwable cause) {
    super(message, cause);
  }
}
