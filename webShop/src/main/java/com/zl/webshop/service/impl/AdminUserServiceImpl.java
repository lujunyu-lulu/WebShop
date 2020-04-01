package com.zl.webshop.service.impl;

import java.util.ArrayList;
import java.util.List;
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
import com.zl.webshop.entity.UserRoles;
import com.zl.webshop.enums.UserRolesEnum;
import com.zl.webshop.service.AdminUserService;

/**
 * 
 * <p>
 * Title: AdminUserServiceImpl
 * </p>
 * <p>
 * Description: ����Ա �û�ҵ��ӿ�ʵ��
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��31��
 *         </p>
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
  
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private UserDao userDao;
  @Autowired
  private UserRolesDao userRolesDao;
  @Autowired
  private ContactDao contactDao;
  @Autowired
  private OrderItemDao orderItemDao;
  @Autowired
  private OrderInfoDao orderInfoDao;

  @Override
  public List<UserExecution> getUsers(String searchText, int offset, int limit) {
    // ��ȡ�û�
    List<User> users = userDao.fuzzyQueryAllByText(searchText, offset, limit);
    List<UserExecution> resultList = new ArrayList<UserExecution>();
    UserExecution userExecution = null;
    UserRoles role = null;
    // װ��ؽ��
    int count = userDao.fuzzyCount(searchText);
    for (User user : users) {
      role = userRolesDao.queryByUserName(user.getUserName());
      // ��������
      user.setPassword(null);
      userExecution = new UserExecution(user, UserRolesEnum.stateOf(role.getRole()));
      userExecution.setUserMaxCount(count);
      resultList.add(userExecution);

    }

    return resultList;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public int deleteUser(User user) {
    int count = 0;
    try {
      // ɾ��Ȩ��
      userRolesDao.deleteRole(user.getUserName());
      // ɾ����ϵ��ַ
      contactDao.deleteContactByUserName(user.getUserName());
      // ɾ������
      orderItemDao.deleteOrderItemByUserName(user.getUserName());
      orderInfoDao.deleteOrderInfoByUserName(user.getUserName());
      // ɾ���û�
      userDao.deleteUser(user);
      // ���������û�����
      count = userDao.count();
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return count;
  }

  @Override
  public UserExecution updateUser(User user) {
    UserExecution userExecution = null;
    try {
      userDao.updateUser(user);
      User newUser = userDao.queryByUserName(user.getUserName());
      UserRoles role = userRolesDao.queryByUserName(user.getUserName());
      userExecution = new UserExecution(newUser, UserRolesEnum.stateOf(role.getRole()));
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return userExecution;
  }

}
