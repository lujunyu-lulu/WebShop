package com.zl.webshop.exception;

/**
 * 
 * <p>
 * Title: InvalidRoleException
 * </p>
 * <p>
 * Description: �Ƿ�Ȩ���쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��30��
 * </p>
 */
public class InvalidRoleException extends RuntimeException {
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public InvalidRoleException(String message) {
    super(message);
  }

  public InvalidRoleException(String message, Throwable cause) {
    super(message, cause);
  }
}
