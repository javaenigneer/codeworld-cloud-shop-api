package com.codeworld.fc.system.user.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.system.user.dto.UserDeptResponse;
import com.codeworld.fc.system.user.dto.UserResponse;
import com.codeworld.fc.system.user.entity.User;
import com.codeworld.fc.system.user.request.UserRegisterRequest;
import com.codeworld.fc.system.user.request.UserSearchRequest;
import com.codeworld.fc.system.user.request.UserUpdateRequest;


import java.util.List;

public interface UserService {
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    FCResponse<User> getUserByName(String username);

    /**
     * 分页获取全部用户
     * @param userSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<UserResponse>>> getAllUser(UserSearchRequest userSearchRequest);

    /**
     * 修改用户状态
     * @param userId
     * @param userStatus
     * @return
     */
    FCResponse<Void> updateUserStatus(Long userId, Integer userStatus);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    FCResponse<Void> deleteUser(Long userId);

    /**
     * 添加用户
     * @param userRegisterRequest
     * @return
     */
    FCResponse<Void> addUser(UserRegisterRequest userRegisterRequest);

    /**
     * 修改用户
     * @param userUpdateRequest
     * @return
     */
    FCResponse<Void> updateUser(UserUpdateRequest userUpdateRequest);

    /**
     * 根据部门Id获取用户信息
     * @param deptId
     * @return
     */
    FCResponse<List<UserDeptResponse>> getUserByDeptId(Long deptId);

    /**
     * 获取全部的商户管理员
     * @return
     * @param userName
     */
    FCResponse<List<User>> getUserRoleToMerchant(String userName);

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    FCResponse<User> getUserById(Long userId);

    /**
     * 获取区域商户管理员
     * @return
     * @param userName
     */
    FCResponse<List<User>> getAreaMerchantUser(String userName);
}
