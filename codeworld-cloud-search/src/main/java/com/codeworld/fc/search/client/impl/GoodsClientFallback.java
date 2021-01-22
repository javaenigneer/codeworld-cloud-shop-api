package com.codeworld.fc.search.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.search.client.GoodsClient;
import com.codeworld.fc.search.domain.ProductDetail;
import com.codeworld.fc.search.domain.ProductResponse;
import com.codeworld.fc.search.domain.ProductSearchRequest;
import com.codeworld.fc.search.domain.ProductSku;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName GoodsClientFallback
 * Description TODO
 * Author Lenovo
 * Date 2020/12/15
 * Version 1.0
**/
@Component
public class GoodsClientFallback implements GoodsClient {
    @Override
    public FCResponse<DataResponse<List<ProductResponse>>> getPageProduct(ProductSearchRequest productSearchRequest) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(), "请求超时",null);
    }

    @Override
    public FCResponse<List<ProductSku>> getProductSkuByProductId(Long productId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(), "请求超时",null);
    }

    @Override
    public FCResponse<ProductDetail> getProductDetailByProductId(Long productId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(), "请求超时",null);
    }

    @Override
    public FCResponse<DataResponse<List<ProductResponse>>> getPageProductTime(ProductSearchRequest productSearchRequest) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(), "请求超时",null);
    }
}
