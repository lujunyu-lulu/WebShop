/**
 * <p>
 * Title: UserController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��25��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.zl.webshop.dto.OrderExecution;
import com.zl.webshop.dto.Result;
import com.zl.webshop.dto.UserExecution;
import com.zl.webshop.entity.Contact;
import com.zl.webshop.entity.OrderInfo;
import com.zl.webshop.entity.OrderItem;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.User;
import com.zl.webshop.enums.ContactStatusEnum;
import com.zl.webshop.enums.OrderStatusEnum;
import com.zl.webshop.exception.AddToCartException;
import com.zl.webshop.exception.CreateOrderException;
import com.zl.webshop.exception.InfoEmptyException;
import com.zl.webshop.exception.NoCartException;
import com.zl.webshop.exception.NoProductException;
import com.zl.webshop.exception.NoStarException;
import com.zl.webshop.exception.NoUserException;
import com.zl.webshop.exception.NotEnoughQuantityException;
import com.zl.webshop.exception.RegisterException;
import com.zl.webshop.exception.RepeatRegisterException;
import com.zl.webshop.exception.UpdateException;
import com.zl.webshop.exception.WrongUserNamePwdException;
import com.zl.webshop.service.ContactService;
import com.zl.webshop.service.OrderService;
import com.zl.webshop.service.UserService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * Title: UserController
 * </p>
 * <p>
 * Description: �û�������
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��25��
 *         </p>
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  /**
   * ������ӻ��ѯsession���ѵ�¼���û���
   */
  public static final String LOGINUSERNAME = "loginUserName";
  @Autowired
  private UserService userService;
  @Autowired
  private OrderService orderService;
  @Autowired
  private ContactService contactService;

  /**
   * 
   * <p>
   * Title: getLoginPage
   * </p>
   * <p>
   * Description: url: /user ��ȡ��ʽ��get ���ã���û��¼����ת����¼/ע��ҳ�� ��¼����ת����ҳ
   * </p>
   * 
   * @param request ��ȡ����
   * @return �ض�������ҳ����ǰ������¼ע��ҳ
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  private String getLoginPage(HttpServletRequest request) {
    if (request.getSession().getAttribute(LOGINUSERNAME) != null) {
      String loginUserName = StrUtil.toString(request.getSession().getAttribute(LOGINUSERNAME));
      if (StrUtil.isNotBlank(loginUserName)) {
        // ����������жϣ������¼�˻Ὣ��¼���û�������session
        // �ѵ�¼��ת��������ҳ
        System.out.println("login");
        return "redirect: /webShop/users/" + loginUserName;
      }
      // �û���Ϊ���򷵻ص�¼ע��ҳ
      return " ";
    } else {
      // δ��¼ת����¼ע��ҳ
      return " ";
    }

  }

  /**
   * 
   * <p>
   * Title: tryRegister
   * </p>
   * <p>
   * Description: ajax json ����ע�ᡣajax��contentype������"application/json; charset=utf-8"
   * ����ʱ����ʹ��JSON.stringify()��װjson����
   * </p>
   * 
   * @param register User ���������ΪuserName��password��������Ϊid ѡ����ΪnickName,email
   * @return Result ������Result��װ�õ�json�ַ��������ע��ʧ�ܻᱣ��ʧ����Ϣerror
   */
  @RequestMapping(value = "", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String tryRegister(@RequestBody User register) {
    UserExecution userExecution = null;
    Result<UserExecution> result = null;
    try {
      userExecution = userService.register(register);
      result = new Result<UserExecution>(true, userExecution);
    } catch (RepeatRegisterException e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    } catch (RegisterException e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getPersonalCenterPage
   * </p>
   * <p>
   * Description: ���ѵ�¼����ת���������� ������ת��¼ҳ��,ǰ���userName���ѵ�¼��һ��
   * </p>
   * 
   * @param userName �û���
   * @param model �������
   * @param request ������ȡ�ѵ�¼���û���
   * @return �ɹ�ת���������� û�е�¼����ת����¼ҳ�� �û������ѵ�¼���û�����һ������ת����ҳ
   */
  @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
  private String getPersonalCenterPage(@PathVariable String userName, HttpServletRequest request,
      Model model) {
    if (request.getSession().getAttribute(LOGINUSERNAME) == null) {
      // δ��¼
      logger.error("no user");
      return "redirect: /webShop/users";
    }
    String loginUserName = StrUtil.toString(request.getSession().getAttribute(LOGINUSERNAME));
    if (ObjectUtil.notEqual(userName, loginUserName)) {
      // ���ݵ��û������ѵ�¼���û�����һ��
      // ��ת����ҳ
      logger.error("invalid user");
      return "redirect: /webShop/home";
    }

    // ��֤�ɹ������������

    // ���û���������ϵ��Ϣ
    List<Contact> contacts = contactService.getContacts(userName);
    // �û�������Ϣ
    UserExecution basicUserInfo = userService.getBasicInfo(userName);
    // �û�������Ϣ
    OrderExecution orderExecution = orderService.getOderInfoByUserName(userName, null, 0, 10);
    List<OrderExecution>orderInfos=new ArrayList<OrderExecution>();
    //���˹��ﳵ�ղؼ�
    orderExecution
        .setOrderInfos(
            orderExecution.getOrderInfos().stream()
                .filter(x -> x.getStatus() != OrderStatusEnum.SHOPPING_CART.getState()
                    && x.getStatus() != OrderStatusEnum.STAR.getState())
                .collect(Collectors.toList()));
    
    orderExecution.getOrderInfos().stream().forEach(x->orderInfos.add(orderService.getOrderDetail(x.getOrderNum(), loginUserName)));
    orderInfos.stream().forEach(x->{
     x.setOrderItemList(CollUtil.sub(x.getOrderItemList(), 0, 1));
     x.setProductList(CollUtil.sub(x.getProductList(), 0, 1));
    });
    // װ������
    model.addAttribute("contacts", JSON.toJSONString(contacts));
    model.addAttribute("basicUserInfo", JSON.toJSONString(basicUserInfo));
    model.addAttribute("orderInfos", JSON.toJSONString(orderInfos));
    System.out.println(JSON.toJSONString(orderInfos));
    // ǰ����������ҳ
    return "";
  }

  /**
   * 
   * <p>
   * Title: tryLogin
   * </p>
   * <p>
   * Description: ��¼�¼�
   * </p>
   * 
   * @param request ��¼�ɹ������������ѵ�¼���û���
   * @param user ��¼������
   * @return �ɹ�������ҳ ʧ���ض���ص�¼ҳ
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  private String tryLogin(User user, HttpServletRequest request) {
    boolean flag = false;
    System.out.println(user);
    try {
      flag = userService.login(user);
    } catch (Exception e) {
      logger.error(e.getMessage());
      flag = false;
    }
    if (flag == true) {
      // ��¼�ɹ�
      request.getSession().setAttribute(LOGINUSERNAME, user.getUserName());
      return "redirect: /webShop/home";
    } else {
      // ��¼ʧ��
      return "redirect: /webShop/users";
    }
  }

  /**
   * 
   * <p>
   * Title: logout
   * </p>
   * <p>
   * Description: �ǳ�����
   * </p>
   * 
   * @param request ��ȡsession�������¼����
   * @return ���ص�¼ҳ
   */
  @RequestMapping(value = "/logout", method = RequestMethod.POST)
  private String logout(HttpServletRequest request) {
    request.getSession().invalidate();
    return "redirect: /webShop/users";
  }

  /**
   * 
   * <p>
   * Title: getCart
   * </p>
   * <p>
   * Description: ǰ�����ﳵҳ��
   * </p>
   * 
   * @param userName �û���
   * @param model ��Ź��ﳵ����
   * @param request ��ȡ����
   * @return �ɹ���ǰ�����ﳵҳ�� δ��¼���ص�¼ҳ��
   */
  @RequestMapping(value = "/{userName}/carts", method = RequestMethod.GET)
  private String getCart(@PathVariable String userName, Model model, HttpServletRequest request) {
    Result<OrderExecution> result = null;
    OrderExecution orderExecution = null;
    if (ObjectUtil.notEqual(request.getSession().getAttribute(LOGINUSERNAME), userName)) {
      // δ��¼��ת����¼ҳ��
      return "redirect: /webShop/users";
    }
    try {
      result = new Result<OrderExecution>(true, orderService.getCart(userName));
    } catch (NoCartException e) {
      orderExecution = new OrderExecution();
      orderExecution.setOrderItemList(new ArrayList<OrderItem>());
      result = new Result<>(true, orderExecution);
    } catch (Exception e) {
      orderExecution = new OrderExecution();
      orderExecution.setOrderItemList(new ArrayList<OrderItem>());
      result = new Result<>(true, orderExecution);
    }
    model.addAttribute("carts", JSON.toJSONString(result));
    System.out.println(JSON.toJSONString(result));
    // ǰ�����ﳵҳ��
    return "";
  }

  /**
   * 
   * <p>
   * Title: logoff
   * </p>
   * <p>
   * Description: ע���˻�
   * </p>
   * 
   * @param user �û�
   * @param request �����������
   * @param userName �û���
   * @return ɾ���ɹ����ص�¼ҳ
   */
  @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
  private String logoff(User user, @PathVariable("userName") String userName,
      HttpServletRequest request) {
    try {
      // װ���û�����
      userService.deleteAccount(user);
    } catch (Exception e) {
      // ɾ��ʧ��,�ض�������������ҳ
      logger.error(e.getMessage());
      return "redirect: /webShop/homePage";
    }
    // ɾ���ɹ�,�������
    request.getSession().invalidate();
    // �ض�������¼ҳ
    return "redirect: /webShop/homePage";
  }

  /**
   * 
   * <p>
   * Title: addProductToCart
   * </p>
   * <p>
   * Description: ��ӽ����ﳵ
   * </p>
   * 
   * @param orderItem Ҫ��ӵ���Ʒ
   * @param userName �û���
   * @return ������ӽ�� Result
   */
  @RequestMapping(value = "/{userName}/carts/{productId}", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String addProductToCart(@RequestBody OrderItem orderItem,
      @PathVariable("userName") String userName) {
    Result<OrderItem> result = null;
    try {
      orderService.addToCart(orderItem, userName);
      result = new Result<OrderItem>(true, orderItem);
    } catch (NoProductException e) {
      result = new Result<>(false, e.getMessage());
    } catch (NoUserException e) {
      result = new Result<>(false, e.getMessage());
    } catch (AddToCartException e) {
      result = new Result<>(false, e.getMessage());
    } catch (Exception e) {
      result = new Result<>(false, e.getMessage());
      logger.error(e.getMessage());
    }
    // ���ؽ��
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: deleteCartProduct
   * </p>
   * <p>
   * Description: �ӹ��ﳵ��ɾ����Ʒ
   * </p>
   * 
   * @param userName �û���
   * @param orderExecution Ԥ��Ҫɾ������Ʒ�б�
   * @return ɾ����� ����ɾ���Ƿ�ɹ����᷵�����µĹ��ﳵ�嵥����Result.success�᲻ͬ
   */
  @RequestMapping(value = "/{userName}/carts", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteCartProduct(@PathVariable("userName") String userName,
      @RequestBody OrderExecution orderExecution) {
    Result<OrderExecution> result = null;
    OrderExecution execution = null;
    try {
      // ����ɾ���Ƿ�ɹ����᷵�����µĹ��ﳵ�嵥
      // orderExecution.getOrderItemList().stream().forEach(x->orderService.removeFromCart(x,
      // userName));
      for (OrderItem orderItem : orderExecution.getOrderItemList()) {
        try {
          orderService.removeFromCart(orderItem, userName);
        } catch (NoUserException e) {
          logger.error(e.getMessage());
          throw e;
        } catch (NoProductException e) {
          logger.error(e.getMessage());
          continue;
        } catch (Exception e) {
          logger.error(e.getMessage());
          throw e;
        }
      }
      try {
        result = new Result<OrderExecution>(true, orderService.getCart(userName));
      } catch (NoCartException e) {
        execution = new OrderExecution();
        execution.setOrderItemList(new ArrayList<>());
        result = new Result<OrderExecution>(true, execution);
      } catch (Exception e) {
        logger.error(e.getMessage());
        result = new Result<>(false, e.getMessage());
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      try {
        result = new Result<OrderExecution>(false, orderService.getCart(userName));
      } catch (NoCartException e1) {
        execution = new OrderExecution();
        execution.setOrderItemList(new ArrayList<>());
        result = new Result<OrderExecution>(true, execution);
      } catch (Exception e1) {
        logger.error(e1.getMessage());
        result = new Result<>(false, e1.getMessage());
      }
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getStarPage
   * </p>
   * <p>
   * Description: ǰ���ղؼ�ҳ�� δд�쳣����
   * </p>
   * 
   * @param userName �û���
   * @param model �������
   * @param request ��ȡ����
   * @return �ɹ���ǰ���ղؼ�ҳ��
   */
  @RequestMapping(value = "/{userName}/stars", method = RequestMethod.GET)
  private String getStarPage(@PathVariable("userName") String userName, Model model,
      HttpServletRequest request) {
    String loginUserName = StrUtil.toString(request.getSession().getAttribute(LOGINUSERNAME));
    if (StrUtil.isEmpty(loginUserName) || ObjectUtil.notEqual(userName, loginUserName)) {
      // û�е�¼,��ת����½ҳ���Ƿ�����δ��¼�û�ҳ��
      return "redirect: /webShop/users";
    }
    try {
      OrderExecution orderExecution = orderService.getStar(userName);
      orderExecution.setOrderItemList(CollUtil.sub(orderExecution.getOrderItemList(), 0, 12));
      model.addAttribute("stars", JSON.toJSONString(orderExecution));
    } catch (Exception e) {
      logger.error(e.getMessage());
    }

    // ǰ���ղؼ�ҳ��
    return "";
  }

  /**
   * 
   * <p>
   * Title: starProduct
   * </p>
   * <p>
   * Description: �ղ�һ����Ʒ
   * </p>
   * 
   * @param userName �û���
   * @param productId ��Ʒ���
   * @return Result
   */
  @RequestMapping(value = "/{userName}/stars/{productId}", method = RequestMethod.POST)
  @ResponseBody
  private String starProduct(@PathVariable("userName") String userName,
      @PathVariable("productId") long productId) {
    Result<Product> result = null;
    try {
      // ��������ղ���Ʒ
      OrderItem orderItem = new OrderItem();
      orderItem.setProductId(productId);
      orderService.addToStar(orderItem, userName);
      // ����ղؽ��
      Product product = new Product();
      product.setId(productId);
      result = new Result<>(true, product);
    } catch (NoProductException e) {
      result = new Result<>(false, e.getMessage());
    } catch (NoUserException e) {
      result = new Result<>(false, e.getMessage());
    } catch (UpdateException e) {
      result = new Result<>(false, e.getMessage());
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getStars
   * </p>
   * <p>
   * Description: ajax ��ȡ�ղؼ���Ʒ
   * </p>
   * 
   * @param userName �û���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ѯ���
   */
  @RequestMapping(value = "/{userName}/stars/{offset}/{limit}", method = RequestMethod.GET)
  @ResponseBody
  private String getStars(@PathVariable("userName") String userName,
      @PathVariable("offset") int offset, @PathVariable("limit") int limit) {
    Result<OrderExecution> result = null;
    try {
      OrderExecution orderExecution = orderService.getStar(userName);
      // ����offset limit �����ղؼ���Ʒ���鳤��
      orderExecution.setOrderItemList(
          CollUtil.sub(orderExecution.getOrderItemList(), offset, offset + limit));
      result = new Result<OrderExecution>(true, orderExecution);
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: deleteStarProduct
   * </p>
   * <p>
   * Description: ɾ���ղؼе���Ʒ
   * </p>
   * 
   * @param userName �û���
   * @param orderExecution �ڱ���Ҫɾ������Ʒ�б� ÿ����Ʒ���뺬��id orderItem.id
   * @return ����ɾ���Ƿ�ɹ����᷵�����µ��ղؼ��嵥
   */
  @RequestMapping(value = "/{userName}/stars", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteStarProduct(@PathVariable("userName") String userName,
      @RequestBody OrderExecution orderExecution) {
    OrderExecution execution = null;
    Result<OrderExecution> result = null;
    try {
      // ����ɾ���Ƿ�ɹ����᷵�����µ��ղؼ��嵥
      // orderExecution.getOrderItemList().stream().forEach(x->orderService.removeFromCart(x,
      // userName));
      for (OrderItem orderItem : orderExecution.getOrderItemList()) {
        try {
          orderService.removeFromStar(orderItem, userName);
        } catch (NoUserException e) {
          throw e;
        } catch (NoProductException e) {
          continue;
        } catch (Exception e) {
          logger.error(e.getMessage());
          throw e;
        }
      }
      try {
        result = new Result<OrderExecution>(true, orderService.getStar(userName));
      } catch (NoStarException e) {
        execution = new OrderExecution();
        execution.setOrderItemList(new ArrayList<>());
        result = new Result<OrderExecution>(true, execution);
      } catch (Exception e2) {
        logger.error(e2.getMessage());
        throw e2;
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      try {
        result = new Result<OrderExecution>(false, orderService.getStar(userName));
      } catch (NoStarException e1) {
        execution = new OrderExecution();
        execution.setOrderItemList(new ArrayList<>());
        result = new Result<OrderExecution>(true, execution);
      } catch (Exception e2) {
        logger.error(e2.getMessage());
        throw e2;
      }
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getUserContacts
   * </p>
   * <p>
   * Description: ��ȡ���û���������ϵ��Ϣ
   * </p>
   * 
   * @param userName �û���
   * @return ��ȡ��� Result
   */
  @RequestMapping(value = "/{userName}/contacts", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String getUserContacts(@PathVariable("userName") String userName) {
    List<Contact> contacts = contactService.getContacts(userName);
    Result<List<Contact>> result = null;
    if (contacts != null) {
      result = new Result<List<Contact>>(true, contacts);
    } else {
      result = new Result<List<Contact>>(true, new ArrayList<>());
    }

    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: addUserContacts
   * </p>
   * <p>
   * Description: ����һ����ϵ��ַ
   * </p>
   * 
   * @param userName �û���
   * @param contact ��ϵ��Ϣ
   * @return ������� Result
   */
  @RequestMapping(value = "/{userName}/contacts", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String addUserContacts(@PathVariable("userName") String userName,
      @RequestBody Contact contact) {

    Result<Contact> result = null;

    try {
      contactService.addContact(contact);
      if (contact.getStatus() == ContactStatusEnum.DEFAULT.getState()) {
        contactService.setDefaultContact(contact.getId(), userName);
        result = new Result<Contact>(true, contact);
      } else {
        result = new Result<Contact>(true, contact);
      }

    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: deleteUserContacts
   * </p>
   * <p>
   * Description: ɾ��һ����ϵ��ַ
   * </p>
   * 
   * @param userName �û���
   * @param contact ��ϵ��ַ
   * @return ɾ�����
   */
  @RequestMapping(value = "/{userName}/contacts", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteUserContacts(@PathVariable("userName") String userName,
      @RequestBody Contact contact) {

    Result<Contact> result = null;

    try {
      contactService.removeContact(contact);
      result = new Result<Contact>(true, contact);
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getOrderHistory
   * </p>
   * <p>
   * Description: ajax ��ȡ�û��Ķ�����ʷ
   * </p>
   * 
   * @param userName �û���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ѯ��� Result
   */
  @RequestMapping(value = "/{userName}/orderHistory", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String getOrderHistory(@PathVariable("userName") String userName,
      @RequestParam(value = "offset", defaultValue = "0") int offset,
      @RequestParam(value = "limit", defaultValue = "10") int limit) {
    Result<OrderExecution> result = null;
    try {
      OrderExecution orderExecution = orderService.getOderInfoByUserName(userName, null, 0, 10);
      orderExecution
          .setOrderInfos(orderExecution.getOrderInfos().stream()
              .filter(x -> x.getStatus() != OrderStatusEnum.SHOPPING_CART.getState()
                  && x.getStatus() != OrderStatusEnum.STAR.getState())
              .collect(Collectors.toList()));
      result = new Result<OrderExecution>(true, orderExecution);
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }

    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getOrderHistoryDetailPage
   * </p>
   * <p>
   * Description: ǰ����������ҳ�鿴��������
   * </p>
   * 
   * @param userName �û���
   * @param orderNum �������
   * @param model �������
   * @param request ��ȡ����
   * @return �ɹ�ǰ����������ҳ
   */
  @RequestMapping(value = "/{userName}/orderHistory/{orderNum}", method = RequestMethod.GET)
  private String getOrderHistoryDetailPage(@PathVariable("userName") String userName,
      @PathVariable("orderNum") String orderNum, Model model, HttpServletRequest request) {

    String loginUserName = StrUtil.toString(request.getSession().getAttribute(LOGINUSERNAME));
    if (StrUtil.isEmpty(loginUserName) || ObjectUtil.notEqual(userName, loginUserName)) {
      // û�е�¼,��ת����½ҳ���Ƿ�����δ��¼�û�ҳ��
      return "redirect: /webShop/users";
    }
    OrderExecution orderExecution = orderService.getOrderDetail(orderNum, userName);
    if (null == orderExecution.getOrderInfo()) {
      orderExecution.setOrderInfo(new OrderInfo());
    }
    if (null == orderExecution.getOrderItemList()) {
      orderExecution.setOrderItemList(new ArrayList<>());
    }
    model.addAttribute("orderExecution", JSON.toJSONString(orderExecution));
    logger.debug(JSON.toJSONString(orderExecution));
    // ǰ����������ҳ
    return "";
  }

  /**
   * 
   * <p>
   * Title: deleteOrder
   * </p>
   * <p>
   * Description:ɾ��������Ϣ������ɾ����Ķ����б��з���10��������Ϣ
   * </p>
   * 
   * @param userName �û���
   * @param orderExecution ������Ҫɾ���Ķ����б�
   * @return �������µ�10������
   */
  @RequestMapping(value = "/{userName}/orderHistory", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteOrder(@PathVariable("userName") String userName,
      @RequestBody OrderExecution orderExecution) {
    Result<OrderExecution> result = null;
    OrderExecution resultExecution = null;
    try {
      // ����ɾ��
      for (OrderInfo orderInfo : orderExecution.getOrderInfos()) {
        orderService.deleteOrder(orderInfo.getOrderNum());
      }
      // ��ȡ10��������ʷ
      resultExecution = orderService.getOderInfoByUserName(userName, null, 0, 10);
      resultExecution
          .setOrderInfos(resultExecution.getOrderInfos().stream()
              .filter(x -> x.getStatus() != OrderStatusEnum.SHOPPING_CART.getState()
                  && x.getStatus() != OrderStatusEnum.STAR.getState())
              .collect(Collectors.toList()));
      result = new Result<OrderExecution>(true, resultExecution);

    } catch (Exception e) {
      // ɾ��ʧ�ܣ���ȡ���µ���ʷ����������
      logger.error(e.getMessage());
      resultExecution = orderService.getOderInfoByUserName(userName, null, 0, 10);
      resultExecution
          .setOrderInfos(resultExecution.getOrderInfos().stream()
              .filter(x -> x.getStatus() != OrderStatusEnum.SHOPPING_CART.getState()
                  && x.getStatus() != OrderStatusEnum.STAR.getState())
              .collect(Collectors.toList()));
      result = new Result<OrderExecution>(false, resultExecution);
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: updateUserBasicInfo
   * </p>
   * <p>
   * Description: �����û��Ļ�����Ϣ ����������
   * </p>
   * 
   * @param user �û���Ϣ User
   * @param request ��ȡ����
   * @param userName ������û���
   * @return ���½��
   */
  @RequestMapping(value = "/{userName}", method = RequestMethod.PUT,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String updateUserBasicInfo(@RequestBody User user, HttpServletRequest request,
      @PathVariable("userName") String userName) {

    Result<UserExecution> result = null;
    try {
      String loginUserName = StrUtil.toString(request.getSession().getAttribute(LOGINUSERNAME));
      if (ObjectUtil.isNull(request.getSession().getAttribute(LOGINUSERNAME))
          || ObjectUtil.notEqual(userName, loginUserName)) {
        // �û������ѵ�¼���û�����һ��
        throw new NoUserException("invalid request");
      }
      System.out.println(user);
      userService.updateUserInfo(user);
      result = new Result<UserExecution>(true, userService.getBasicInfo(user.getUserName()));
    } catch (NoUserException e) {
      result = new Result<>(false, e.getMessage());
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: resetPassword
   * </p>
   * <p>
   * Description: ��������
   * </p>
   * 
   * @param oldPassword ԭ����
   * @param newPassword ������
   * @param request ��ȡ����
   * @param userName �û���
   * @return �޸Ľ��
   */
  @RequestMapping(value = "/{userName}/password", method = RequestMethod.PUT,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String resetPassword(@RequestParam("oldPassword") String oldPassword,
      @RequestParam("newPassword") String newPassword, HttpServletRequest request,
      @PathVariable("userName") String userName) {
    Result<Boolean> result = null;
    try {
      String loginUserName = StrUtil.toString(request.getSession().getAttribute(LOGINUSERNAME));
      if (ObjectUtil.isNull(request.getSession().getAttribute(LOGINUSERNAME))
          || ObjectUtil.notEqual(userName, loginUserName)) {
        // �û������ѵ�¼���û�����һ��
        throw new NoUserException("invalid request");
      }
      if (userService.checkPassword(userName, oldPassword) == false) {
        // �������
        throw new WrongUserNamePwdException("wrong password");
      } else {
        User user = new User();
        user.setPassword(newPassword);
        user.setUserName(userName);
        boolean flag = userService.updatePassword(user) > 0 ? true : false;
        result = new Result<Boolean>(flag, flag);
      }

    } catch (WrongUserNamePwdException e) {
      result = new Result<>(false, e.getMessage());
    } catch (NoUserException e) {
      result = new Result<>(false, e.getMessage());
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getOrderPage
   * </p>
   * <p>
   * Description: ǰ������ҳ��
   * </p>
   * 
   * @param orderExecution ���Ҫ�������Ʒ�嵥orderItemList
   * @param model ת�������嵥������ҳ��
   * @param userName �û���
   * @param request ��ȡ����
   * @return ����ҳ��
   */
  @RequestMapping(value = "/{userName}/carts/order", method = RequestMethod.POST)
  private String getOrderPage(OrderExecution orderExecution, Model model,
      @PathVariable("userName") String userName, HttpServletRequest request) {
    String loginUserName = StrUtil.toString(request.getSession().getAttribute(LOGINUSERNAME));
    if (ObjectUtil.isNull(request.getSession().getAttribute(LOGINUSERNAME))
        || ObjectUtil.notEqual(userName, loginUserName)) {
      // �û������ѵ�¼���û�����һ��
      // �ض�������¼ҳ
      return "redirect: /webShop/users";
    }
    model.addAttribute("orderExecution", JSON.toJSONString(orderExecution));
    logger.debug(JSON.toJSONString(orderExecution));
    // ǰ������֧��ҳ
    return "";
  }

  /**
   * 
   * <p>
   * Title: buyProducts
   * </p>
   * <p>
   * Description: ajax�µ������Ʒ
   * </p>
   * 
   * @param userName �û���
   * @param orderExecution ��Ź��������Ϣ
   * @return ������
   */
  @RequestMapping(value = "/{userName}/order", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String buyProducts(@PathVariable("userName") String userName,
      @RequestBody OrderExecution orderExecution) {
    Result<OrderExecution> result = null;
    Contact contact = null;
    try {
      contact = new Contact();
      contact.setContactAddress(orderExecution.getOrderInfo().getContactAddress());
      contact.setContactMobile(orderExecution.getOrderInfo().getContactMobile());
      contact.setContactName(orderExecution.getOrderInfo().getContactName());
      
      //������Ʒ�������ò�ͬ����ʽ
      int minSize=2;
      if (orderExecution.getOrderItemList().size() < minSize) {
        // �����µ�����һ����Ʒ
        result = new Result<OrderExecution>(true,
            orderService.buyOneNow(orderExecution.getOrderItemList().get(0), userName, contact,
                orderExecution.getOrderInfo().getMessage()));
      } else {
        // �����ﳵ�ڵ���Ʒ
        result = new Result<OrderExecution>(true, orderService.buyGoods(orderExecution));
      }
    } catch (NotEnoughQuantityException e) {
      result = new Result<>(false, e.getMessage());
    } catch (NoUserException e) {
      result = new Result<>(false, e.getMessage());
    } catch (CreateOrderException e) {
      result = new Result<>(false, e.getMessage());
    } catch (InfoEmptyException e) {
      result = new Result<>(false, e.getMessage());
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }
}
