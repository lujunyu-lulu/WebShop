/**
 * <p>
 * Title: RepeatRegisterException.java
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
 * Title: RepeatRegisterException
 * </p>
 * <p>
 * Description: �ظ�ע���쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��15��
 * </p>
 */
public class RepeatRegisterException extends RuntimeException {
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public RepeatRegisterException(String message) {
    super(message);
  }

  public RepeatRegisterException(String message, Throwable cause) {
    super(message, cause);
  }
}