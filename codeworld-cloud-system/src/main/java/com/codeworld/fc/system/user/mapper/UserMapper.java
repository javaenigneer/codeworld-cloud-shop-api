package com.codeworld.fc.system.user.mapper;


import com.codeworld.fc.system.user.dto.UserDeptResponse;
import com.codeworld.fc.system.user.dto.UserResponse;
import com.codeworld.fc.system.user.entity.User;
import com.codeworld.fc.system.user.request.UserSearchRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 分页获取用户列表
     * @param userSearchRequest
     * @return
     */
    List<UserResponse> getAllUser(UserSearchRequest userSearchRequest);

    /**
     * 修改角色状态
     * @param user
     */
    void updateUserStatus(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(Long userId);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据部门Id获取用户信息
     * @param deptId
     * @return
     */
    List<UserDeptResponse> getUserByDeptId(Long deptId);
}
