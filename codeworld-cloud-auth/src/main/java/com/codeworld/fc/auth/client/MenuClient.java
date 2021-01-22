package com.codeworld.fc.auth.client;


import com.codeworld.fc.auth.client.impl.MenuClientFallBack;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.auth.domain.Menu;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@FeignClient(name = "codeworld-cloud-system")
public interface MenuClient {

    @GetMapping("/codeworld-system/menu/get-menu-role-id")
    @ApiOperation("根据角色id查询菜单")
    FCResponse<List<Menu>> getMenuByRoleId(@RequestParam("roleId") Long roleId);
}
