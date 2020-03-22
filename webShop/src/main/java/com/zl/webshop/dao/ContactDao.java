/**
 * <p>
 * Title: ContactDao.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 * @date 2020��3��13��
 * @version 1.0
 */
package com.zl.webshop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.Contact;

/**
 * <p>
 * Title: ContactDao
 * </p>
 * <p>
 * Description: ��ϵ��Ϣ��Dao
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��13��
 *         </p>
 */
public interface ContactDao {
  /**
   * 
   * <p>
   * Title: queryByUserNameStatus
   * </p>
   * <p>
   * Description: �����û�������ϵ��Ϣ���״̬���Ի�ȡ��ϵ��Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param status ״̬����
   * @return ��ϵ�б�
   */
  List<Contact> queryByUserNameStatus(@Param("userName") String userName, @Param("status") int status);

  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ������ϵ��Ϣ
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ϵ�б�
   */
  List<Contact> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByUserName
   * </p>
   * <p>
   * Description: ͨ���û�����ѯ��ϵ��Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ϵ�б�
   */
  List<Contact> queryByUserName(@Param("userName") String userName, @Param("offset") int offset,
      @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryById
   * </p>
   * <p>
   * Description: ʹ��id��ѯ������ϵ��Ϣ
   * </p>
   * 
   * @param id ���
   * @return ��ϵ��Ϣ����
   */
  Contact queryById(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: addContact
   * </p>
   * <p>
   * Description: ���һ����ϵ��Ϣ
   * </p>
   * 
   * @param contact ��ϵ��Ϣ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int addContact(@Param("contact") Contact contact);

  /**
   * 
   * <p>
   * Title: updateContact
   * </p>
   * <p>
   * Description: ����һ����ϵ��Ϣ
   * </p>
   * 
   * @param contact ��ϵ��Ϣ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int updateContact(@Param("contact") Contact contact);

  /**
   * 
   * <p>
   * Title: deleteContact
   * </p>
   * <p>
   * Description: ɾ��һ����ϵ��Ϣ
   * </p>
   * 
   * @param contact ��ϵ��Ϣ����
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteContact(@Param("contact") Contact contact);

  /**
   * 
   * <p>
   * Title: deleteContactByUserName
   * </p>
   * <p>
   * Description: �����û���ɾ����ϵ��Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return ���Ӱ���������ڴ���1 ��ʾ���µļ�¼����
   */
  int deleteContactByUserName(@Param("userName") String userName);
}
