/**
 * <p>
 * Title: DeleteException.java
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
 * Title: DeleteException
 * </p>
 * <p>
 * Description: ɾ����Ϣ�쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��18��
 * </p>
 */
public class DeleteException extends RuntimeException {
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public DeleteException(String message) {
    super(message);
  }

  public DeleteException(String message, Throwable cause) {
    super(message, cause);
  }
}
