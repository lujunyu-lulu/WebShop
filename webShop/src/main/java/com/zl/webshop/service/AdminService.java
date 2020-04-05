/**
 * <p>
 * Title: AdminService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��19��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service;


import com.zl.webshop.entity.User;


/**
 * <p>
 * Title: AdminService
 * </p>
 * <p>
 * Description: ����Աҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��19��
 *         </p>
 */
public interface AdminService {
  /**
   * 
   * <p>
   * Title: login
   * </p>
   * <p>
   * Description: ����Ա��¼
   * </p>
   * 
   * @param admin ����Ա
   * @return ��¼�ɹ�����true
   */
  boolean login(User admin);

  /**
   * 
   * <p>
   * Title: register
   * </p>
   * <p>
   * Description: ����Աע��
   * </p>
   * 
   * @param register ע�����
   * @return ע����
   */
  boolean register(User register);
}
