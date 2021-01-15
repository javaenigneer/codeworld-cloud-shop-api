package com.codeworld.fc.merchant.mapper;

import com.codeworld.fc.merchant.entity.MerChantDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MerChantDetailMapper {
    /**
     * 商户入驻
     * @param merChantDetail
     */
    void merchantSettled(MerChantDetail merChantDetail);

    /**
     * 根据商户号查询商户状态
     * @param number
     * @return
     */
    Integer getMerchantStatusByMerchantNumber(String number);

    /**
     * 默认设置商户为未入住状态
     * @param merChantDetail
     */
    void addMerchantDetail(MerChantDetail merChantDetail);

    /**
     * 审核
     * @param merChantDetail
     */
    void examineMerchant(MerChantDetail merChantDetail);

    /**
     * 删除商户详细表
     * @param merchantNumbers
     */
    void deleteNoMerchantSet(List<String> merchantNumbers);
}
