package com.codeworld.fc.merchant.client;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.merchant.domain.UserRole;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("codeworld-cloud-system")
public interface RoleClient {

    @PostMapping("/codeworld-system/role/add-user-role")
    @ApiOperation("添加用户角色")
    FCResponse<Void> addUserRole(@RequestBody UserRole userRole);
}
