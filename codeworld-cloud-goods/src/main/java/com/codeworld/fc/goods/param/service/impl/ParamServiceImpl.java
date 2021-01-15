package com.codeworld.fc.goods.param.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.goods.attribute.mapper.AttributeMapper;
import com.codeworld.fc.goods.param.entity.Param;
import com.codeworld.fc.goods.param.mapper.ParamMapper;
import com.codeworld.fc.goods.param.request.ParamAddRequest;
import com.codeworld.fc.goods.param.request.ParamSearchRequest;
import com.codeworld.fc.goods.param.response.ParamResponse;
import com.codeworld.fc.goods.param.service.ParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName ParamServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/7
 * Version 1.0
**/
@Service
public class ParamServiceImpl implements ParamService {

    @Autowired(required = false)
    private ParamMapper paramMapper;
    @Autowired(required = false)
    private AttributeMapper attributeMapper;

    /**
     * 分页获取参数
     *
     * @param paramSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<ParamResponse>>> getPageParam(ParamSearchRequest paramSearchRequest) {
        PageHelper.startPage(paramSearchRequest.getPage(),paramSearchRequest.getLimit());
        List<ParamResponse> paramResponses = this.paramMapper.getPageParam(paramSearchRequest);
        if (CollectionUtils.isEmpty(paramResponses)){
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.param.PARAM_DATA_EMPTY.getMsg(),DataResponse.dataResponse(paramResponses,0L));
        }
        PageInfo<ParamResponse> pageInfo = new PageInfo<>(paramResponses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.param.PARAM_GET_SUCCESS.getMsg(),DataResponse.dataResponse(pageInfo.getList(),pageInfo.getTotal()));
    }

    /**
     * 添加参数
     *
     * @param paramAddRequest
     * @return
     */
    @Override
    public FCResponse<Void> addParam(ParamAddRequest paramAddRequest) {
        Param param = new Param();
        BeanUtil.copyProperties(paramAddRequest,param);
        param.setId(IDGeneratorUtil.getNextId());
        param.setCreateTime(new Date());
        param.setUpdateTime(param.getCreateTime());
        this.paramMapper.addParam(param);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.param.PARAM_ADD_SUCCESS.getMsg());
    }

    /**
     * 查询分类下的属性的参数
     *
     * @param categoryId
     * @return
     */
    @Override
    public FCResponse<List<ParamResponse>> getParamByCategoryId(Long categoryId) {
        if (ObjectUtils.isEmpty(categoryId) || categoryId <= 0){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.category.CATEGORY_ID_ERROR.getMsg());
        }

        // 先根据分类Id查询属性id
        List<Long> attributeIds = this.attributeMapper.getAttributeIdsByCategoryId(categoryId);
        if (CollectionUtils.isEmpty(attributeIds)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.attribute.ATTRIBUTE_DATA_EMPTY.getMsg());
        }
        // 根据属性Id查询参数数据
        List<ParamResponse> paramResponses = this.paramMapper.getParamByAttributeId(attributeIds);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.param.PARAM_GET_SUCCESS.getMsg(),paramResponses);
    }

    /**
     * 根据分类id查询通用参数
     *
     * @param categoryId
     * @return
     */
    @Override
    public FCResponse<List<ParamResponse>> getSpecialParamByCategoryId(Long categoryId) {
        if (ObjectUtils.isEmpty(categoryId) || categoryId <= 0){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.category.CATEGORY_ID_ERROR.getMsg());
        }

        // 先根据分类Id查询属性id
        List<Long> attributeIds = this.attributeMapper.getAttributeIdsByCategoryId(categoryId);
        // 根据属性Id查询参数数据
        List<ParamResponse> paramResponses = this.paramMapper.getSpecialParamByCategoryId(attributeIds);
        if (CollectionUtils.isEmpty(paramResponses)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.param.PARAM_GENERIC_DATA_EMPTY.getMsg(),paramResponses);
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.param.PARAM_GET_SUCCESS.getMsg(),paramResponses);
    }
}
