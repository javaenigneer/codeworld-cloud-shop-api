package com.codeworld.fc.upload.service;

import com.codeworld.fc.common.response.FCResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 上传图片
     * @param file
     * @return
     */
    FCResponse<String> uploadImage(MultipartFile file);
}
