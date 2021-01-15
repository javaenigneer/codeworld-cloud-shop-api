package com.codeworld.fc.upload.service.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.TencentCOS;
import com.codeworld.fc.upload.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * ClassName UploadServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/28
 * Version 1.0
**/
@Service
public class UploadServiceImpl implements UploadService {


    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    public FCResponse<String> uploadImage(MultipartFile file) {
        //获取文件的名称
        String fileName = file.getOriginalFilename();
        //判断有无后缀
        if (fileName.lastIndexOf(".") < 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.image.IMAGE_FORMAT_ERROR.getMsg());
        }
        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        //如果不是图片
        if (!prefix.equalsIgnoreCase(".jpg") && !prefix.equalsIgnoreCase(".jpeg") && !prefix.equalsIgnoreCase(".svg") && !prefix.equalsIgnoreCase(".gif") && !prefix.equalsIgnoreCase(".png")) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.image.IMAGE_FORMAT_ERROR.getMsg());
        }
        try {
            //使用uuid作为文件名，防止生成的临时文件重复
            final File excelFile = File.createTempFile("imagesFile-" + System.currentTimeMillis(), prefix);
            //将Multifile转换成File
            file.transferTo(excelFile);
            // 调用上传工具类
            Map<String, String> map = TencentCOS.uploadImage(excelFile);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.image.IMAGE_UPLOAD_SUCCESS.getMsg(), map.get("url"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
