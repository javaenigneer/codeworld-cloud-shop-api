package com.codeworld.fc.system.user.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.system.user.entity.UserDept;


import java.util.List;

public interface UserDeptService {
    /**
     * 根据用户Id获取部门Id
     * @param userId
     * @return
     */
    FCResponse<List<UserDept>> getDeptIdByUserId(Long userId);
}
