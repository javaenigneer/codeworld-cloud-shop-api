package com.codeworld.fc.system.menu.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.system.menu.dto.MenuRequestDTO;
import com.codeworld.fc.system.menu.entity.Menu;
import com.codeworld.fc.system.menu.entity.RoleMenu;


import java.util.List;

public interface MenuService {
    /**
     * 根据角色id查询菜单
     * @param roleId
     * @return
     */
    FCResponse<List<Menu>> getMenuByRoleId(Long roleId);

    /**
     * 获取菜单树
     * @return
     */
    FCResponse<Object> treeMenu();

    /**
     * 删除用户角色菜单
     * @param roleId
     * @return
     */
    FCResponse<Void> deleteRoleMenuByRoleId(Long roleId);

    /**
     * 添加角色菜单
     * @param roleMenu
     * @return
     */
    FCResponse<Void> addRoleMenu(RoleMenu roleMenu);

    /**
     * 添加菜单
     * @param menuRequestDTO
     * @return
     */
    FCResponse<Void> addMenu(MenuRequestDTO menuRequestDTO);

    /**
     * 修改菜单
     * @param menuRequestDTO
     * @return
     */
    FCResponse<Void> updateMenu(MenuRequestDTO menuRequestDTO);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    FCResponse<Void> deleteMenu(Long id);
}
