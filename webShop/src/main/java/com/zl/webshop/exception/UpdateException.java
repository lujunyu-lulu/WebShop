/**
 * <p>
 * Title: UpdateException.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��18��
 * </p>
 * @version 1.0
 */
package com.zl.webshop.exception;

/**
 * <p>
 * Title: UpdateException
 * </p>
 * <p>
 * Description: ������Ϣ�쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��18��
 * </p>
 */
public class UpdateException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public UpdateException(String message) {
    super(message);
  }

  public UpdateException(String message, Throwable cause) {
    super(message, cause);
  }
}
