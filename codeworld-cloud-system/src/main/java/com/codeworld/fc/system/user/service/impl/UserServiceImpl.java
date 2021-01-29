package com.codeworld.fc.system.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;

import com.codeworld.fc.system.role.mapper.RoleMapper;
import com.codeworld.fc.system.user.dto.UserDeptResponse;
import com.codeworld.fc.system.user.dto.UserResponse;
import com.codeworld.fc.system.user.entity.User;
import com.codeworld.fc.system.user.entity.UserDept;
import com.codeworld.fc.system.user.entity.UserRole;
import com.codeworld.fc.system.user.mapper.UserDeptMapper;
import com.codeworld.fc.system.user.mapper.UserMapper;
import com.codeworld.fc.system.user.request.UserRegisterRequest;
import com.codeworld.fc.system.user.request.UserSearchRequest;
import com.codeworld.fc.system.user.request.UserUpdateRequest;
import com.codeworld.fc.system.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName UserServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private UserDeptMapper userDeptMapper;
    @Autowired(required = false)
    private RoleMapper roleMapper;

    /**
     * 根据用户名获取用户
     *
     * @param username
     * @return
     */
    public FCResponse<User> getUserByName(String username) {
        if (StringUtils.isBlank(username)) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.user.USER_NAME_ERROR.getMsg());
        }
        User user = this.userMapper.getUserByName(username);
        if (ObjectUtils.isEmpty(user)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.user.USER_NO_EXIST.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_GET_SUCCESS.getMsg(), user);
    }

    /**
     * 分页获取全部用户
     *
     * @param userSearchRequest
     * @return
     */
    public FCResponse<DataResponse<List<UserResponse>>> getAllUser(UserSearchRequest userSearchRequest) {
        PageHelper.startPage(userSearchRequest.getPage(), userSearchRequest.getLimit());
        List<UserResponse> users = this.userMapper.getAllUser(userSearchRequest);
        if (CollectionUtils.isEmpty(users)) {
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), "数据为空", DataResponse.dataResponse(users, 0L));
        }
        PageInfo<UserResponse> pageInfo = new PageInfo<>(users);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), "查询成功", DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 修改用户状态
     *
     * @param userId
     * @param userStatus
     * @return
     */
    @Override
    public FCResponse<Void> updateUserStatus(Long userId, Integer userStatus) {
        if (ObjectUtils.isEmpty(userId) || userId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), "参数错误");
        }
        try {
            User user = new User();
            user.setUserId(userId);
            user.setUserStatus(userStatus);
            this.userMapper.updateUserStatus(user);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_STATUS_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public FCResponse<Void> deleteUser(Long userId) {
        if (ObjectUtils.isEmpty(userId) || userId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.user.USER_ID_ERROR.getMsg());
        }
        try {
            // 先删除用户关联的角色
            this.roleMapper.deleteUserRoleByUserId(userId);
            // 删除用户下的部门信息
            this.userDeptMapper.deleteUserDeptByUserId(userId);
            // 删除用户
            this.userMapper.deleteUser(userId);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_DELETE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 添加用户
     *
     * @param userRegisterRequest
     * @return
     */
    @Override
    public FCResponse<Void> addUser(UserRegisterRequest userRegisterRequest) {
        try {

            // 根据用户名获取用户
            User existUser = this.userMapper.getUserByName(userRegisterRequest.getUserName());
            if (existUser != null) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEXIST.getCode(), HttpMsg.user.USER_EXIST.getMsg());
            }

            User user = new User();
            BeanUtil.copyProperties(userRegisterRequest, user);
            user.setUserId(IDGeneratorUtil.getNextId());
            user.setCreateTime(new Date());
            user.setUpdateTime(user.getCreateTime());
            this.userMapper.addUser(user);

            // 设置用户类型
            UserRole userRole = new UserRole();
            userRole.setUserRoleId(IDGeneratorUtil.getNextId());
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(userRegisterRequest.getRoleType());
            userRole.setCreateTime(new Date());
            userRole.setUpdateTime(userRole.getCreateTime());
            // 远程调用角色模块添加用户角色
            this.roleMapper.addUserRole(userRole);

            // 添加用户部门
            UserDept userDept = new UserDept();
            userDept.setUserDeptId(IDGeneratorUtil.getNextId());
            userDept.setUserId(user.getUserId());
            userDept.setDeptId(userRegisterRequest.getDeptIds());
            userDept.setCreateTime(new Date());
            userDept.setUpdateTime(userDept.getCreateTime());
            this.userDeptMapper.addUserDept(userDept);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_ADD_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 修改用户
     *
     * @param userUpdateRequest
     * @return
     */
    @Override
    public FCResponse<Void> updateUser(UserUpdateRequest userUpdateRequest) {
        try {
            User user = new User();
            user.setUserId(userUpdateRequest.getUserId());
            user.setUserName(userUpdateRequest.getUserName());
            user.setUserEmail(userUpdateRequest.getUserEmail());
            user.setUserPhone(userUpdateRequest.getUserPhone());
            user.setUpdateTime(new Date());
            user.setUserStatus(userUpdateRequest.getUserStatus());
            user.setAreaId(userUpdateRequest.getAreaId());
            user.setAreaName(userUpdateRequest.getAreaName());
            this.userMapper.updateUser(user);
            // 更新用户角色
            // 先删除角色id
            this.roleMapper.deleteUserRoleByUserId(user.getUserId());
            // 添加新的角色
            UserRole userRole = new UserRole();
            userRole.setUserRoleId(IDGeneratorUtil.getNextId());
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(userUpdateRequest.getRoleType());
            userRole.setCreateTime(new Date());
            userRole.setUpdateTime(userRole.getCreateTime());
            this.roleMapper.addUserRole(userRole);
            // 更新部门
            // 先删除部门信息
            this.userDeptMapper.deleteUserDeptByUserId(user.getUserId());
            // 添加信息部门信息
            UserDept userDept = new UserDept();
            userDept.setUserDeptId(IDGeneratorUtil.getNextId());
            userDept.setUserId(user.getUserId());
            userDept.setDeptId(userUpdateRequest.getDeptIds());
            userDept.setCreateTime(new Date());
            userDept.setUpdateTime(userDept.getCreateTime());
            this.userDeptMapper.addUserDept(userDept);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 根据部门Id获取用户信息
     *
     * @param deptId
     * @return
     */
    @Override
    public FCResponse<List<UserDeptResponse>> getUserByDeptId(Long deptId) {
        if (ObjectUtils.isEmpty(deptId) || deptId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.dept.DEPT_PARAM_ERROR.getMsg(), null);
        }
        List<UserDeptResponse> userDepts = this.userMapper.getUserByDeptId(deptId);
        if (CollectionUtils.isEmpty(userDepts)) {
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USE_DATA_EMPTY.getMsg(), userDepts);
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_GET_SUCCESS.getMsg(), userDepts);
    }
}
