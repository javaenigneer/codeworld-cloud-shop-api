package com.codeworld.fc.system.dept.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.system.dept.dto.DeptRequestDTO;


public interface DeptService {
    /**
     * 获取部门树
     * @return
     */
    FCResponse<Object> treeDept();

    /**
     * 添加部门
     * @param deptRequestDTO
     * @return
     */
    FCResponse<Void> addDept(DeptRequestDTO deptRequestDTO);

    /**
     * 修改部门
     * @param deptRequestDTO
     * @return
     */
    FCResponse<Void> updateDept(DeptRequestDTO deptRequestDTO);
}
