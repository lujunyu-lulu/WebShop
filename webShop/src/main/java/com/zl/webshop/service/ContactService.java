/**
 * <p>
 * Title: ContactService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��16��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service;

import java.util.List;
import com.zl.webshop.entity.Contact;

/**
 * <p>
 * Title: ContactService
 * </p>
 * <p>
 * Description: ��ϵ��Ϣҵ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��16��
 *         </p>
 */
public interface ContactService {
  /**
   * 
   * <p>
   * Title: getDefaultContact
   * </p>
   * <p>
   * Description: ��ȡ�û�Ĭ�ϵ�ַ
   * </p>
   * 
   * @param userName �û���
   * @return Contact
   */
  Contact getDefaultContact(String userName);

  /**
   * 
   * <p>
   * Title: getContacts
   * </p>
   * <p>
   * Description: ͨ���û�����ȡ��ϵ��Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return ���û���������ϵ��Ϣ
   */
  List<Contact> getContacts(String userName);

  /**
   * 
   * <p>
   * Title: setDefaultContact
   * </p>
   * <p>
   * Description: ����Ĭ�ϵ�ַ
   * </p>
   * 
   * @param contactId ��ַ���
   * @param userName �û���
   * @return ���ؽ�����ڵ���0��ʾ���óɹ�
   */
  int setDefaultContact(long contactId, String userName);

  /**
   * 
   * <p>
   * Title: addContact
   * </p>
   * <p>
   * Description: ����һ����ַ(״̬Ĭ������Ϊ��������ֹ��ͻ)
   * </p>
   * 
   * @param contact ��ϵ��Ϣ
   * @return ���ڵ���0��ʾ��ӳɹ�
   */
  int addContact(Contact contact);

  /**
   * 
   * <p>
   * Title: removeContact
   * </p>
   * <p>
   * Description: ɾ��һ����ϵ��ַ
   * </p>
   * 
   * @param contact ��ϵ��Ϣ
   * @return ���ڵ���0��ʾɾ���ɹ�
   */
  int removeContact(Contact contact);

}
