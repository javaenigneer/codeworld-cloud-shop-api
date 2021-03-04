package com.codeworld.fc.client;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codeworld-cloud-system")
public interface UserClient {

    @PostMapping("/codeworld-system/user/get-user-id")
    @ApiOperation("根据用户id获取用户信息")
    FCResponse<User> getUserById(@RequestParam("userId") Long userId);
}
