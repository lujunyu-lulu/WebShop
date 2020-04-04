package com.zl.webshop.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * <p>
 * Title: FileService
 * </p>
 * <p>
 * Description: �ϴ��ļ��ӿ�
 * </p>
 * 
 * @author zyd
 *         <p>
 *         �������ڣ�2020��4��3��
 *         </p>
 */
public interface FileService {
  /**
   * 
   * <p>
   * Title: upLoadFile
   * </p>
   * <p>
   * Description: �ϴ��ļ��������ļ�
   * </p>
   * 
   * @param upload �ļ�
   * @return �����ϴ��ɹ����ļ���
   * @throws Exception
   */
  String upLoadFile(MultipartFile upload) throws Exception;
  /**
   * 
  *<p>Title: deleteFile</p> 
  *<p>Description: ɾ���ļ�</p> 
  �� * @param fileName �ļ��� ������׺
   */
  boolean deleteFile(String fileName);
}
