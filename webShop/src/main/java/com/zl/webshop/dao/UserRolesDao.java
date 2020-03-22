/**
 * <p>
 * Title: UserRolesDao.java
 * </p>
 * <p>
 * Description: �û�Ȩ�ޱ�Dao
 * </p>
 * 
 * @author zyd @date 2020��3��12�� @version 1.0
 */
package com.zl.webshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.UserRoles;

/**
 * <p>
 * Title: UserRolesDao
 * </p>
 * <p>
 * Description: �û�Ȩ�ޱ�Dao�ӿ�
 * </p>
 * 
 * @author zyd 
 * <p>�������ڣ�2020��3��12��</p>
 */
public interface UserRolesDao {
  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description: ��ȡ�û�Ȩ�ޱ�����
   * </p>
   * @return �û�Ȩ������
   */
  int count();
  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ�����û�Ȩ����Ϣ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ��Ŀ��
   * @return �û�Ȩ���嵥
   */
  List<UserRoles> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryAllByRole
   * </p>
   * <p>
   * Description: �����û�Ȩ�޲�ѯ�û�Ȩ����Ϣ
   * </p>
   * 
   * @param role Ȩ��ֵ
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ��Ŀ��
   * @return �û�Ȩ���嵥
   */
  List<UserRoles> queryAllByRole(@Param("role") String role, @Param("offset") int offset,
      @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByUserName
   * </p>
   * <p>
   * Description: �����û�����ѯ�û�Ȩ����Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return �û�Ȩ����Ϣ
   */
  UserRoles queryByUserName(@Param("userName") String userName);

  /**
   * 
   * <p>
   * Title: addRole
   * </p>
   * <p>
   * Description: ����û�Ȩ����Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param role Ȩ��ֵ
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addRole(@Param("userName") String userName, @Param("role") String role);

  /**
   * 
   * <p>
   * Title: updateRole
   * </p>
   * <p>
   * Description: �����û�Ȩ����Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param role Ȩ��ֵ
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateRole(@Param("userName") String userName, @Param("role") String role);

  /**
   * 
   * <p>
   * Title: deleteRole
   * </p>
   * <p>
   * Description: ɾ���û�Ȩ����Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteRole(@Param("userName") String userName);
}
