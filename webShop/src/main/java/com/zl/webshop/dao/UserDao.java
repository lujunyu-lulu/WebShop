/**
 * <p>
 * Title: UserDao.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd @date 2020��3��12�� @version 1.0
 */
package com.zl.webshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.User;

/**
 * <p>
 * Title: UserDao
 * </p>
 * <p>
 * Description: �û���Dao�ӿ�
 * </p>
 * 
 * @author zyd 
 * <p>�������ڣ�2020��3��12��</p>
 */
public interface UserDao {
  /**
   * 
   * <p>
   * Title: count
   * </p>
   * <p>
   * Description: ��ȡ�û�����
   * </p>
   * @return �û�����
   */
  int count();
  /**
   * 
   * <p>
   * Title: queryById
   * </p>
   * <p>
   * Description: ͨ���û�����ѯ�����û���Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return �û���Ϣ
   */
  User queryById(@Param("userName") String userName);

  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ�����û�
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return �û��б�
   */
  List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);



  /**
   * 
   * <p>
   * Title: addUser
   * </p>
   * <p>
   * Description: �����û�
   * </p>
   * 
   * @param user �û�ʵ�����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addUser(@Param("user") User user);

  /**
   * 
   * <p>
   * Title: deleteUser
   * </p>
   * <p>
   * Description: ɾ�������û�
   * </p>
   * 
   * @param user �û�ʵ�����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteUser(@Param("user") User user);

  /**
   * 
   * <p>
   * Title: updateUser
   * </p>
   * <p>
   * Description: ���������û���Ϣ
   * </p>
   * 
   * @param user �û�ʵ�����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateUser(@Param("user") User user);
}