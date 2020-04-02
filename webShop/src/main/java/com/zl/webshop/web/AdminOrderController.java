/**
 * <p>
 * Title: AdminOrderController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��4��2��
 * </p>
 * @version 1.0
 */
package com.zl.webshop.web;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.zl.webshop.dto.OrderExecution;
import com.zl.webshop.dto.Result;
import com.zl.webshop.enums.OrderStatusEnum;
import com.zl.webshop.service.AdminOrderService;

/**
 * <p>
 * Title: AdminOrderController
 * </p>
 * <p>
 * Description: ��̨������������� ���𶩵�ɾ�Ĳ����
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��4��2��
 * </p>
 */
@Controller
@RequestMapping(value = "/admin/orders")
public class AdminOrderController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private AdminOrderService adminOrderService;

  /**
   * 
   * <p>
   * Title: getOrders
   * </p>
   * <p>
   * Description: ��ȡ�����б�
   * </p>
   * 
   * @param searchText �����ؼ��� �ɲ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ѯ���
   */
  @RequestMapping(value = "", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String getOrders(@RequestParam(value = "searchText",required = false) String searchText,
      @RequestParam("offset") int offset, @RequestParam("limit") int limit) {
    Result<List<OrderExecution>> result = null;
    try {
      result = new Result<List<OrderExecution>>(true,
          adminOrderService.getOrderInfos(searchText, offset, limit));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: deleteOrders
   * </p>
   * <p>
   * Description: ɾ������
   * </p>
   * 
   * @param orderNum �������
   * @return ɾ�����
   */
  @RequestMapping(value = "", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteOrders(String orderNum) {
    Result<Integer> result = null;
    try {
      result = new Result<Integer>(true, adminOrderService.deleteOrderHistory(orderNum));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: updateOrdersStatus
   * </p>
   * <p>
   * Description: ���·��������Ϣ
   * </p>
   * 
   * @param orderNum �������
   * @param status ����״̬
   * @return ���½��
   */
  @RequestMapping(value = "", method = RequestMethod.PUT,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String updateOrdersStatus(@RequestParam("orderNum") String orderNum,
      @RequestParam("status") int status) {
    Result<OrderExecution> result = null;
    try {
      result = new Result<OrderExecution>(true,
          adminOrderService.updateOrderStatus(OrderStatusEnum.stateOf(status), orderNum));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }
}
