/** 
�� * <p>Title: AdminUserServiceTest.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.zl.webshop.BaseTest;
import com.zl.webshop.entity.User;

/** 
�� * <p>Title: AdminUserServiceTest</p> 
�� * <p>Description: �����û�������</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
*/
public class AdminUserServiceTest extends BaseTest{

  @Autowired
  private AdminUserService userService;
  
  @Test@Ignore
  public void testGetUsers() {
   userService.getUsers(null, 0, 10).forEach(System.out::println);
  }
  @Test@Ignore
  public void testDeleteUser() {
    User user=new User();
    user.setUserName("servicetest");
    userService.deleteUser(user);
  }
  @Test@Ignore
  public void testUpdateUser() {
    User user=new User();
    user.setUserName("servicetest");
    user.setNickName("testnick");
    userService.updateUser(user);
  }
}
