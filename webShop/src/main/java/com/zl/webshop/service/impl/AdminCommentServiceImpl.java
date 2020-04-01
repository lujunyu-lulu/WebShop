package com.zl.webshop.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zl.webshop.dao.CommentDao;
import com.zl.webshop.dto.CommentExecution;
import com.zl.webshop.entity.Comment;
import com.zl.webshop.enums.CommentAuditEnum;
import com.zl.webshop.enums.CommentStarEnum;
import com.zl.webshop.service.AdminCommentService;

/**
 * 
 * <p>
 * Title: AdminCommentServiceImpl
 * </p>
 * <p>
 * Description: ��������ҵ��ӿ�ʵ��
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��4��1��
 * </p>
 */
@Service
public class AdminCommentServiceImpl implements AdminCommentService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private CommentDao commentDao;

  @Override
  public List<CommentExecution> getComments(int offset, int limit) {
    List<Comment> comments = commentDao.queryAll(offset, limit);
    List<CommentExecution> commentExecutions = new ArrayList<CommentExecution>();
    comments.stream().forEach(x -> commentExecutions.add(new CommentExecution(x,
        CommentAuditEnum.stateOf(x.getAudit()), CommentStarEnum.stateOf(x.getStar()))));
    return commentExecutions;
  }

  @Override
  public int deleteComment(Comment comment) {
    int count = 0;
    try {
      commentDao.deleteComment(comment.getId());
      count = commentDao.count();
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
    return count;
  }

  @Override
  public CommentExecution updateCommentState(long id, CommentAuditEnum auditEnum) {
    CommentExecution commentExecution = null;
    try {
      // ����
      Comment comment = new Comment();
      comment.setId(id);
      comment.setAudit(auditEnum.getState());
      commentDao.updateComment(comment);
      // ���ؽ��
      comment = commentDao.queryById(id);
      commentExecution = new CommentExecution(comment, CommentAuditEnum.stateOf(comment.getAudit()),
          CommentStarEnum.stateOf(comment.getStar()));
    } catch (Exception e) {
      logger.error(e.getMessage());
      throw new RuntimeException(e.getMessage());
    }

    return commentExecution;
  }

}
