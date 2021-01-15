package com.codeworld.fc.common.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Lenovo
 * 图片上传到腾讯云
 */
public class TencentCOS {


    /**
     * 图片访问地址
     */
    private static final String IMAGE_URL = "https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com";

    /**
     * 存储桶的名称
     */
    private static final String BUCKET_NAME = "codeworld-cloud-shop-1300450814";

    /**
     * 密钥ID
     */
    private static final String SECRET_ID = "AKID0oNccNSBF4dx2sqntkLgmeIhsoVxQ7vU";

    /**
     * 密钥Key
     */
    private static final String SECRET_KEY = "TgeMlvpVxBCxTjjU0HI3Zppa5LMAj26u";

    // 1 初始化用户身份信息(secretId, secretKey，可在腾讯云后台中的API密钥管理中查看！
    private static COSCredentials credentials = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);

    // 2 设置bucket的区域, COS地域的简称请参照
    private static ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));


    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    public static Map<String, String> uploadImage(File file) {


        Map<String, String> map = new HashMap<>();

        // 生成Cos客户端
        COSClient cosClient = new COSClient(credentials, clientConfig);

        SimpleDateFormat dateFormat = new SimpleDateFormat("/yyyy/MM/dd");

        String fileName = "";

        try {

            fileName = file.getName();

            String substring = fileName.substring(fileName.lastIndexOf("."));

            Random random = new Random();

            // 指定要上传到COS上的路径
            fileName = dateFormat.format(new Date()) + "/" + random.nextInt(10000) + System.currentTimeMillis() + substring;

            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, fileName, file);

            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        } finally {

            cosClient.shutdown();
        }

        map.put("key", fileName);

        map.put("url", IMAGE_URL + fileName);

        return map;
    }


    /**
     * 从腾讯云上全部查询数据
     *
     * @param bucketName
     * @return
     */
    public static ObjectListing listObjects(String bucketName) {

        // 生成Cos客户端
        COSClient cosClient = new COSClient(credentials, clientConfig);

        // 获取bucket下成员（设delimiter）
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();

        listObjectsRequest.setBucketName(bucketName);

        // 设置list的prefix，表示list出来的文件key都是以这个prefix开始
        listObjectsRequest.setPrefix("/");

        listObjectsRequest.setDelimiter("");

        listObjectsRequest.setMaxKeys(100);

        ObjectListing objectListing = cosClient.listObjects(listObjectsRequest);

        String nextMarker = objectListing.getNextMarker();

        boolean truncated = objectListing.isTruncated();

        List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();

        return objectListing;
    }

    /**
     * 删除图片，通过Key
     *
     * @param bucketName
     * @param key
     * @return
     */
    public static boolean delete(String bucketName, String key) {

        boolean flag = false;

        try {

            // 执行删除
            // 生成Cos客户端
            COSClient cosClient = new COSClient(credentials, clientConfig);

            cosClient.deleteObject(BUCKET_NAME, key);

            return flag = true;

        } catch (Exception e) {

            e.printStackTrace();

            return flag;
        }
    }
}
