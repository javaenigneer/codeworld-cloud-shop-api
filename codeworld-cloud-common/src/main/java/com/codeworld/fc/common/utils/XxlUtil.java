package com.codeworld.fc.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codeworld.fc.common.domain.XxlJobInfo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName XxlUtil
 * Description Xxl任务调度工具类
 * Author Lenovo
 * Date 2021/1/14
 * Version 1.0
**/
@Component
@Slf4j
public class XxlUtil {

    /**
     * 地址
     */
    private final String adminAddress = "http://localhost:9999/xxl-job-admin";

    @Autowired(required = false)
    private final RestTemplate restTemplate = new RestTemplate();

    // 请求Url
    private static final String ADD_INFO_URL = "/jobinfo/addJob";
    private static final String UPDATE_INFO_URL = "/jobinfo/updateJob";
    private static final String REMOVE_INFO_URL = "/jobinfo/removeJob";
    private static final String GET_GROUP_ID = "/jobgroup/loadByAppName";


    /**
     * 添加任务
     * @param xxlJobInfo
     * @param appName
     * @return
     */
    public String addJob(XxlJobInfo xxlJobInfo, String appName){
        Map<String, Object> params = new HashMap<>();
        params.put("appName",appName);
        String json = JsonUtils.serialize(params);
        String result = doPost(adminAddress + GET_GROUP_ID, json);
        JSONObject jsonObject = JSON.parseObject(result);
        Map<String, Object> map  = (Map<String, Object>) jsonObject.get("content");
        Integer groupId = (Integer) map.get("id");
        xxlJobInfo.setJobGroup(groupId);
        String json2 = JSONObject.toJSONString(xxlJobInfo);
        return doPost(adminAddress + ADD_INFO_URL, json2);
    }

    /**
     * 远程调用
     * @param url
     * @param json
     */
    private String doPost(String url, String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(json,headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, entity, String.class);
        return responseEntity.getBody();
    }

}
