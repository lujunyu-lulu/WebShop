/** 
�� * <p>Title: AdminCommentService.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��30�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.service;

import java.util.List;
import com.zl.webshop.dto.CommentExecution;
import com.zl.webshop.entity.Comment;
import com.zl.webshop.enums.CommentAuditEnum;

/** 
�� * <p>Title: AdminCommentService</p> 
�� * <p>Description: ����Ա����ҵ��ӿ�</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��3��30�� </p>
*/
public interface AdminCommentService {
  
  /**
   * 
  *<p>Title: getComments</p> 
  *<p>Description: </p> 
  �� * @param offset ��ѯ��ʼλ��
  �� * @param limit ��ѯ����
  �� * @return �����б�
   */
  List<CommentExecution>getComments(int offset,int limit);
  /**
   * 
  *<p>Title: deleteComment</p> 
  *<p>Description: ɾ��һ������</p> 
  �� * @param comment ����
  �� * @return ���µ����۱�����
   */
  int deleteComment(Comment comment);
  /**
   * 
  *<p>Title: updateCommentState</p> 
  *<p>Description: ��������״̬</p> 
  �� * @param id ����id
  �� * @param auditEnum ����״̬
  �� * @return ���ظ��º������
   */
  CommentExecution updateCommentState(long id,CommentAuditEnum auditEnum);
}
