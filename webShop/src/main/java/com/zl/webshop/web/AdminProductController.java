/**
 * <p>
 * Title: AdminProductController.java
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

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
import com.zl.webshop.dto.ProductExecution;
import com.zl.webshop.dto.Result;
import com.zl.webshop.entity.Product;
import com.zl.webshop.entity.ProductImage;
import com.zl.webshop.service.AdminProductService;
import com.zl.webshop.service.FileService;

/**
 * <p>
 * Title: AdminProductController
 * </p>
 * <p>
 * Description:��̨�����Ʒ������ �����Ʒ����ɾ�Ĳ��¼�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��2��
 *         </p>
 */
@Controller
@RequestMapping(value = "/admin/products")
public class AdminProductController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private AdminProductService adminProductService;
  @Autowired
  private FileService fileService;


  /**
   * 
   * <p>
   * Title: getProducts
   * </p>
   * <p>
   * Description: ��ȡ��Ʒ
   * </p>
   * 
   * @param searchText �����ؼ��� ����null
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ѯ���
   */
  @RequestMapping(value = "", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String getProducts(
      @RequestParam(value = "searchText", required = false) String searchText,
      @RequestParam("offset") int offset, @RequestParam("limit") int limit) {
    Result<List<ProductExecution>> result = null;
    try {
      result = new Result<List<ProductExecution>>(true,
          adminProductService.getProducts(searchText, offset, limit));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: deleteProducts
   * </p>
   * <p>
   * Description: ɾ��һ����Ʒ
   * </p>
   * 
   * @param product ��Ʒ
   * @return ɾ���ɹ��������²�Ʒ��
   */
  @RequestMapping(value = "", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteProducts(@RequestBody Product product) {
    Result<ProductExecution> result = null;
    try {
      result = new Result<ProductExecution>(true, adminProductService.deleteProduct(product));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: addProducts
   * </p>
   * <p>
   * Description: �����Ʒ
   * </p>
   * 
   * @param product ��Ʒ�����벻Ҫ��ͼƬ��img
   * @param imageFile ��Ʒͼ
   * @return ��ӽ��
   */
  @RequestMapping(value = "", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String addProducts(Product product,
      
      @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
    Result<ProductExecution> result = null;
    try {
      // ��ֹͼƬ�����ͻ
      product.setImage(null);
      if (imageFile != null) {
        // Ԥ�����ͼƬ
        product.setImage(fileService.upLoadFile(imageFile));
      }
      result =
          new Result<ProductExecution>(true, adminProductService.addProduct(product));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
      // �����쳣ɾ��Ԥ����Ӻõ�ͼƬ
      if (product.getImage() != null) {
        fileService.deleteFile(product.getImage());
      }
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: updateProducts
   * </p>
   * <p>
   * Description: ������Ʒ
   * </p>
   * 
   * @param product ��Ʒ�����벻Ҫ��ͼƬ��img
   * @param otherImagesFiles ��Ʒ������ͼƬ
   * @param imageFile ��Ʒͼ
   * @return ���½��
   */
  @RequestMapping(value = "/{productId}", method = RequestMethod.POST,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String updateProducts(Product product,
      @RequestParam(value = "otherImages", required = false) MultipartFile[] otherImagesFiles,
      @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
    Result<ProductExecution> result = null;
    List<ProductImage> otherImages = new ArrayList<ProductImage>();
    ProductImage productImage = null;
    try {
      // ��ֹͼƬ�����ͻ
      product.setImage(null);
      if (otherImagesFiles != null && otherImagesFiles.length > 0) {
        
        for (int i = 0; i < otherImagesFiles.length; i++) {
          // Ԥ�����ͼƬ
          if(otherImagesFiles[i].getOriginalFilename()==null||otherImagesFiles[i].getOriginalFilename().equals("")) {
            continue;
          }
          productImage = new ProductImage();
          productImage.setId(product.getId());
          productImage.setImage(fileService.upLoadFile(otherImagesFiles[i]));
          otherImages.add(productImage);
        }
      }
      if (imageFile != null) {
        // Ԥ�����ͼƬ
        product.setImage(fileService.upLoadFile(imageFile));
      }
      result = new Result<ProductExecution>(true,
          adminProductService.updateProduct(product, otherImages));

    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
      // �����쳣ɾ��Ԥ����Ӻõ�ͼƬ
      if (otherImages.size() > 0) {
        otherImages.stream().forEach(x -> fileService.deleteFile(x.getImage()));
      }
      if (product.getImage() != null) {
        fileService.deleteFile(product.getImage());
      }
    }
    return JSON.toJSONString(result);
  }
}
