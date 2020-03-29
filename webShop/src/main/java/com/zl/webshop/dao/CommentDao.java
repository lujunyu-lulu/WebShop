package com.zl.webshop.dao;
/**
 * 
 * <p>
 * Title: CommentDao
 * </p>
 * <p>
 * Description:���۱�Dao
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��3��29��
 *         </p>
 */

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.zl.webshop.entity.Comment;

public interface CommentDao {
  /**
   * 
   * <p>
   * Title: queryAll
   * </p>
   * <p>
   * Description: ��ѯ��������
   * </p>
   * 
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return �����б�
   */
  List<Comment> queryAll(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByProductId
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ��Ż�ȡ����
   * </p>
   * 
   * @param productId ��Ʒ���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return �����б�
   */
  List<Comment> queryByProductId(@Param("productId") long productId, @Param("offset") int offset,
      @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryByUserName
   * </p>
   * <p>
   * Description: �����û����������
   * </p>
   * 
   * @param userName �û���
   * @param offset ��ѯ��ʼλ��
   * @param limit ��ѯ����
   * @return �����б�
   */
  List<Comment> queryByUserName(@Param("userName") String userName, @Param("offset") int offset,
      @Param("limit") int limit);

  /**
   * 
   * <p>
   * Title: queryById
   * </p>
   * <p>
   * Description: ������Ż�ȡ����
   * </p>
   * 
   * @param id �������
   * @return Comment
   */
  Comment queryById(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: addComment
   * </p>
   * <p>
   * Description: ����һ������
   * </p>
   * 
   * @param comment ���۶���
   * @return ���ڵ���1��ʾ�����ɹ�
   */
  int addComment(@Param("comment") Comment comment);

  /**
   * 
   * <p>
   * Title: deleteCommentByProductId
   * </p>
   * <p>
   * Description: ���ݲ�Ʒ���ɾ������
   * </p>
   * 
   * @param productId ��Ʒ���
   * @return ���ڵ���1��ʾɾ���ɹ�
   */
  int deleteCommentByProductId(@Param("productId") long productId);

  /**
   * 
   * <p>
   * Title: deleteComment
   * </p>
   * <p>
   * Description: ɾ������
   * </p>
   * 
   * @param id �������
   * @return ���ڵ���1��ʾɾ���ɹ�
   */
  int deleteComment(@Param("id") long id);

  /**
   * 
   * <p>
   * Title: deleteCommentByUserName
   * </p>
   * <p>
   * Description: �����û���ɾ������
   * </p>
   * 
   * @param userName �û���
   * @return ���ڵ���1��ʾɾ���ɹ�
   */
  int deleteCommentByUserName(@Param("userName") String userName);

  /**
   * 
   * <p>
   * Title: updateComment
   * </p>
   * <p>
   * Description: �������۽�֧�ָ����������ݺ����ۺ�����
   * </p>
   * 
   * @param comment ���۶���
   * @return ���ڵ���1��ʾ���³ɹ�
   */
  int updateComment(@Param("comment") Comment comment);
}
