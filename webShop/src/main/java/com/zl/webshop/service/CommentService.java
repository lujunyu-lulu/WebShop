/** 
�� * <p>Title: CommentService.java</p> 
�� * <p>Description: </p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
�� * @version 1.0 
*/
package com.zl.webshop.service;

import java.util.List;
import com.zl.webshop.dto.CommentExecution;
import com.zl.webshop.entity.Comment;

/** 
�� * <p>Title: CommentService</p> 
�� * <p>Description: ����ҵ��ӿ�</p> 
�� * @author zyd 
�� * <p>�������ڣ�2020��4��1�� </p>
*/
public interface CommentService {

  List<CommentExecution>getcommentsByProductId(long productId,int offset,int limit);
  Comment addComment(long productId,String content,String userName,int star);
}
