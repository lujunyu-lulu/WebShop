/**
 * <p>
 * Title: OrderServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��21��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zl.webshop.dao.OrderHistoryDao;
import com.zl.webshop.dao.OrderInfoDao;
import com.zl.webshop.dao.OrderItemDao;
import com.zl.webshop.dao.ProductDao;
import com.zl.webshop.dao.UserDao;
import com.zl.webshop.dto.OrderExecution;
import com.zl.webshop.entity.Contact;
import com.zl.webshop.entity.OrderHistory;
import com.zl.webshop.entity.OrderInfo;
import com.zl.webshop.entity.OrderItem;
import com.zl.webshop.entity.Product;
import com.zl.webshop.enums.OrderStatusEnum;
import com.zl.webshop.exception.AddToCartException;
import com.zl.webshop.exception.CartStatusException;
import com.zl.webshop.exception.CreateOrderException;
import com.zl.webshop.exception.DeleteException;
import com.zl.webshop.exception.InfoEmptyException;
import com.zl.webshop.exception.NoCartException;
import com.zl.webshop.exception.NoProductException;
import com.zl.webshop.exception.NoStarException;
import com.zl.webshop.exception.NoUserException;
import com.zl.webshop.exception.NotEnoughQuantityException;
import com.zl.webshop.exception.ProductLostException;
import com.zl.webshop.exception.StarStatusException;
import com.zl.webshop.exception.UpdateException;
import com.zl.webshop.service.OrderService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;

/**
 * <p>
 * Title: OrderServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��21��
 *         </p>
 */
@Service
public class OrderServiceImpl implements OrderService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private OrderInfoDao orderInfoDao;
  @Autowired
  private OrderItemDao orderItemDao;
  @Autowired
  private OrderHistoryDao orderHistoryDao;
  @Autowired
  private ProductDao productDao;
  @Autowired
  private UserDao userDao;

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public int addToCart(OrderItem orderItem, String userName) {
    int index = 0;
    int standardCount = 2;
    try {
      // ��ȡ��̨��ʵ��Ʒ����
      Product realProduct = productDao.queryById(orderItem.getProductId());
      if (null == realProduct) {
        // ��ȡ��Ʒʧ��
        throw new NoProductException("no Product");
      }
      if (null == userDao.queryByUserName(userName)) {
        // ��ȡ�û�ʧ��
        throw new NoUserException("no User");
      }
      // ���ﳵ����ɡ�000000��+userName���
      String orderNum = DigestUtil.md5Hex("000000" + userName);
      if (null == orderInfoDao.queryByOrderNum(orderNum)) {
        // �Ҳ������ﳵ�������������ﳵ
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNum(orderNum);
        orderInfo.setStatus(OrderStatusEnum.SHOPPING_CART.getState());
        orderInfo.setUserName(userName);
        // �ܽ��
        orderInfo.setPrice(realProduct.getShopPrice() * orderItem.getQuantity());
        // ����orderItem����
        orderItem.setOrderNum(orderNum);
        orderItem.setPrice(realProduct.getShopPrice());
        orderItem.setProductId(realProduct.getId());
        orderItem.setProductName(realProduct.getProductName());
        orderItem.setUserName(userName);
        // �������ݿ�
        index += orderInfoDao.addOrderInfo(orderInfo);
        index += orderItemDao.addOrderItem(orderItem);
        if (index < standardCount) {
          throw new AddToCartException("add to Cart error");
        }
      } else {
        // ���й��ﳵ����
        // ����orderItem����
        orderItem.setOrderNum(orderNum);
        orderItem.setPrice(realProduct.getShopPrice());
        orderItem.setProductId(realProduct.getId());
        orderItem.setProductName(realProduct.getProductName());
        orderItem.setUserName(userName);

        // ���²��������ݿ�
        index += orderItemDao.addOrderItem(orderItem);
        // �޸Ĺ��ﳵ�ܽ��
        OrderInfo orderInfo = orderInfoDao.queryByOrderNum(orderNum);
        orderInfo.setPrice(0);
        orderItemDao.queryByUserNameAndOrderNum(userName, orderNum).stream().forEach(
            x -> orderInfo.setPrice(orderInfo.getPrice() + x.getPrice() * x.getQuantity()));
        index += orderInfoDao.updateOrderInfo(orderInfo);
        if (index < standardCount) {
          throw new AddToCartException("add to Cart error");
        }
      }
    } catch (NoProductException e) {
      throw e;
    } catch (NoUserException e) {
      throw e;
    } catch (AddToCartException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new UpdateException("addToCart inner error:" + e.getMessage());
    }
    return index;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public int removeFromCart(OrderItem orderItem, String userName) {
    int index = 0;
    try {
      // ��ȡ��̨��ʵ��Ʒ����
      Product realProduct = productDao.queryById(orderItem.getProductId());
      if (null == realProduct) {
        // ��ȡ��Ʒʧ��
        throw new NoProductException("no Product");
      }
      if (null == userDao.queryByUserName(userName)) {
        // ��ȡ�û�ʧ��
        throw new NoUserException("no User");
      }
      // ���ﳵ����ɡ�000000��+userName���
      String orderNum = DigestUtil.md5Hex("000000" + userName);
      // ��ȡ���ﳵ��Ϣ
      OrderInfo orderInfo = orderInfoDao.queryByOrderNum(orderNum);
      // ����ɾ�����ﳵ��Ʒ
      index += orderItemDao.deleteOrderItem(orderItem);
      // ���蹺�ﳵ�ܽ��
      orderInfo.setPrice(orderInfo.getPrice() - orderItem.getPrice() * orderItem.getQuantity());
      if (orderItemDao.countByOrderNum(orderNum) == 0) {
        // ������ﳵ������Ʒ��ɾ�����ﳵ����
        index += orderInfoDao.deleteOrderInfo(orderInfo);
      } else {
        // ������¹��ﳵ�ܽ��
        index += orderInfoDao.updateOrderInfo(orderInfo);
      }
    } catch (NoProductException e) {
      throw e;
    } catch (NoUserException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new DeleteException("removeFromCart inner error:" + e.getMessage());
    }
    return index;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public int updateProductQuantityInCart(OrderItem orderItem, String userName) {
    int index = 0;
    try {
      if (ObjectUtil.isEmpty(userDao.queryByUserName(userName))) {
        throw new NoUserException("no user");
      }
      if (ObjectUtil.isAllEmpty(orderItem.getOrderNum(), orderItem.getProductId(),
          orderItem.getQuantity())) {
        // ��Ϣȱʧ
        throw new InfoEmptyException("empty information");
      }
      Product product = productDao.queryById(orderItem.getProductId());
      if (ObjectUtil.isEmpty(product)) {
        // ���޴˲�Ʒ
        throw new NoProductException("no product");
      }
      if (product.getQuantity() < orderItem.getQuantity()) {
        // ��治��
        throw new NotEnoughQuantityException("insufficient inventory");
      }
      OrderItem oldItem = orderItemDao.queryById(orderItem.getId());
      index = orderItemDao.updateOrderItem(orderItem);
      // ���¹��ﳵ�ܼ۸�
      OrderInfo orderInfo = orderInfoDao.queryByOrderNum(orderItem.getOrderNum());
      orderInfo.setPrice(orderInfo.getPrice() - (oldItem.getPrice() * oldItem.getQuantity())
          + (orderItem.getPrice() * orderItem.getQuantity()));
      orderInfoDao.updateOrderInfo(orderInfo);
    } catch (NoUserException e) {
      throw e;
    } catch (NoProductException e) {
      throw e;
    } catch (InfoEmptyException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("updateProductQuantityInCart inner error:" + e.getMessage());
    }
    return index;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public OrderExecution buyOneNow(OrderItem orderItem, String userName, Contact contact,
      String message) {
    OrderExecution orderExecution = null;
    int standardCount = 1;
    try {
      if (StrUtil.isAllEmpty(contact.getContactAddress(), contact.getContactName(),
          contact.getContactMobile(), userName)) {
        throw new InfoEmptyException("empty information");
      }
      if (null == userDao.queryByUserName(userName)) {
        throw new NoUserException("no user");
      }
      String orderNum = IdUtil.simpleUUID();
      Product product = productDao.queryById(orderItem.getProductId());
      if (product.getQuantity() < orderItem.getQuantity()) {
        // �����������ڲ�Ʒӵ������
        throw new NotEnoughQuantityException("insufficient inventory");
      }
      // �½�����
      OrderInfo orderInfo = new OrderInfo();
      orderInfo.setOrderNum(orderNum);
      orderInfo.setUserName(userName);
      orderInfo.setContactAddress(contact.getContactAddress());
      orderInfo.setContactMobile(contact.getContactMobile());
      orderInfo.setContactName(contact.getContactName());
      orderInfo.setPrice(product.getShopPrice() * orderItem.getQuantity());
      orderInfo.setStatus(OrderStatusEnum.ORDER_PAYED.getState());
      orderInfo.setMessage(message);
      if (orderInfoDao.addOrderInfo(orderInfo) < standardCount) {
        throw new CreateOrderException("createOrderInfo error");
      }
      // ���ö�����Ŀ
      orderItem.setUserName(userName);
      orderItem.setOrderNum(orderNum);
      orderItem.setProductName(product.getProductName());
      orderItem.setPrice(product.getShopPrice());
      if (orderItemDao.addOrderItem(orderItem) < standardCount) {
        throw new CreateOrderException("createOrderItem error");
      }
      // ���ö�����ʷ
      OrderHistory orderHistory = new OrderHistory();
      orderHistory.setOrderNum(orderNum);
      orderHistory.setStatus(OrderStatusEnum.ORDER_PAYED.getState());
      orderHistory.setCreateTime(orderInfoDao.queryByOrderNum(orderNum).getCreateTime());
      if (orderHistoryDao.addOrderHistory(orderHistory) < standardCount) {
        throw new CreateOrderException("createOrderHistory error");
      }
      // ���¿��
      product.setQuantity(product.getQuantity() - orderItem.getQuantity());
      productDao.updateProduct(product);
      // ����ɹ�������Ϣ
      orderExecution = new OrderExecution(orderInfo, OrderStatusEnum.ORDER_PAYED);
    } catch (NotEnoughQuantityException e) {
      throw e;
    } catch (NoUserException e) {
      throw e;
    } catch (CreateOrderException e) {
      throw e;
    } catch (InfoEmptyException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("buyOneNow inner error:" + e.getMessage());
    }
    return orderExecution;
  }

  @Override
  @Transactional(rollbackFor = RuntimeException.class)
  public OrderExecution buyGoods(OrderExecution orderExecution) {
    OrderExecution result = null;
    try {
      if (StrUtil.isAllEmpty(orderExecution.getOrderInfo().getContactAddress(),
          orderExecution.getOrderInfo().getContactName(),
          orderExecution.getOrderInfo().getContactMobile(),
          orderExecution.getOrderInfo().getUserName())) {
        throw new InfoEmptyException("empty information");
      }
      if (null == userDao.queryByUserName(orderExecution.getOrderInfo().getUserName())) {
        throw new NoUserException("no user");
      }
      // ���ö���
      String orderNum = IdUtil.simpleUUID();
      orderExecution.getOrderInfo().setOrderNum(orderNum);
      orderExecution.getOrderInfo().setStatus(OrderStatusEnum.ORDER_PAYED.getState());
      orderInfoDao.addOrderInfo(orderExecution.getOrderInfo());

    /*  // ɾ�����ﳵ��ѡ��Ҫ����Ĳ�Ʒ
      orderExecution.getOrderItemList().forEach(x -> orderItemDao.deleteOrderItem(x));
      if (orderItemDao
          .countByOrderNum(orderExecution.getOrderItemList().get(0).getOrderNum()) < 1) {
        // ���ﳵ�ڲ�Ʒȫ��գ���ɾ������
        orderInfoDao.deleteOrderInfo(
            orderInfoDao.queryByOrderNum(orderExecution.getOrderItemList().get(0).getOrderNum()));
      }*/
      // ����Ҫ����Ĳ�Ʒ
      float totalPrice = 0f;
      for (OrderItem orderItem : orderExecution.getOrderItemList()) {
        Product product = productDao.queryById(orderItem.getProductId());
        if (product.getQuantity() < orderItem.getQuantity()) {
          // �����������ڲ�Ʒӵ������
          throw new NotEnoughQuantityException("insufficient inventory");
        }
        // У������Ĳ�Ʒ����
        orderItem.setOrderNum(orderNum);
        orderItem.setPrice(product.getShopPrice());
        orderItem.setProductName(product.getProductName());
        orderItem.setUserName(orderExecution.getOrderInfo().getUserName());
        // �����ܼ۸�
        totalPrice += orderItem.getPrice() * orderItem.getQuantity();
        // ��Ӷ�����Ŀ
        orderItemDao.addOrderItem(orderItem);
        // ���¿��
        product.setQuantity(product.getQuantity() - orderItem.getQuantity());
        productDao.updateProduct(product);
      }
      // �����ܼ۸�
      orderExecution.getOrderInfo().setPrice(totalPrice);
      System.out.println(orderExecution.getOrderInfo().getPrice());
      System.out.println(orderInfoDao.updateOrderInfo(orderExecution.getOrderInfo()));
      // ����������ʷ
      OrderHistory orderHistory = new OrderHistory();
      orderHistory.setOrderNum(orderNum);
      orderHistory.setStatus(OrderStatusEnum.ORDER_PAYED.getState());
      orderHistory.setCreateTime(orderInfoDao.queryByOrderNum(orderNum).getCreateTime());
      orderHistoryDao.addOrderHistory(orderHistory);
      // ���÷���
      result =
          new OrderExecution(orderInfoDao.queryByOrderNum(orderNum), OrderStatusEnum.ORDER_PAYED);

    } catch (NotEnoughQuantityException e) {
      throw e;
    } catch (NoUserException e) {
      throw e;
    } catch (CreateOrderException e) {
      throw e;
    } catch (InfoEmptyException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("buyGoods inner error:" + e.getMessage());
    }
    return result;
  }

  @Override
  public OrderExecution getCart(String userName) {
    OrderExecution orderExecution = null;
    try {
      if (null == userDao.queryByUserName(userName)) {
        // ��ȡ�û�ʧ��
        throw new NoUserException("no User");
      }
      // ���ﳵ����ɡ�000000��+userName���
      String orderNum = DigestUtil.md5Hex("000000" + userName);
      OrderInfo orderInfo = orderInfoDao.queryByOrderNum(orderNum);
      if (orderInfo == null) {
        throw new NoCartException("no cart");
      }
      if (ObjectUtil.notEqual(OrderStatusEnum.SHOPPING_CART,
          OrderStatusEnum.stateOf(orderInfo.getStatus()))) {
        throw new CartStatusException("cartOrder status error");
      }
      List<OrderItem> orderItems = orderItemDao.queryByUserNameAndOrderNum(userName, orderNum);
      if (orderItems.size() < 1) {
        throw new NoCartException("no cart");
      }
      //���ƹ��ﳵ����
      orderItems=CollUtil.sub(orderItems, 0, 12);
      List<Product> products = new ArrayList<Product>();
      orderItems.forEach(x -> products.add(productDao.queryById(x.getProductId())));
      if (orderItems.size() != products.size()) {
        throw new ProductLostException("can not find product");
      }
      orderExecution = new OrderExecution(orderInfo, orderItems, products,
          OrderStatusEnum.stateOf(orderInfo.getStatus()));
    } catch (NoUserException e) {
      throw e;
    } catch (NoCartException e) {
      throw e;
    } catch (ProductLostException e) {
      throw e;
    } catch (CartStatusException e) {
      throw e;
    }catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("getCart inner error:" + e.getMessage());
    }
    return orderExecution;
  }

  @Override
  public OrderExecution getOderInfoByUserName(String userName, OrderStatusEnum status, int offset,
      int limit) {
    OrderExecution orderExecution = null;
    List<OrderInfo> orderInfos=null;
    try {
      if (null == userDao.queryByUserName(userName)) {
        // ��ȡ�û�ʧ��
        throw new NoUserException("no User");
      }
      if (status != null) {
        // ���˵��Ǵ�״̬�Ķ���
        orderInfos = orderInfoDao.queryByUserName(userName, offset, limit).stream()
            .filter(x -> x.getStatus() != status.getState()).collect(Collectors.toList());
      } else {
          orderInfos=orderInfoDao.queryByUserName(userName, offset, limit);
      }
      orderExecution=new OrderExecution();
      //װ������
      orderExecution.setOrderInfos(orderInfos);
      if(ObjectUtil.isNotEmpty(status)) {
        orderExecution.setState(status.getState());
        orderExecution.setStateInfo(status.getStateInfo());
      }
    }catch (NoUserException e) {
      throw e;
    } 
    catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }
    return orderExecution;
  }

  @Override
  public int addToStar(OrderItem orderItem, String userName) {
    int index = 0;
    int standardCount = 2;
    try {
      // ��ȡ��̨��ʵ��Ʒ����
      Product realProduct = productDao.queryById(orderItem.getProductId());
      if (null == realProduct) {
        // ��ȡ��Ʒʧ��
        throw new NoProductException("no Product");
      }
      if (null == userDao.queryByUserName(userName)) {
        // ��ȡ�û�ʧ��
        throw new NoUserException("no User");
      }
      // ���ﳵ����ɡ�111111��+userName���
      String orderNum = DigestUtil.md5Hex("111111" + userName);
      if (null == orderInfoDao.queryByOrderNum(orderNum)) {
        // �Ҳ����ղؼж������������ﳵ
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNum(orderNum);
        orderInfo.setStatus(OrderStatusEnum.STAR.getState());
        orderInfo.setUserName(userName);
        
        // ����orderItem����
        orderItem.setOrderNum(orderNum);
        orderItem.setPrice(realProduct.getShopPrice());
        orderItem.setProductId(realProduct.getId());
        orderItem.setProductName(realProduct.getProductName());
        orderItem.setUserName(userName);
        orderItem.setQuantity(1);
        // �������ݿ�
        index += orderInfoDao.addOrderInfo(orderInfo);
        index += orderItemDao.addOrderItem(orderItem);
        if (index < standardCount) {
          throw new UpdateException("add to star error");
        }
      } else {
        // ���й��ﳵ����
        // ����orderItem����
        orderItem.setOrderNum(orderNum);
        orderItem.setPrice(realProduct.getShopPrice());
        orderItem.setProductId(realProduct.getId());
        orderItem.setProductName(realProduct.getProductName());
        orderItem.setUserName(userName);
        orderItem.setQuantity(1);
        // ���²��������ݿ�
        index += orderItemDao.addOrderItem(orderItem);
        if (index < standardCount-1) {
          throw new UpdateException("add to star error");
        }
      }
    } catch (NoProductException e) {
      throw e;
    } catch (NoUserException e) {
      throw e;
    } catch (UpdateException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new UpdateException("addToStar inner error:" + e.getMessage());
    }
    return index;
  }

  @Override
  public int removeFromStar(OrderItem orderItem, String userName) {
    int index = 0;
    try {
      // ��ȡ��̨��ʵ��Ʒ����
      Product realProduct = productDao.queryById(orderItem.getProductId());
      if (null == realProduct) {
        // ��ȡ��Ʒʧ��
        throw new NoProductException("no Product");
      }
      if (null == userDao.queryByUserName(userName)) {
        // ��ȡ�û�ʧ��
        throw new NoUserException("no User");
      }
      // �ղؼб���ɡ�111111��+userName���
      String orderNum = DigestUtil.md5Hex("111111" + userName);
      // ��ȡ�ղؼ���Ϣ
      OrderInfo orderInfo = orderInfoDao.queryByOrderNum(orderNum);
      // ����ɾ���ղؼ���Ʒ
      orderItem.setUserName(userName);
      index += orderItemDao.deleteOrderItem(orderItem);
      if (orderItemDao.countByOrderNum(orderNum) == 0) {
        // ������ﳵ������Ʒ��ɾ�����ﳵ����
        index += orderInfoDao.deleteOrderInfo(orderInfo);
      } 
    } catch (NoProductException e) {
      throw e;
    } catch (NoUserException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new DeleteException("removeFromStar inner error:" + e.getMessage());
    }
    return index;
  }

  @Override
  public OrderExecution getStar(String userName) {
    OrderExecution orderExecution = null;
    try {
      if (null == userDao.queryByUserName(userName)) {
        // ��ȡ�û�ʧ��
        throw new NoUserException("no User");
      }
      // �ղؼб���ɡ�111111��+userName���
      String orderNum = DigestUtil.md5Hex("111111" + userName);
      OrderInfo orderInfo = orderInfoDao.queryByOrderNum(orderNum);
      if (orderInfo == null) {
        throw new NoStarException("no star");
      }
      if (ObjectUtil.notEqual(OrderStatusEnum.STAR,
          OrderStatusEnum.stateOf(orderInfo.getStatus()))) {
        throw new StarStatusException("star status error");
      }
      List<OrderItem> orderItems = orderItemDao.queryByUserNameAndOrderNum(userName, orderNum);
      if (orderItems.size() < 1) {
        throw new NoStarException("no star");
      }
      List<Product> products = new ArrayList<Product>();
      orderItems.forEach(x -> products.add(productDao.queryById(x.getProductId())));
      if (orderItems.size() != products.size()) {
        throw new ProductLostException("can not find product");
      }
      orderExecution = new OrderExecution(orderInfo, orderItems, products,
          OrderStatusEnum.stateOf(orderInfo.getStatus()));
    } catch (NoUserException e) {
      throw e;
    } catch (NoStarException e) {
      throw e;
    } catch (ProductLostException e) {
      throw e;
    }catch (StarStatusException e) {
      throw e;
    } 
    catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException("getStar inner error:" + e.getMessage());
    }
    return orderExecution;
  }

  @Override
  public OrderExecution getOrderDetail(String orderNum,String userName) {
    OrderInfo orderInfo=orderInfoDao.queryByOrderNum(orderNum);
    List<OrderItem>orderItems=orderItemDao.queryByUserNameAndOrderNum(userName, orderNum);
    List<Product> products = new ArrayList<Product>();
    orderItems.forEach(x -> products.add(productDao.queryById(x.getProductId())));
    OrderExecution orderExecution=new OrderExecution(orderInfo, orderItems, OrderStatusEnum.stateOf(orderInfo.getStatus()));
    orderExecution.setProductList(products);
    return orderExecution;
  }

  @Override@Transactional(rollbackFor = RuntimeException.class)
  public int deleteOrder(String orderNum) {
    int index=0;
    try {
      //��ɾ��Ŀ��ɾ������ʷ�Ͷ�����
      index+=orderItemDao.deleteOrderItemByOrderNum(orderNum);
      index+=orderHistoryDao.deleteByOrderNum(orderNum);
      index+=orderInfoDao.deleteByOrderNum(orderNum);
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
   
    return index;
  }

}
