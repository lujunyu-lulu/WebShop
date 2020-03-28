/**
 * <p>
 * Title: UserService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��15��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service;

import com.zl.webshop.dto.UserExecution;
import com.zl.webshop.entity.User;

/**
 * <p>
 * Title: UserService
 * </p>
 * <p>
 * Description: �û�ҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��15��
 *         </p>
 */
public interface UserService {
  /**
   * 
   * <p>
   * Title: getBasicInfo
   * </p>
   * <p>
   * Description: ��ȡ���û��Ļ�����Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return UserExecution
   */
  UserExecution getBasicInfo(String userName);

  /**
   * 
   * <p>
   * Title: register
   * </p>
   * <p>
   * Description: ע��
   * </p>
   * 
   * @param applicant ע���û���Ϣ
   * @return �û���Ϣ�Լ��û�Ȩ��
   */
  UserExecution register(User applicant);

  /**
   * 
   * <p>
   * Title: login
   * </p>
   * <p>
   * Description: ��¼
   * </p>
   * 
   * @param user �û���Ϣ
   * @return ��¼�ɹ���ʧ��
   */
  boolean login(User user);

  /**
   * 
   * <p>
   * Title: deleteAccount
   * </p>
   * <p>
   * Description: ɾ���û�
   * </p>
   * 
   * @param user �û�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteAccount(User user);

  /**
   * 
   * <p>
   * Title: updateUserInfo
   * </p>
   * <p>
   * Description: ���¸��˻�����Ϣ ���� ����
   * </p>
   * 
   * @param user �û���Ϣ
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateUserInfo(User user);

  /**
   * 
   * <p>
   * Title: updatePassword
   * </p>
   * <p>
   * Description:�����û�����
   * </p>
   * 
   * @param user �û�
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updatePassword(User user);

  /**
   * 
   * <p>
   * Title: checkPassword
   * </p>
   * <p>
   * Description: ��֤�����Ƿ���ȷ
   * </p>
   * 
   * @param userName �û���
   * @param password ����
   * @return ��֤���
   */
  boolean checkPassword(String userName, String password);
}
