package com.codeworld.fc.system.role.mapper;


import com.codeworld.fc.system.menu.entity.RoleMenu;
import com.codeworld.fc.system.role.entity.Role;
import com.codeworld.fc.system.role.vo.RoleSearchVO;
import com.codeworld.fc.system.user.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface RoleMapper {
    /**
     * 根据用户id获取角色
     * @param userId
     * @return
     */
    Role getRoleByUserId(Long userId);

    /**
     * 根据用户Id删除用户角色
     * @param userId
     */
    void deleteUserRoleByUserId(Long userId);

    /**
     * 添加用户角色
     * @param userRole
     */
    void addUserRole(UserRole userRole);

    /**
     * 获取全部角色--无参数
     * @return
     */
    List<Role> getAllRoleNoParam();

    /**
     * 获取全部角色
     * @param roleSearchVO
     * @return
     */
    List<Role> getAllRole(RoleSearchVO roleSearchVO);

    /**
     * 获取角色菜单
     * @param roleId
     * @return
     */
    List<RoleMenu> getRoleMenuByRoleId(Long roleId);

    /**
     * 修改角色
     * @param role
     */
    void updateRole(Role role);

    /**
     * 添加角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 更新角色为默认
     * @param map
     */
    void updateUserRoleByRoleId(Map<String, Object> map);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteRoleByRoleId(Long roleId);
}
