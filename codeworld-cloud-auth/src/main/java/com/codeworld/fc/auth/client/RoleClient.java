package com.codeworld.fc.auth.client;


import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.auth.domain.Role;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("codeworld-cloud-system")
public interface RoleClient {

    @GetMapping("/codeworld-system/role/get-role-user-id")
    @ApiOperation("根据用户id获取角色")
    FCResponse<Role> getRoleByUserId(@RequestParam("userId") Long userId);
}
