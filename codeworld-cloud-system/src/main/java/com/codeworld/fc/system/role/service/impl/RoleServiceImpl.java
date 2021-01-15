package com.codeworld.fc.system.role.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.system.menu.entity.RoleMenu;
import com.codeworld.fc.system.menu.mapper.MenuMapper;
import com.codeworld.fc.system.role.entity.Role;
import com.codeworld.fc.system.role.mapper.RoleMapper;
import com.codeworld.fc.system.role.service.RoleService;
import com.codeworld.fc.system.role.vo.RoleAddRequest;
import com.codeworld.fc.system.role.vo.RoleMenuRequest;
import com.codeworld.fc.system.role.vo.RoleSearchVO;
import com.codeworld.fc.system.role.vo.RoleUpdateRequest;
import com.codeworld.fc.system.user.entity.UserRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName RoleServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;
    @Autowired(required = false)
    private MenuMapper menuMapper;

    /**
     * 根据用户id获取角色
     *
     * @param userId
     * @return
     */
    public FCResponse<Role> getRoleByUserId(Long userId) {
        if (ObjectUtils.isEmpty(userId) || userId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.role.ROLE_PARAM_ERROR.getMsg());
        }
        Role role = this.roleMapper.getRoleByUserId(userId);
        if (ObjectUtils.isEmpty(role)) {
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_DATA_EMPTY.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_DATA_SUCCESS.getMsg(), role);
    }

    /**
     * 根据用户Id删除用户角色
     *
     * @param userId
     * @return
     */
    public FCResponse<Void> deleteUserRoleByUserId(Long userId) {
        if (ObjectUtils.isEmpty(userId) || userId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.user.USER_ID_ERROR.getMsg());
        }
        try {
            this.roleMapper.deleteUserRoleByUserId(userId);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_DELETE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 添加用户角色
     *
     * @param userRole
     * @return
     */
    public FCResponse<Void> addUserRole(UserRole userRole) {
        try {
            this.roleMapper.addUserRole(userRole);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_ADD_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取全部角色--无参数
     *
     * @return
     */
    public FCResponse<List<Role>> getAllRoleNoParam() {
        List<Role> roles = this.roleMapper.getAllRoleNoParam();
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_DATA_SUCCESS.getMsg(), roles);
    }

    /**
     * 获取全部角色
     *
     * @param roleSearchVO
     * @return
     */
    public FCResponse<DataResponse<List<Role>>> getAllRole(RoleSearchVO roleSearchVO) {
        PageHelper.startPage(roleSearchVO.getPage(), roleSearchVO.getLimit());
        List<Role> roles = this.roleMapper.getAllRole(roleSearchVO);
        if (CollectionUtils.isEmpty(roles)) {
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_DATA_EMPTY.getMsg(), DataResponse.dataResponse(roles, 0L));
        }
        PageInfo<Role> pageInfo = new PageInfo<Role>(roles);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_DATA_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 获取角色菜单
     *
     * @param roleId
     * @return
     */
    public FCResponse<List<RoleMenu>> getRoleMenu(Long roleId) {
        if (ObjectUtils.isEmpty(roleId) || roleId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.role.ROLE_PARAM_ERROR.getMsg());
        }
        try {
            List<RoleMenu> roleMenus = this.roleMapper.getRoleMenuByRoleId(roleId);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_MENU_DATA_SUCCESS.getMsg(), roleMenus);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 修改角色
     *
     * @param roleUpdateRequest
     * @return
     */
    public FCResponse<Void> updateRole(RoleUpdateRequest roleUpdateRequest) {
        try {
            Role role = new Role();
            BeanUtil.copyProperties(roleUpdateRequest, role);
            role.setUpdateTime(new Date());
            this.roleMapper.updateRole(role);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_UPDATE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 设置角色菜单
     *
     * @param roleMenuRequest
     * @return
     */
    public FCResponse<Void> addRoleMenu(RoleMenuRequest roleMenuRequest) {
        try {
            // 先删除角色的菜单
            this.menuMapper.deleteRoleMenuByRoleId(roleMenuRequest.getRoleId());
            List<RoleMenu> roleMenus = new ArrayList<>();
            List<String> list = Arrays.asList(roleMenuRequest.getMenuIds().split(","));
            roleMenus = list.stream().map(string -> {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleMenuId(IDGeneratorUtil.getNextId());
                roleMenu.setRoleId(roleMenuRequest.getRoleId());
                roleMenu.setMenuId(Long.parseLong(string));
                roleMenu.setCreateTime(new Date());
                roleMenu.setUpdateTime(roleMenu.getCreateTime());
                return roleMenu;
            }).collect(Collectors.toList());
            for (RoleMenu roleMenu : roleMenus
            ) {
                this.menuMapper.addRoleMenu(roleMenu);
            }
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_MENU_ADD_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 添加角色
     *
     * @param roleAddRequest
     * @return
     */
    @Override
    public FCResponse<Void> addRole(RoleAddRequest roleAddRequest) {
        try {
            Role role = new Role();
            BeanUtil.copyProperties(roleAddRequest, role);
            role.setRoleId(IDGeneratorUtil.getNextId());
            role.setCreateTime(new Date());
            role.setUpdateTime(role.getCreateTime());
            this.roleMapper.addRole(role);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_ADD_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 删除角色
     *
     * @param roleId
     * @return
     */
    @Override
    public FCResponse<Void> deleteRole(Long roleId) {
        if (ObjectUtils.isEmpty(roleId) || roleId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.role.ROLE_PARAM_ERROR.getMsg());
        }
        try {
//            // 先查出角色关联的用户Id
//            List<Long> userIds = this.roleMapper.getUserIdByRoleId(roleId);
//            // 将删除的用户转成默认用户
//            userIds.forEach(userId -> {
//                UserRole userRole = new UserRole();
//                userRole.setUserRoleId(IDGeneratorUtil.getNextId());
//                userRole.setUserId(userId);
//                // TODO 默认写死
//                userRole.setRoleId(127341L);
//                userRole.setCreateTime(new Date());
//                userRole.setUpdateTime(userRole.getCreateTime());
//                this.roleMapper.addUserRole(userRole);
//            });
//            //
            // 直接将角色关联的用户的角色id修改为默认角色
            Long defaultRoleId = 127341L;
            Map<String, Object> map = new HashMap<>();
            map.put("defaultRoleId",defaultRoleId);
            map.put("roleId",roleId);
            this.roleMapper.updateUserRoleByRoleId(map);
            // 先删除角色关联的用户
//            this.roleMapper.deleteUserRoleByRoleId(roleId);
            // 删除角色关联的菜单
            this.menuMapper.deleteRoleMenuByRoleId(roleId);
            // 删除角色信息
            this.roleMapper.deleteRoleByRoleId(roleId);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.role.ROLE_DELETE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
