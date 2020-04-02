/**
 * <p>
 * Title: HomeController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��23��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.web;

import java.util.ArrayList;
import java.util.List;
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
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.dto.Result;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.ProductCategory;
import com.zl.webshop.exception.NoProductException;
import com.zl.webshop.service.ProductService;
import cn.hutool.core.util.RandomUtil;

/**
 * <p>
 * Title: TestController
 * </p>
 * <p>
 * Description: ������������ ���ڲ���ǰ��˽����ĺ���
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��23��
 *         </p>
 */
@Controller
public class TestController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private ProductService productService;

  
   
  /**
   * 
   * <p>
   * Title: showHomePage
   * </p>
   * <p>
   * Description: ����ǰ����ҳ�����󣬲�������ҳ��Ҫ������
   * </p>
   * 
   * @param model ������ݵĵط�
   * @return "categories" ������� "rollProducts"�����Ƽ��Ĳ�Ʒ"randomProducts"�������Ʒչʾ8�飬1��4��
   */
  @RequestMapping(value = "/homePage", method = RequestMethod.GET)
  private String showHomePage(Model model) {
    // ��ȡ��Ʒ���
    List<ProductCategory> categories = productService.getCategories();
    // ��ȡ��ҳ�����Լ��Ƽ�
    List<Product> rollProducts = null;
    try {
      rollProducts = productService.getProductsRandom(7).getProductList();
    } catch (Exception e) {
      logger.error(e.getMessage());
      // ʧ�ܷ��ؿ�����
      rollProducts = new ArrayList<Product>();
    }
    ProductExecution productExecution = null;
    // ��ȡ���չʾ��Ʒ
    List<ProductExecution> randomProducts = new ArrayList<ProductExecution>();
    // ���8������ �ٴӸ������������������4����Ʒ
    int categoriesCount=8;
    for (ProductCategory category : RandomUtil.randomEles(categories, categoriesCount)) {
      try {
        productExecution = productService.getProductsRandom(category.getId(), 4);
        randomProducts.add(productExecution);
      } catch (NoProductException e) {
        logger.error(e.getMessage());
        continue;
      } catch (Exception e) {
        logger.error(e.getMessage());
        continue;
      }
    }
    // ����model
    model.addAttribute("categories", JSON.toJSONString(categories));
    model.addAttribute("rollProducts", rollProducts);
    model.addAttribute("randomProducts", randomProducts);
    // WEB-INF/jsp/home/homePage.jsp
    return "/home/homePage";
  }

  /**
   * 
   * <p>
   * Title: searchProduct
   * </p>
   * <p>
   * Description: ǰ������ҳ���������
   * </p>
   * 
   * @param searchText �����ؼ���
   * @param model ������ݵĵط�
   * @return "products" �����һҳ��������� Ĭ��40�� "searchText" �����ؼ��ʣ����ں�������
   */
  @RequestMapping(value = "/homePage/search/{searchText}", method = RequestMethod.GET)
  private String searchProduct(@PathVariable("searchText") String searchText, Model model) {
    ProductExecution productExecution = productService.searchByText(searchText, 0, 40);
    model.addAttribute("products", JSON.toJSONString(productExecution));
    model.addAttribute("searchText", searchText);
    // WEB-INF/jsp/home/search.jsp
    return "/home/search";
  }

  /**
   * 
   * <p>
   * Title: searchProduct
   * </p>
   * <p>
   * Description: ����ҳ��ʹ��ajax���в���
   * </p>
   * 
   * @param searchText �����ؼ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return �������
   */
  @RequestMapping(value = "/homePage/search", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String searchProduct(@RequestParam("searchText") String searchText,
      @RequestParam("offset") int offset, @RequestParam("limit") int limit) {
    ProductExecution productExecution = null;
    Result<ProductExecution> result = null;
    try {
      productExecution = productService.searchByText(searchText, offset, limit);
      result = new Result<ProductExecution>(true, productExecution);
    } catch (NoProductException e) {
      result = new Result<>(false, e.getMessage());
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }

    String resultJson = JSON.toJSONString(result);
    return resultJson;
  }

  @RequestMapping(value = "/homePage/put", method = RequestMethod.PUT,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String testPut(@RequestBody ProductExecution productExecution) {
    System.out.println("���и��£����ظ��½��");
    System.out.println(JSON.toJSONString(productExecution));
    return JSON.toJSONString(productExecution);
  }

  @RequestMapping(value = "/homePage/put", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String testDelete(@RequestBody ProductExecution productExecution) {
    System.out.println("ִ��ɾ��������ɾ�����");
    System.out.println(JSON.toJSONString(productExecution));
    return JSON.toJSONString(productExecution);
  }

  @RequestMapping(value = "/homePage/put", method = RequestMethod.PATCH,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String testPatch(@RequestBody ProductExecution productExecution) {
    System.out.println("ִ�в��ָ��£�����ɾ�����");
    System.out.println(JSON.toJSONString(productExecution));
    return JSON.toJSONString(productExecution);
  }

  @RequestMapping(value = "/homePage/put", method = RequestMethod.GET)
  private String testGet() {
    return "/home/homePage";
  }
}
