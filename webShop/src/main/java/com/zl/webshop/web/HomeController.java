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
 *         �������ڣ�2020��3��25��
 *         </p>
 * @version 1.0
 */
package com.zl.webshop.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.dto.Result;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.ProductCategory;
import com.zl.webshop.exception.NoCategoryException;
import com.zl.webshop.exception.NoProductException;
import com.zl.webshop.service.ProductService;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * Title: HomeController
 * </p>
 * <p>
 * Description: ��ҳ������ҳ������ҳ�Ŀ�����
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��25��
 *         </p>
 */
@Controller
public class HomeController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  /**
   * ��ҳ���չʾ��
   */
  public static final int CATEGORIERCOUNT = 39;
  /**
   * ��ҳ��Ʒ�����Ƽ���
   */
  public static final int ROLLPRODUCTSCOUNT = 7;
  /**
   * �����Ʒչʾ�����
   */
  public static final int RANDOMSHOWPRODUCTSGROUPCOUNT = 8;
  /**
   * �����Ʒչʾ��
   */
  public static final int RANDOMSHOWPRODUCTSCOUNT = 4;
  /**
   * Ĭ�ϲ�ѯ��ʼλ��
   */
  public static final int DEFAULTOFFSET = 0;
  /**
   * ����ҳĬ�ϲ�ѯ����
   */
  public static final int DEFAULTSEARCHLIMIT = 40;
  @Autowired
  private ProductService productService;

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  private String getHomePage(Model model) {
    // ��ȡ��Ʒ���
    List<ProductCategory> categories =
        productService.getCategories().stream().limit(CATEGORIERCOUNT).collect(Collectors.toList());
    // ��ȡ��ҳ�����Լ��Ƽ�
    List<Product> rollProducts = null;
    try {
      rollProducts = productService.getProductsRandom(ROLLPRODUCTSCOUNT).getProductList();
    } catch (Exception e) {
      logger.error(e.getMessage());
      // ʧ�ܷ��ؿ�����
      rollProducts = new ArrayList<Product>();
    }
    ProductExecution productExecution = null;
    // ��ȡ���չʾ��Ʒ
    List<ProductExecution> randomProducts = new ArrayList<ProductExecution>();
    // ���8������ �ٴӸ������������������4����Ʒ
    for (ProductCategory category : RandomUtil.randomEles(categories,
        RANDOMSHOWPRODUCTSGROUPCOUNT)) {
      try {
        productExecution =
            productService.getProductsRandom(category.getId(), RANDOMSHOWPRODUCTSCOUNT);
        randomProducts.add(productExecution);
      } catch (NoProductException e) {
        // ��ȡ�����������Ʒʧ���򲻴����Ʒ
        logger.error(e.getMessage());
        continue;
      } catch (Exception e) {
        // ��ȡ�����������Ʒʧ���򲻴����Ʒ
        logger.error(e.getMessage());
        continue;
      }
    }
    // ����model
    model.addAttribute("categories", JSON.toJSONString(categories));
    model.addAttribute("rollProducts", JSON.toJSONString(rollProducts));
    model.addAttribute("randomProducts", JSON.toJSONString(randomProducts));

    // ǰ����ҳ
    return "";
  }

  /**
   * 
   * <p>
   * Title: getSearch
   * </p>
   * <p>
   * Description: ǰ������ҳ
   * </p>
   * 
   * @param searchText �����ؼ���
   * @param model ����������Ĳ�Ʒ����
   * @return ǰ������ҳ��Я����Ʒ����
   */
  @RequestMapping(value = "/search", method = RequestMethod.GET)
  private String getSearch(@RequestParam("searchText") String searchText, Model model) {
    if (StrUtil.isEmpty(searchText)) {
      return "redirect:home";
    }
    ProductExecution productExecution = null;
    try {
      productExecution = productService.searchByText(searchText, DEFAULTOFFSET, DEFAULTSEARCHLIMIT);
    } catch (NoProductException e) {
      productExecution = new ProductExecution();
      productExecution.setProductMaxCount(0);
      productExecution.setProductList(new ArrayList<Product>());
    } catch (Exception e) {
      logger.error(e.getMessage());
      productExecution = new ProductExecution();
      productExecution.setProductMaxCount(0);
      productExecution.setProductList(new ArrayList<Product>());
    }
    // װ������
    model.addAttribute("searchResult", JSON.toJSONString(productExecution));
    // ǰ������ҳ
    return "";
  }

  /**
   * 
   * <p>
   * Title: searchProduct
   * </p>
   * <p>
   * Description: Ajax json
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @param searchText �����ؼ���
   * @return Result ��ѯ��� ���汣����һ�� ProductExecution(productMaxCount,productList)
   */
  @RequestMapping(value = "/search/{searchText}/{offset}/{limit}", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String searchProduct(@PathVariable(value = "offset") int offset,
      @PathVariable(value = "limit") int limit, @PathVariable("searchText") String searchText) {
    ProductExecution productExecution = null;
    Result<ProductExecution> result = null;
    try {
      productExecution = productService.searchByText(searchText, offset, limit);
    } catch (NoProductException e) {
      productExecution = new ProductExecution();
      productExecution.setProductMaxCount(0);
      productExecution.setProductList(new ArrayList<Product>());
    } catch (Exception e) {
      logger.error(e.getMessage());
      productExecution = new ProductExecution();
      productExecution.setProductMaxCount(0);
      productExecution.setProductList(new ArrayList<Product>());
    }
    result = new Result<ProductExecution>(true, productExecution);
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: getProductPage
   * </p>
   * <p>
   * Description: ǰ����Ʒ����ҳ
   * </p>
   * 
   * @param model �����Ʒ���� "product"  ProductExecution(categoryId,categoryName,product)
   * @param productId ��Ʒ���
   * @return ǰ����Ʒ����ҳ
   */
  @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
  private String getProductPage(Model model, @PathVariable("productId") long productId) {
    ProductExecution productExecution = null;
    try {
      productExecution = productService.getProduct(productId, null);
    } catch (NoProductException e) {
      throw e;
    } catch (NoCategoryException e) {
      throw e;
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw e;
    }
    // ��װ����
    logger.debug(productExecution.toString());
    model.addAttribute("product", JSON.toJSONString(productExecution));
    // ǰ����Ʒ����ҳ
    return "";
  }
}
