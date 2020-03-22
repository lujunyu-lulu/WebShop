package com.zl.webshop.exception;

/**
 * 
 * <p>
 * Title: AddToCartException
 * </p>
 * <p>
 * Description: ��ӹ��ﳵ �쳣
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��3��21��
 * </p>
 */
public class AddToCartException extends RuntimeException {
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public AddToCartException(String message) {
    super(message);
  }

  public AddToCartException(String message, Throwable cause) {
    super(message, cause);
  }
}
