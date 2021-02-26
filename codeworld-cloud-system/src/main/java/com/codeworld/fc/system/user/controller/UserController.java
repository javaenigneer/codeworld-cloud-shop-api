package com.codeworld.fc.system.user.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.system.user.dto.UserDeptResponse;
import com.codeworld.fc.system.user.dto.UserResponse;
import com.codeworld.fc.system.user.entity.User;
import com.codeworld.fc.system.user.entity.UserDept;
import com.codeworld.fc.system.user.request.UserRegisterRequest;
import com.codeworld.fc.system.user.request.UserSearchRequest;
import com.codeworld.fc.system.user.request.UserUpdateRequest;
import com.codeworld.fc.system.user.service.UserDeptService;
import com.codeworld.fc.system.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.channels.FileChannel;
import java.security.PublicKey;
import java.util.List;

/**
 * ClassName UserController
 * Description 用户管理接口
 * Author Lenovo
 * Date 2020/11/29
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-system/user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private UserDeptService userDeptService;

    @GetMapping("get-user-name")
    @ApiOperation("根据用户名获取用户")
    @PassToken
    public FCResponse<User> getUserByName(@RequestParam("username") String username){
        return this.userService.getUserByName(username);
    }

    @PostMapping("get-all-user")
    @ApiOperation("获取全部用户")
    public FCResponse<DataResponse<List<UserResponse>>> getAllUser(@RequestBody UserSearchRequest userSearchRequest) {
        return this.userService.getAllUser(userSearchRequest);
    }

    @PostMapping("update-user-status")
    @ApiOperation("修改用户状态")
    public FCResponse<Void> updateUserStatus(@RequestParam("userId") Long userId,
                                             @RequestParam("status") Integer userStatus) {
        return this.userService.updateUserStatus(userId, userStatus);
    }

    @PostMapping("delete-user")
    @ApiOperation("删除用户")
    public FCResponse<Void> deleteUser(@RequestParam("userId") Long userId) {
        return this.userService.deleteUser(userId);
    }

    @PostMapping("add-user")
    @ApiOperation("添加用户")
    public FCResponse<Void> addUser(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        return this.userService.addUser(userRegisterRequest);
    }

    @GetMapping("get-dept-user-id")
    @ApiOperation("根据用户Id获取部门Id")
    public FCResponse<List<UserDept>> getDeptIdByUserId(@RequestParam("userId") Long userId){
        return this.userDeptService.getDeptIdByUserId(userId);
    }

    @PostMapping("update-user")
    @ApiOperation("修改用户")
    public FCResponse<Void> updateUser(@RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        return this.userService.updateUser(userUpdateRequest);
    }

    @PostMapping("get-user-dept-id")
    @ApiOperation("根据部门Id获取用户信息")
    public FCResponse<List<UserDeptResponse>> getUserByDeptId(@RequestParam("deptId") Long deptId){
        return this.userService.getUserByDeptId(deptId);
    }

    @GetMapping("get-user-role-to-merchant")
    @ApiOperation("获取全部的商户管理员")
    public FCResponse<List<User>> getUserRoleToMerchant(@RequestParam("userName") String userName){
        return this.userService.getUserRoleToMerchant(userName);
    }

    @PostMapping("get-user-id")
    @ApiOperation("根据用户id获取用户信息")
    public FCResponse<User> getUserById(@RequestParam("userId") Long userId) {
        return this.userService.getUserById(userId);
    }

    @GetMapping("get-area-merchant-user")
    @ApiOperation("获取区域的商户管理员")
    public FCResponse<List<User>> getAreaMerchantUser(@RequestParam("userName") String userName){
        return this.userService.getAreaMerchantUser(userName);
    }

}
