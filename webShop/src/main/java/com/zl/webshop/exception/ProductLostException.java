/** 
�� * <p>Title: ProductLostException.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.exception;

/** 
�� * <p>Title: ProductLostException</p> 
�� * <p>Description: ��ƷʧЧ�쳣</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��21�� </p>
*/
public class ProductLostException extends RuntimeException{
  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  public ProductLostException(String message) {
    super(message);
  }

  public ProductLostException(String message, Throwable cause) {
    super(message, cause);
  }
}
