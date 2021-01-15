package com.codeworld.fc.system.menu.controller;

import com.codeworld.fc.common.response.FCResponse;

import com.codeworld.fc.system.menu.dto.MenuRequestDTO;
import com.codeworld.fc.system.menu.entity.Menu;
import com.codeworld.fc.system.menu.entity.RoleMenu;
import com.codeworld.fc.system.menu.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName MenuController
 * Description 菜单接口管理
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-system/menu")
@Api(tags = "菜单接口管理")
public class MenuController {

    @Autowired(required = false)
    private MenuService menuService;

    @GetMapping("get-menu-role-id")
    @ApiOperation("根据角色id查询菜单")
    public FCResponse<List<Menu>> getMenuByRoleId(@RequestParam("roleId") Long roleId){
        return this.menuService.getMenuByRoleId(roleId);
    }

    @PostMapping("tree-menu")
    @ApiOperation("获取菜单树")
    public FCResponse<Object> treeMenu() {
        return this.menuService.treeMenu();
    }

    @GetMapping("delete-role-menu-role-id")
    @ApiOperation("删除用户角色菜单")
    public FCResponse<Void> deleteRoleMenuByRoleId(@RequestParam("roleId") Long roleId){
        return this.menuService.deleteRoleMenuByRoleId(roleId);
    }

    @PostMapping("add-role-menu")
    @ApiOperation("添加角色菜单")
    public FCResponse<Void> addRoleMenu(@RequestBody RoleMenu roleMenu){
        return this.menuService.addRoleMenu(roleMenu);
    }

    @PostMapping("add-menu")
    @ApiOperation("添加菜单")
    public FCResponse<Void> addMenu(@RequestBody @Valid MenuRequestDTO menuRequestDTO) {
        return this.menuService.addMenu(menuRequestDTO);
    }

    @PostMapping("delete-menu")
    @ApiOperation("删除菜单")
    public FCResponse<Void> deleteMenu(@RequestParam("id") Long id) {
        return this.menuService.deleteMenu(id);
    }

    @PostMapping("update-menu")
    @ApiOperation("修改菜单")
    public FCResponse<Void> updateMenu(@RequestBody @Valid MenuRequestDTO menuRequestDTO) {
        return this.menuService.updateMenu(menuRequestDTO);
    }
}
