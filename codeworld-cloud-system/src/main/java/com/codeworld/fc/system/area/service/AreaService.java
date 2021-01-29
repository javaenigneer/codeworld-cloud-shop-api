package com.codeworld.fc.system.area.service;

import com.codeworld.fc.common.response.FCResponse;

public interface AreaService {
    /**
     * 获取区域树
     * @return
     */
    FCResponse<Object> treeArea();
}
