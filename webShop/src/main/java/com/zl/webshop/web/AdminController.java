/**
 * <p>
 * Title: AdminController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��2��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.zl.webshop.dto.Result;
import com.zl.webshop.entity.User;
import com.zl.webshop.enums.CommentAuditEnum;
import com.zl.webshop.enums.OrderStatusEnum;
import com.zl.webshop.service.AdminService;
import cn.hutool.core.util.ObjectUtil;

/**
 * <p>
 * Title: AdminController
 * </p>
 * <p>
 * Description: ��̨���������� �����¼���ǳ�����ת��ҳ�¼�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��2��
 *         </p>
 */
@Controller
public class AdminController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private AdminService adminService;
  private static final String ADMINUSERNAME = "adminUserName";

  /**
   * 
   * <p>
   * Title: getAdminPage
   * </p>
   * <p>
   * Description: ǰ����¼ҳ����ҳ
   * </p>
   * 
   * @param request ��ȡ��¼��Ϣ
   * @return ��¼ҳ����ҳ
   */
  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  private String getAdminPage(HttpServletRequest request) {
    if (ObjectUtil.isNull(request.getSession().getAttribute(ADMINUSERNAME))) {
      // û��¼����ת����¼ҳ
      logger.debug("loginpage");
      return "";
    }
    // ǰ����̨��ҳ
    logger.debug("adminPage");
    return "";
  }

  /**
   * 
   * <p>
   * Title: login
   * </p>
   * <p>
   * Description: ����¼�¼�
   * </p>
   * 
   * @param userName �û���
   * @param password ����
   * @param request ������
   * @return ��ҳ���¼ҳ
   */
  @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
  private String login(@RequestParam("userName") String userName,
      @RequestParam("password") String password, HttpServletRequest request) {
    User admin = new User();
    admin.setPassword(password);
    admin.setUserName(userName);
    try {
      boolean flag = adminService.login(admin);
      if (flag == true) {
        // ��¼�ɹ�
        request.getSession().setAttribute(ADMINUSERNAME, userName);

      }
    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    // �ض�������ҳ���¼ҳ
    return "redirect: /webShop/admin";
  }

  /**
   * 
   * <p>
   * Title: loginoff
   * </p>
   * <p>
   * Description: �˳���¼�¼�
   * </p>
   * 
   * @param request �����¼��Ϣ
   * @return ��¼ҳ
   */
  @RequestMapping(value = "/admin/logoff", method = RequestMethod.GET)
  private String loginoff(HttpServletRequest request) {
    request.getSession().invalidate();
    // �ض�������¼ҳ
    return "redirect: /webShop/admin";
  }

  /**
   * 
   * <p>
   * Title: getAuditEnum
   * </p>
   * <p>
   * Description: ��ȡ�������״̬ö��
   * </p>
   * @return ö��
   */
  @RequestMapping(value = "/admin/enums/commentaudit", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String getAuditEnum() {
    Result<Map<Integer, String>> result = null;
    Map<Integer, String>enumMap=new HashMap<Integer, String>();
    try {
      for (CommentAuditEnum auditEnum : CommentAuditEnum.values()) {
        enumMap.put(auditEnum.getState(), auditEnum.getStateInfo());
      }
      result = new Result<Map<Integer, String>>(true, enumMap);
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getOrderStatusEnum
   * </p>
   * <p>
   * Description: ��ȡ����״̬ö��
   * </p>
   * @return ö��
   */
  @RequestMapping(value = "/admin/enums/orderstatus", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String getOrderStatusEnum() {
    Result<Map<Integer, String>> result = null;
    Map<Integer, String>enumMap=new HashMap<Integer, String>();
    try {
      for (OrderStatusEnum statusEnum : OrderStatusEnum.values()) {
        enumMap.put(statusEnum.getState(), statusEnum.getStateInfo());
      }
      result = new Result<Map<Integer, String>>(true, enumMap);
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }
}
