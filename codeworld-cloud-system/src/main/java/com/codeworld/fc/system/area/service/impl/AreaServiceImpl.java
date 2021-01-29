package com.codeworld.fc.system.area.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.system.area.domain.AreaTreeNode;
import com.codeworld.fc.system.area.domain.TreeBuilder;
import com.codeworld.fc.system.area.entity.Area;
import com.codeworld.fc.system.area.mapper.AreaMapper;
import com.codeworld.fc.system.area.service.AreaService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName AreaServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/1/29
 * Version 1.0
**/
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired(required = false)
    private AreaMapper areaMapper;

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    @Value("${codeworld.redis.area.tree}")
    private String areaTree;

    @Value("${codeworld.redis.area.list}")
    private String areaList;
    /**
     * 获取区域树
     *
     * @return
     */
    @Override
    public FCResponse<Object> treeArea() {
        // 从redis中获取数据
        if (this.stringRedisTemplate.hasKey(areaTree) && this.stringRedisTemplate.hasKey(areaList)){
            String areaTreeJson = this.stringRedisTemplate.opsForValue().get(areaTree);
            String areaListJson = this.stringRedisTemplate.opsForValue().get(areaList);
            List<AreaTreeNode> newAreaTreeNodeList = JsonUtils.parseList(areaTreeJson, AreaTreeNode.class);
            List<Area> areas = JsonUtils.parseList(areaListJson, Area.class);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("areaList", areas);
            jsonObject.put("areaTree", newAreaTreeNodeList);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.area.AREA_GET_SUCCESS.getMsg(), jsonObject);
        }
        // 获取全部分类
        List<Area> areas = this.areaMapper.getAllArea();
        final List<AreaTreeNode> areaTreeNodes = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(areas)){
            areas.forEach(area -> {
                AreaTreeNode areaTreeNode = new AreaTreeNode();
                BeanUtils.copyProperties(area, areaTreeNode);
                areaTreeNodes.add(areaTreeNode);
            });
        }
        List<AreaTreeNode> newAreaTreeNodeList = TreeBuilder.buildAreaTree(areaTreeNodes);
        newAreaTreeNodeList.stream().sorted(Comparator.comparing(AreaTreeNode::getSortNo)).collect(Collectors.toList());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaList", areas);
        jsonObject.put("areaTree", newAreaTreeNodeList);

        // 保存到redis中
        String areaTreeJson = JsonUtils.serialize(newAreaTreeNodeList);
        String areaListJson = JsonUtils.serialize(areas);
        try {
            assert areaTreeJson != null;
            this.stringRedisTemplate.opsForValue().set(areaTree,areaTreeJson);
            assert areaListJson != null;
            this.stringRedisTemplate.opsForValue().set(areaList,areaListJson);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.area.AREA_GET_SUCCESS.getMsg(), jsonObject);
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
