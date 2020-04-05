/**
 * <p>
 * Title: AdminCategoryController.java
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

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.zl.webshop.dto.Result;
import com.zl.webshop.entity.ProductCategory;
import com.zl.webshop.service.AdminCategoryService;

/**
 * <p>
 * Title: AdminCategoryController
 * </p>
 * <p>
 * Description: ��̨������������ ���������ɾ�Ĳ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��2��
 *         </p>
 */
@Controller
@RequestMapping(value = "/admin/categories")
public class AdminCategoryController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private AdminCategoryService adminCategoryService;

  /**
   * 
   * <p>
   * Title: getCategories
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
  private String getCategories(@RequestParam(value = "searchText" ,required = false) String searchText,
      @RequestParam("offset") int offset, @RequestParam("limit") int limit) {
    Result<List<ProductCategory>> result = null;
    try {
      result = new Result<List<ProductCategory>>(true,
          adminCategoryService.getCategories(searchText, offset, limit));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: deleteCategories
   * </p>
   * <p>
   * Description: ɾ������
   * </p>
   * 
   * @param category ����
   * @return ɾ�����
   */
  @RequestMapping(value = "", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteCategories(@RequestBody ProductCategory category) {
    Result<Integer> result = null;
    try {
      result = new Result<Integer>(true, adminCategoryService.deleteCateGory(category));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: updateCategories
   * </p>
   * <p>
   * Description: ���·��������Ϣ
   * </p>
   * 
   * @param category ����
   * @return ���½��
   */
  @RequestMapping(value = "", method = RequestMethod.PUT,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String updateCategories(@RequestBody ProductCategory category) {
    Result<ProductCategory> result = null;
    try {
      result = new Result<ProductCategory>(true, adminCategoryService.updateCategory(category));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: addCategories
   * </p>
   * <p>
   * Description: ��ӷ���
   * </p>
   * 
   * @param category ����
   * @return ��Ʒ��ǰ����
   */
  @RequestMapping(value = "", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String addCategories(@RequestBody ProductCategory category) {
    Result<Integer> result = null;
    try {
      result = new Result<Integer>(true, adminCategoryService.addCategory(category));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }
}
