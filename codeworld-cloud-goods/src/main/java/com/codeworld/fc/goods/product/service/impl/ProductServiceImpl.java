package com.codeworld.fc.goods.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.goods.client.SearchClient;
import com.codeworld.fc.goods.interceptor.AuthInterceptor;
import com.codeworld.fc.goods.param.entity.Param;
import com.codeworld.fc.goods.param.mapper.ParamMapper;
import com.codeworld.fc.goods.product.domain.ElProductStatusDTO;
import com.codeworld.fc.goods.product.entity.Product;
import com.codeworld.fc.goods.product.entity.ProductDetail;
import com.codeworld.fc.goods.product.entity.ProductSku;
import com.codeworld.fc.goods.product.mapper.ProductDetailMapper;
import com.codeworld.fc.goods.product.mapper.ProductMapper;
import com.codeworld.fc.goods.product.mapper.ProductSkuMapper;
import com.codeworld.fc.goods.product.request.ExamineProductRequest;
import com.codeworld.fc.goods.product.request.ProductAddRequest;
import com.codeworld.fc.goods.product.request.ProductSearchRequest;
import com.codeworld.fc.goods.product.response.ProductResponse;
import com.codeworld.fc.goods.product.service.ProductService;
import com.codeworld.fc.goods.product.vo.SkuVO;
import com.codeworld.fc.goods.stock.entity.Stock;
import com.codeworld.fc.goods.stock.mapper.StockMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName ProductServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/28
 * Version 1.0
 **/
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired(required = false)
    private ProductMapper productMapper;
    @Autowired(required = false)
    private ProductDetailMapper productDetailMapper;
    @Autowired(required = false)
    private ProductSkuMapper productSkuMapper;
    @Autowired(required = false)
    private StockMapper stockMapper;
    @Autowired(required = false)
    private ParamMapper paramMapper;

    @Autowired(required = false)
    private AmqpTemplate amqpTemplate;

    @Autowired(required = false)
    private SearchClient searchClient;

    /**
     * 分页查询商品列表
     *
     * @param productSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<ProductResponse>>> getPageProduct(ProductSearchRequest productSearchRequest) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginMember();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("登录失效，请重新登录");
        }
        // 判断属于那种标识--商户标识
        if ("merchant".equals(loginInfoData.getResources())) {
            productSearchRequest.setMerchantId(loginInfoData.getId());
        } else {
            // 系统标识
            productSearchRequest.setMerchantId(null);
        }
        PageHelper.startPage(productSearchRequest.getPage(), productSearchRequest.getLimit());
        List<ProductResponse> productResponses = this.productMapper.getPageProduct(productSearchRequest);
        if (CollectionUtils.isEmpty(productResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg(), DataResponse.dataResponse(productResponses, 0L));
        }
        PageInfo<ProductResponse> pageInfo = new PageInfo<>(productResponses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 修改商品状态
     *
     * @param id
     * @param status
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FCResponse<Void> updateProductStatus(Long id, Integer status) {
        if (ObjectUtils.isEmpty(id) || id <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.product.PRODUCT_ID_ERROR.getMsg());
        }
        Product product = new Product();
        product.setId(id);
        product.setSaleAble(status);
        product.setUpdateTime(new Date());
        this.productMapper.updateProductStatus(product);
        ElProductStatusDTO elProductStatusDTO = new ElProductStatusDTO();
        elProductStatusDTO.setProductId(product.getId());
        elProductStatusDTO.setSaleAble(product.getSaleAble());
        String json = JsonUtils.serialize(elProductStatusDTO);
        // 异步更新ElasticSearch商品的状态
        this.amqpTemplate.convertAndSend("el.product.update.saleable", json);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_UPDATE_STATUS.getMsg());
    }

    /**
     * 添加商品
     *
     * @param productAddRequest
     * @return
     */
    @Override
    @Transactional
    public FCResponse<Void> addProduct(ProductAddRequest productAddRequest) {
        try {
            // 获取当前登录商户
            LoginInfoData loginInfoData = AuthInterceptor.getLoginMember();
            if (ObjectUtils.isEmpty(loginInfoData)) {
                throw new FCException("登录失效，请重新登录");
            }
            Product product = new Product();
            BeanUtil.copyProperties(productAddRequest, product);
            product.setId(IDGeneratorUtil.getNextId());
            // 默认为下架
            product.setSaleAble(0);
            product.setCreateTime(new Date());
            product.setUpdateTime(product.getCreateTime());
            product.setMerchantId(loginInfoData.getId());
            // 设置为未审核
            product.setApproveStatus(-1);
            this.productMapper.addProduct(product);
            // 添加商品详细信息
            ProductDetail productDetail = new ProductDetail();
            productDetail.setId(product.getId());
            productDetail.setDesc(productAddRequest.getDesc());
            // 商品通用参数
            productDetail.setGenericParam(productAddRequest.getGenericParam());
            productDetail.setSpecialParam(productAddRequest.getSpecialParam());
            productDetail.setAfterService(productAddRequest.getAfterService());
            productDetail.setPackingList(productAddRequest.getPackingList());
            productDetail.setCreateTime(new Date());
            productDetail.setUpdateTime(productDetail.getCreateTime());
            this.productDetailMapper.addProductDetail(productDetail);
            // 添加Sku商品
            // 将Json字符串序列化为List对象
            List<SkuVO> skuVOS = JsonUtils.parseList(productAddRequest.getSku(), SkuVO.class);
            if (CollectionUtils.isEmpty(skuVOS)) {
                return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.product.PRODUCT_PARAM_ERROR.getMsg());
            }
            // 循环添加数据
            skuVOS.forEach(skuVO -> {
                StringBuilder stringBuilder = new StringBuilder();
                ProductSku productSku = new ProductSku();
                productSku.setId(IDGeneratorUtil.getNextId());
                productSku.setProductId(product.getId());
                stringBuilder.append(product.getTitle()).append(" ").append(skuVO.getColor()).append(" ").append(skuVO.getSpec());
                String title = stringBuilder.toString();
                productSku.setTitle(title);
                productSku.setPrice(skuVO.getPrice());
                productSku.setOwnSpec(skuVO.getOwnSpec());
                productSku.setImages(StringUtils.join(skuVO.getImages(), ","));
                productSku.setCreateTime(new Date());
                productSku.setUpdateTime(productSku.getCreateTime());
                // 添加sku
                this.productSkuMapper.addProductSku(productSku);
                // 添加到库存
                Stock stock = new Stock();
                stock.setProductSkuId(productSku.getId());
                stock.setStock(skuVO.getStock());
                this.stockMapper.addStock(stock);
            });
            // 根据商品id获取商品信息ProductResponse
//            ProductResponse productResponse = this.productMapper.getProductResponseById(product.getId());
//            FCResponse<Void> response = this.searchClient.importGoodsSoon(productResponse);
//            if (!response.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
//                return FCResponse.dataResponse(response.getCode(), response.getMsg());
//            }
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_ADD_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 根据商品id查询所有的Sku
     *
     * @param productId
     * @return
     */
    @Override
    public FCResponse<List<ProductSku>> getProductSkuByProductId(Long productId) {

        List<ProductSku> productSkus = this.productSkuMapper.getProductSkuByProductId(productId);
        if (CollectionUtils.isEmpty(productSkus)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg(), productSkus);
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), productSkus);
    }

    /**
     * 根据商品id查询商品详情
     *
     * @param productId
     * @return
     */
    @Override
    public FCResponse<ProductDetail> getProductDetailByProductId(Long productId) {
        ProductDetail productDetail = this.productDetailMapper.getProductDetailByProductId(productId);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), productDetail);
    }

    /**
     * 获取最新商品
     *
     * @return
     */
    @Override
    public FCResponse<List<ProductResponse>> getNewProduct() {
        List<ProductResponse> productResponses = this.productMapper.getNewProduct();
        productResponses = productResponses.stream().map(productResponse -> {
            if (StringUtils.isNotBlank(productResponse.getImage())) {
                List<String> images = Arrays.asList(StringUtils.split(productResponse.getImage(), ","));
                productResponse.setImages(images);
            }
            productResponse.setImage(null);
            return productResponse;
        }).collect(Collectors.toList());
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), productResponses);
    }

    /**
     * 定时分页查询商品
     *
     * @param productSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<ProductResponse>>> getPageProductTime(ProductSearchRequest productSearchRequest) {
        // 定时查询商品，默认为管理员操作
        productSearchRequest.setMerchantId(null);
        PageHelper.startPage(productSearchRequest.getPage(), productSearchRequest.getLimit());
        List<ProductResponse> productResponses = this.productMapper.getPageProduct(productSearchRequest);
        if (CollectionUtils.isEmpty(productResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg(), DataResponse.dataResponse(productResponses, 0L));
        }
        PageInfo<ProductResponse> pageInfo = new PageInfo<>(productResponses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @Override
    public FCResponse<Void> deleteGoods(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            return FCResponse.validateErrorResponse("商品ID为空");
        }
        // 查询商品信息
        Product product = this.productMapper.getProductById(id);
        if (ObjectUtils.isEmpty(product)) {
            return FCResponse.validateErrorResponse("商品不存在");
        }
        // 判断商品是否已删除
        if (product.getSaleAble() == -1) {
            return FCResponse.validateErrorResponse("商品已删除");
        }
        // 判断是否商品处于上架状态
        if (product.getSaleAble() == 1) {
            return FCResponse.validateErrorResponse("商品在架状态，不能删除");
        }
        product.setSaleAble(-1);
        try {
            this.productMapper.updateProductStatus(product);
            // 异步通知删除索引库中的内容
            log.info("发送删除EL中商品的异步通知开始");
            this.amqpTemplate.convertAndSend("el.product.delete", id);
            log.info("发送删除EL删除商品异步通知结束");
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_DELETE_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 根据商品 id获取商品信息
     *
     * @param id
     * @return
     */
    @Override
    public FCResponse<ProductResponse> getProductResponseById(Long id) {
        ProductResponse productResponse = this.productMapper.getProductResponseById(id);
        if (ObjectUtils.isEmpty(productResponse)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), "商品为空");
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), "商品查询成功", productResponse);
    }

    /**
     * 审核商品
     *
     *
     * @param examineProductRequest@return
     */
    @Override
    public FCResponse<Void> examineProduct(ExamineProductRequest examineProductRequest) {
        try {
            Product product = new Product();
            product.setId(examineProductRequest.getProductId());
            product.setApproveStatus(examineProductRequest.getApproveStatus());
            product.setApproveRemark(examineProductRequest.getApproveRemark());
            this.productMapper.examineProduct(product);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), "审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取商品详细信息，用于审核商品专用
     *
     * @param id
     * @return
     */
    @Override
    public FCResponse<ProductResponse> getProductInfoById(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), "商品ID为空");
        }
        ProductResponse productResponse = this.productMapper.getProductResponseById(id);
        if (ObjectUtils.isEmpty(productResponse)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), "商品为空");
        }
        // 获取商品详情
        ProductDetail productDetail = this.productDetailMapper.getProductDetailByProductId(id);
        Map<String, Object> genericParamMap = new HashMap<>();
        // 将商品通用参数和特有参数转换
        Map<Long, Object> map = JsonUtils.parseMap(productDetail.getGenericParam(), Long.class, Object.class);
        assert map != null;
        Set<Long> longs = map.keySet();
        // 获取通用参数的名称
        for (Long paramId : longs) {
            Param param = this.paramMapper.getParamNameById(paramId);
            if (ObjectUtils.isNotEmpty(param)) {
                genericParamMap.put(param.getName(), map.get(paramId));
            }
        }
        productDetail.setGenericParamMap(genericParamMap);
        productResponse.setProductDetail(productDetail);
        // 获取商品Sku
        List<ProductSku> productSkus = this.productSkuMapper.getProductSkuByProductId(id);
        // 将sku中的自有参数进行转换获取参数信息
        productSkus = productSkus.stream().peek(productSku -> {
            StringBuilder ownSpec = new StringBuilder();
            Map<Long, String> parseMap = JsonUtils.parseMap(productSku.getOwnSpec(), Long.class, String.class);
            // 获取map中的值
            assert parseMap != null;
            Set<Long> keys = parseMap.keySet();
            for (Long key : keys) {
                // 获取值
                String value = parseMap.get(key);
                ownSpec.append(value);
                ownSpec.append(" ");
            }
            productSku.setOwnSpec(ownSpec.toString());
            // 获取商品库存
            Integer stock = this.stockMapper.getStockByProductSkuId(productSku.getId());
            productSku.setStock(stock);
        }).collect(Collectors.toList());
        productResponse.setProductSkus(productSkus);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), "查询成功", productResponse);
    }
}
