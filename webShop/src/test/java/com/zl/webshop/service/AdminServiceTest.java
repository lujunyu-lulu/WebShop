/** 
�� * <p>Title: AdminServiceTest.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.zl.webshop.BaseTest;
import com.zl.webshop.entity.User;

/** 
�� * <p>Title: AdminServiceTest</p> 
�� * <p>Description: ����ҵ�����</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
*/
public class AdminServiceTest extends BaseTest{

  @Autowired
  private AdminService adminService;
  @Test
  public void testRegisterLogin() {
    User user=new User();
    user.setPassword("123456");
    user.setUserName("servicetest");
    //System.out.println(adminService.register(user));
    System.out.println(adminService.login(user));
    
  }
}
