/**
 * <p>
 * Title: ContactExecution.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��20��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.dto;

import java.util.List;
import com.zl.webshop.entity.Contact;
import com.zl.webshop.enums.ContactStatusEnum;

/**
 * <p>
 * Title: ContactExecution
 * </p>
 * <p>
 * Description: ��ϵ��ϢDTO
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��20��
 *         </p>
 */
public class ContactExecution {
  /**
   * �û���
   */
  private String userName;
  /**
   * ��ϵ��Ϣ
   */
  private Contact contact;
  /**
   * ��ϵ��Ϣ�б�
   */
  private List<Contact> contacts;
  /**
   * ��ϵ��Ϣ״̬
   */
  private int state;
  /**
   * ��ϵ��Ϣ״̬����Ϣ
   */
  private String stateInfo;

  /**
   * 
   * <p>
   * Title:
   * </p>
   * <p>
   * Description: һ���û���������ϵ��Ϣ�Ĺ�����
   * </p>
   * 
   * @param userName �û���
   * @param contacts ��ϵ��Ϣ�б�
   */
  public ContactExecution(String userName, List<Contact> contacts) {
    setUserName(userName);
    setContacts(contacts);
  }

  /**
   * 
   * <p>
   * Title:
   * </p>
   * <p>
   * Description: ������ϵ��Ϣ�Ĺ�����
   * </p>
   * 
   * @param userName �û���
   * @param contact ��ϵ��Ϣ
   * @param status ��ϵ��Ϣ��״̬
   */
  public ContactExecution(String userName, Contact contact, ContactStatusEnum status) {
    setUserName(userName);
    setContact(contact);
    setState(status.getState());
    setStateInfo(status.getStateInfo());
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the contact
   */
  public Contact getContact() {
    return contact;
  }

  /**
   * @param contact the contact to set
   */
  public void setContact(Contact contact) {
    this.contact = contact;
  }

  /**
   * @return the contacts
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * @param contacts the contacts to set
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * @return the state
   */
  public int getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(int state) {
    this.state = state;
  }

  /**
   * @return the stateInfo
   */
  public String getStateInfo() {
    return stateInfo;
  }

  /**
   * @param stateInfo the stateInfo to set
   */
  public void setStateInfo(String stateInfo) {
    this.stateInfo = stateInfo;
  }

}
