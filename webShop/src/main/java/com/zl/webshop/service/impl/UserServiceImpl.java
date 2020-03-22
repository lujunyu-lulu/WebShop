/**
 * <p>
 * Title: UserServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��18��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zl.webshop.dao.ContactDao;
import com.zl.webshop.dao.OrderInfoDao;
import com.zl.webshop.dao.OrderItemDao;
import com.zl.webshop.dao.UserDao;
import com.zl.webshop.dao.UserRolesDao;
import com.zl.webshop.dto.UserExecution;
import com.zl.webshop.entity.User;
import com.zl.webshop.enums.UserRolesEnum;
import com.zl.webshop.exception.DeleteException;
import com.zl.webshop.exception.LoginException;
import com.zl.webshop.exception.NoUserException;
import com.zl.webshop.exception.RegisterException;
import com.zl.webshop.exception.RepeatRegisterException;
import com.zl.webshop.exception.UpdateException;
import com.zl.webshop.exception.WrongUserNamePwdException;
import com.zl.webshop.service.UserService;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * <p>
 * Title: UserServiceImpl
 * </p>
 * <p>
 * Description: UserService �ӿ�ʵ��
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��18��
 *         </p>
 */
@Service
public class UserServiceImpl implements UserService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private UserDao userdao;
  @Autowired
  private UserRolesDao userRolesDao;
  @Autowired
  private ContactDao contactDao;
  @Autowired
  private OrderItemDao orderItemDao;
  @Autowired
  private OrderInfoDao orderInfoDao;

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public UserExecution register(User applicant) throws RegisterException {
    UserExecution userExecution = null;
    try {
      User user = userdao.queryById(applicant.getUserName());
      if (null != user) {
        // �Ѵ��ڸ��û�
        throw new RepeatRegisterException("repeat register");
      } else {
        // ע��
        if (StrUtil.isNotEmpty(applicant.getPassword())
            && StrUtil.isNotEmpty(applicant.getUserName())) {
          // �û������붼����
          // �������
          String pwdMd5 = DigestUtil.md5Hex(applicant.getPassword());
          applicant.setPassword(pwdMd5);
          // ������ͨȨ��
          UserRolesEnum rolesEnum = UserRolesEnum.CUSTOM;
          int count = userdao.addUser(applicant);
          if (count > 0) {
            // ע��ɹ������Ȩ��
            // ���Ȩ��
            count = userRolesDao.addRole(applicant.getUserName(), rolesEnum.getStateInfo());
            if (count > 0) {
              // ���Ȩ�޳ɹ�
              userExecution = new UserExecution(applicant, rolesEnum);
            } else {
              // ���Ȩ��ʧ��
              throw new RegisterException("add role error");
            }
          } else {
            // ����û�ʧ��
            throw new RegisterException("add user error");
          }
        }
      }
    } catch (RepeatRegisterException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RegisterException("register inner error:" + e.getMessage());
    }
    return userExecution;
  }

  @Override
  public boolean login(User user) throws LoginException {
    boolean index = false;
    try {
      if (StrUtil.isEmpty(user.getUserName()) || StrUtil.isEmpty(user.getPassword())) {
        // ������û���Ϊ��
        index = false;
        throw new WrongUserNamePwdException("empty userName or password");
      }
      User checkUser = userdao.queryById(user.getUserName());
      if (null == checkUser) {
        // ���޴��û�
        index = false;
        throw new NoUserException("no user");
      } else {
        // ��֤
        if (DigestUtil.md5Hex(user.getPassword()).equals(checkUser.getPassword()) == true) {
          // ������ȷ����¼�ɹ�
          index = true;
        } else {
          // �������
          index = false;
          throw new WrongUserNamePwdException("wrong userName or password");
        }
      }
    } catch (NoUserException e) {
      throw e;
    } catch (WrongUserNamePwdException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new LoginException("login inner error:" + e.getMessage());
    }

    return index;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public int deleteAccount(User user) {
    // ����Ƿ�ɾ���ɹ�
    int index = 0;
    // ɾ���ۼ�����
    int flag = 0;
    try {
      User checkUser = userdao.queryById(user.getUserName());
      if (null == checkUser) {
        // ���޴���
        throw new NoUserException("no user");
      }
      if (StrUtil.equals(checkUser.getPassword(), DigestUtil.md5Hex(user.getPassword())) == false) {
        // �������
        throw new WrongUserNamePwdException("wrong userName or password");
      }
      // ��ɾ���ӱ����ݺ���ɾ���û���(����)���� ����������ӱ�ȫ��ɾ����Ϻ����ɾ��
      // ɾ��Ȩ��
      index = userRolesDao.deleteRole(user.getUserName());
      if (index < 1) {
        // ɾ��Ȩ��ʧ��
        throw new DeleteException("delete role failed");
      }
      flag += index;
      // ɾ����ϵ��Ϣ
      index = contactDao.deleteContactByUserName(user.getUserName());
      if (index < 1) {
        // ɾ��Ȩ��ʧ��
        throw new DeleteException("delete contact failed");
      }
      flag += index;
      // ɾ��������Ŀ
      index = orderItemDao.deleteOrderItemByUserName(user.getUserName());
      if (index < 1) {
        // ɾ��Ȩ��ʧ��
        throw new DeleteException("delete orderItem failed");
      }
      flag += index;
      // ɾ��������Ϣ
      index = orderInfoDao.deleteOrderInfoByUserName(user.getUserName());
      if (index < 1) {
        // ɾ��Ȩ��ʧ��
        throw new DeleteException("delete orderInfo failed");
      }
      flag += index;
      // ɾ���û�
      index = userdao.deleteUser(user);
      if (index < 1) {
        // ɾ���û�ʧ��ʧ��
        throw new DeleteException("delete user failed");
      }
      flag += index;
    } catch (NoUserException e) {
      throw e;
    } catch (WrongUserNamePwdException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new DeleteException("deleteAccount inner error:" + e.getMessage());
    }
    return flag;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public int updateUserInfo(User user) throws UpdateException {
    int index = 0;
    try {
      // �������
      user.setPassword(DigestUtil.md5Hex(user.getPassword()));
      index = userdao.updateUser(user);
      if (index < 1) {
        // ����ʧ��
        throw new UpdateException("update error");
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new UpdateException("update user info inner error:" + e.getMessage());
    }
    return index;
  }

}
