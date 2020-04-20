package com.zl.webshop.service.impl;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.zl.webshop.service.FileService;
import cn.hutool.core.util.IdUtil;

/**
 * 
 * <p>
 * Title: FileServiceImpl
 * </p>
 * <p>
 * Description: �ϴ��ļ�ҵ��ʵ��
 * </p>
 * @author zyd
 * <p>
 * �������ڣ�2020��4��3��
 * </p>
 */
@Service
public class FileServiceImpl implements FileService {
  private Logger logger = LoggerFactory.getLogger(getClass());
private static final String PATH = "D:\\upload\\";
  @Override
  public String upLoadFile(MultipartFile upload) throws Exception {
    String newFileName = null;
    if (upload != null && upload.getOriginalFilename() != null
        && upload.getOriginalFilename().length() > 0) {
      // ͼƬ�ϴ�����·��
      String imgPath = PATH;
      // ��ȡͼƬԭʼ����
      String originalFilename = upload.getOriginalFilename();

      // �����µ�ͼƬ����
      // Ϊ�˱����ļ�����ͻ��ʹ��java��UUID��������ַ����ټ���ԭ��ͼƬ��׺�������µ�����
      newFileName =
          IdUtil.simpleUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
      // ��ͼƬ
      File newFile = new File(imgPath + newFileName);

      // ���ڴ��е�����д�����
      try {
        upload.transferTo(newFile);
      } catch (Exception e) {
        logger.error(e.getMessage());
        throw e;
      }

    }
    // �����ѱ�����ļ���
    return newFileName;
  }

  @Override
  public boolean deleteFile(String fileName) {
    File file=new File(PATH+fileName);
    boolean flag=false;
    if(file.isFile()) {
      flag=file.delete();
    }
    return flag;
  }

}
