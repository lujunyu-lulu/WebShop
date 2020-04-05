/**
 * <p>
 * Title: AdminCommentController.java
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.zl.webshop.dto.CommentExecution;
import com.zl.webshop.dto.Result;
import com.zl.webshop.entity.Comment;
import com.zl.webshop.enums.CommentAuditEnum;
import com.zl.webshop.service.AdminCommentService;

/**
 * <p>
 * Title: AdminCommentController
 * </p>
 * <p>
 * Description:
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��4��2��
 * </p>
 */
@Controller
@RequestMapping(value = "/admin/comments")
public class AdminCommentController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private AdminCommentService adminCommentService;

  /**
   * 
   * <p>
   * Title: getOrders
   * </p>
   * <p>
   * Description: ��ȡ�����б�
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return ��ѯ���
   */
  @RequestMapping(value = "", method = RequestMethod.GET,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String getComments(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
    Result<List<CommentExecution>> result = null;
    try {
      result =
          new Result<List<CommentExecution>>(true, adminCommentService.getComments(offset, limit));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: deleteComment
   * </p>
   * <p>
   * Description: ɾ������
   * </p>
   * 
   * @param comment ���۶���
   * @return ɾ�����
   */
  @RequestMapping(value = "", method = RequestMethod.DELETE,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String deleteComment(@RequestBody Comment comment) {
    Result<Integer> result = null;
    try {
      result = new Result<Integer>(true, adminCommentService.deleteComment(comment));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }

  /**
   * 
   * <p>
   * Title: updateCommentAudit
   * </p>
   * <p>
   * Description: ��������״̬
   * </p>
   * 
   * @param id ���
   * @param auditState �������״̬
   * @return ���½��
   */
  @RequestMapping(value = "", method = RequestMethod.PUT,
      produces = {"application/json; charset=utf-8"})
  @ResponseBody
  private String updateCommentAudit(@RequestParam("id") long id,
      @RequestParam("auditState") int auditState) {
    Result<CommentExecution> result = null;
    try {
      result = new Result<CommentExecution>(true,
          adminCommentService.updateCommentState(id, CommentAuditEnum.stateOf(auditState)));
    } catch (Exception e) {
      logger.error(e.getMessage());
      result = new Result<>(false, e.getMessage());
    }
    return JSON.toJSONString(result);
  }
}
