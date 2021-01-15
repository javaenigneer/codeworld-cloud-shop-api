package com.codeworld.fc.upload.controller;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.upload.service.UploadService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName UploadController
 * Description 图片文件上传接口
 * Author Lenovo
 * Date 2020/11/28
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-upload")
public class UploadController {

    @Autowired(required = false)
    private UploadService uploadService;

    @PostMapping("upload-image")
    @ApiOperation("上传图片")
    public FCResponse<String> uploadImage(@RequestParam("file")MultipartFile file){
        return this.uploadService.uploadImage(file);
    }
}
