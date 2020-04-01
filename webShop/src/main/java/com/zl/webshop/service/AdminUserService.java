/**
 * <p>
 * Title: AdminUserService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service;

import java.util.List;
import com.zl.webshop.dto.UserExecution;
import com.zl.webshop.entity.User;

/**
 * <p>
 * Title: AdminUserService
 * </p>
 * <p>
 * Description: �����û�ҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 */
public interface AdminUserService {

  /**
   * 
   * <p>
   * Title: getUsers
   * </p>
   * <p>
   * Description: ��ȡ�û��б�
   * </p>
   * 
   * @param searchText �����ؼ��� ѡ�� @param offset ��ѯ��ʼλ�� @param limit ��ѯ���� @return �û��б�
   */
  List<UserExecution> getUsers(String searchText, int offset, int limit);

  /**
   * 
   * <p>
   * Title: deleteUser
   * </p>
   * <p>
   * Description: ɾ���û�
   * </p>
   * 
   * @param user �û� @return �����û�������
   */
  int deleteUser(User user);

  /**
   * 
   * <p>
   * Title: updateUser
   * </p>
   * <p>
   * Description: ����һ���û�
   * </p>
   * 
   * @param user �û�����
   * @return ���º���û���Ϣ
   */
  UserExecution updateUser(User user);
}
