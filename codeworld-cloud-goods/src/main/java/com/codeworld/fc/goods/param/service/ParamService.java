package com.codeworld.fc.goods.param.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.param.request.ParamAddRequest;
import com.codeworld.fc.goods.param.request.ParamSearchRequest;
import com.codeworld.fc.goods.param.response.ParamResponse;

import java.util.List;

public interface ParamService {
    /**
     * 分页获取参数
     * @param paramSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<ParamResponse>>> getPageParam(ParamSearchRequest paramSearchRequest);

    /**
     * 添加参数
     * @param paramAddRequest
     * @return
     */
    FCResponse<Void> addParam(ParamAddRequest paramAddRequest);

    /**
     * 查询分类下的属性的参数
     * @param categoryId
     * @return
     */
    FCResponse<List<ParamResponse>> getParamByCategoryId(Long categoryId);

    /**
     * 根据分类id查询通用参数
     * @param categoryId
     * @return
     */
    FCResponse<List<ParamResponse>> getSpecialParamByCategoryId(Long categoryId);
}
