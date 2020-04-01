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
 *         �������ڣ�2020��3��30��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zl.webshop.dao.UserDao;
import com.zl.webshop.dao.UserRolesDao;
import com.zl.webshop.entity.User;
import com.zl.webshop.entity.UserRoles;
import com.zl.webshop.enums.UserRolesEnum;
import com.zl.webshop.exception.InfoEmptyException;
import com.zl.webshop.exception.InvalidRoleException;
import com.zl.webshop.exception.NoUserException;
import com.zl.webshop.exception.RepeatRegisterException;
import com.zl.webshop.exception.WrongUserNamePwdException;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * <p>
 * Title: AdminServiceImpl
 * </p>
 * <p>
 * Description: ����Աҵ��ӿ�ʵ��
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��30��
 *         </p>
 */
@Service
public class AdminServiceImpl implements com.zl.webshop.service.AdminService {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserDao userDao;
  @Autowired
  private UserRolesDao userRolesDao;

  @Override
  public boolean login(User admin) {
    boolean result = false;
    try {
      User user = userDao.queryByUserName(admin.getUserName());
      UserRoles role = userRolesDao.queryByUserName(admin.getUserName());
      if (ObjectUtil.isNull(user)) {
        // ���޴��û�
        throw new NoUserException("no user");
      }
      String password = DigestUtil.md5Hex(admin.getPassword());
      if (ObjectUtil.notEqual(user.getPassword(), password)) {
        // ���벻һ��
        throw new WrongUserNamePwdException("wrong userName or password");
      }
      if (ObjectUtil.notEqual(UserRolesEnum.ADMIN.getStateInfo(), role.getRole())) {
        // �޹���ԱȨ��
        throw new InvalidRoleException("invalid role");
      }
      result = true;
    } catch (NoUserException e) {
      throw e;
    } catch (WrongUserNamePwdException e) {
      throw e;
    } catch (InvalidRoleException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }

    return result;
  }


  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public boolean register(User register) {
    boolean result = false;
    try {
      if (StrUtil.hasEmpty(register.getPassword(), register.getUserName())) {
        // ����ֵ
        throw new InfoEmptyException("empty userName or password");
      }
      User user = userDao.queryByUserName(register.getUserName());
      if (ObjectUtil.isNotNull(user)) {
        // �ظ�ע��
        throw new RepeatRegisterException("repeat register");
      }

      // ע���û�
      String password = DigestUtil.md5Hex(register.getPassword());
      register.setPassword(password);
      userDao.addUser(register);
      // ע��Ȩ��
      UserRoles userRoles = new UserRoles();
      userRoles.setUserName(register.getUserName());
      userRoles.setRole(UserRolesEnum.ADMIN.getStateInfo());
      userRolesDao.addRole(userRoles.getUserName(), userRoles.getRole());
      result = true;
    } catch (InfoEmptyException e) {
      throw e;
    } catch (RepeatRegisterException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return result;
  }

}
