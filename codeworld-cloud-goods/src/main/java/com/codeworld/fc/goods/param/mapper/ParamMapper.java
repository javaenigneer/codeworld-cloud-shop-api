package com.codeworld.fc.goods.param.mapper;

import com.codeworld.fc.goods.param.entity.Param;
import com.codeworld.fc.goods.param.request.ParamSearchRequest;
import com.codeworld.fc.goods.param.response.ParamResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ParamMapper {

    /**
     * 分页获取参数
     * @param paramSearchRequest
     * @return
     */
    List<ParamResponse> getPageParam(ParamSearchRequest paramSearchRequest);

    /**
     * 添加参数
     * @param param
     */
    void addParam(Param param);

    /**
     * 根据属性Id查询参数信息
     * @param attributeIds
     * @return
     */
    List<ParamResponse> getParamByAttributeId(List<Long> attributeIds);

    /**
     * 根据属性Id查询通用参数
     * @param attributeIds
     * @return
     */
    List<ParamResponse> getSpecialParamByCategoryId(List<Long> attributeIds);

    /**
     * 根据属性id删除分类信息
     * @param attributeIds
     */
    void deleteParamByAttributeIds(List<Long> attributeIds);
}
