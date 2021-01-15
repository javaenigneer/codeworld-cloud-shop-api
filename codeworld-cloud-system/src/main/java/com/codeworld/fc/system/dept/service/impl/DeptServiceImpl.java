package com.codeworld.fc.system.dept.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.system.dept.domain.DeptTreeNode;
import com.codeworld.fc.system.dept.domain.TreeBuilder;
import com.codeworld.fc.system.dept.dto.DeptRequestDTO;
import com.codeworld.fc.system.dept.entity.Dept;
import com.codeworld.fc.system.dept.mapper.DeptMapper;
import com.codeworld.fc.system.dept.service.DeptService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName DeptServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    /**
     * 获取部门树
     *
     * @return
     */
    public FCResponse<Object> treeDept() {
        // 获取全部得部门
        List<Dept> depts = this.deptMapper.getAllDept();
        List<DeptTreeNode> deptTreeNodeList = Lists.newArrayList();

        if (!CollectionUtils.isEmpty(depts)){
            depts.forEach(dept -> {
                DeptTreeNode deptTreeNode = new DeptTreeNode();
                BeanUtil.copyProperties(dept,deptTreeNode);
                deptTreeNodeList.add(deptTreeNode);
            });
        }
        List<DeptTreeNode> newDeptTreeNodeList = TreeBuilder.buildDeptTree(deptTreeNodeList);
        newDeptTreeNodeList.stream().sorted(Comparator.comparing(DeptTreeNode::getSortNo)).collect(Collectors.toList());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("deptList",depts);
        jsonObject.put("deptTree",newDeptTreeNodeList);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.dept.DEPT_GET_SUCCESS.getMsg(),jsonObject);
    }

    /**
     * 添加部门
     *
     * @param deptRequestDTO
     * @return
     */
    @Override
    public FCResponse<Void> addDept(DeptRequestDTO deptRequestDTO) {
        try {
            Dept dept = new Dept();
            BeanUtil.copyProperties(deptRequestDTO,dept);
            dept.setId(IDGeneratorUtil.getNextId());
            dept.setCreateTime(new Date());
            dept.setUpdateTime(dept.getCreateTime());
            this.deptMapper.addDept(dept);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.dept.DEPT_ADD_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 修改部门
     *
     * @param deptRequestDTO
     * @return
     */
    @Override
    public FCResponse<Void> updateDept(DeptRequestDTO deptRequestDTO) {
        try {
            Dept dept = new Dept();
            BeanUtil.copyProperties(deptRequestDTO,dept);
            dept.setUpdateTime(new Date());
            this.deptMapper.updateDept(dept);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.dept.DEPT_UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
