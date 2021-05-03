package com.codeworld.fc.search.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.common.utils.StringUtil;
import com.codeworld.fc.search.client.CategoryClient;
import com.codeworld.fc.search.client.GoodsClient;
import com.codeworld.fc.search.client.MerchantClient;
import com.codeworld.fc.search.client.ParamClient;
import com.codeworld.fc.search.domain.*;
import com.codeworld.fc.search.item.SearchItem;
import com.codeworld.fc.search.repository.SearchRepository;
import com.codeworld.fc.search.request.ProductIndexSearchRequest;
import com.codeworld.fc.search.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName GoodsServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/15
 * Version 1.0
 **/
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsClient goodsClient;
    @Autowired
    private ParamClient paramClient;
    @Autowired
    private CategoryClient categoryClient;
    @Autowired
    private MerchantClient merchantClient;

    @Autowired
    private SearchRepository searchRepository;
    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;
    // 用于保存商品浏览到redis中的前缀
    private static final String PRODUCT_VIEW = "PRODUCT_VIEW:";


    /**
     * 导入数据到ElasticSearch中
     *
     * @return
     */
    public FCResponse<Void> importGoodsToElasticSearch() {

        // 查询的起始页
        Integer page = 1;
        // 每页查询的数量
        Integer limit = 100;
        // 分页查询数据
        // 创建查询数据
        ProductSearchRequest productSearchRequest = new ProductSearchRequest();
        productSearchRequest.setPage(page);
        productSearchRequest.setLimit(limit);
        productSearchRequest.setSaleAble(1);
        Long startTime = System.currentTimeMillis();
        log.info("导入商品开始");
        do {
            FCResponse<DataResponse<List<ProductResponse>>> response = this.goodsClient.getPageProduct(productSearchRequest);
            if (!response.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg());
            }
            if (CollectionUtils.isEmpty(response.getData().getData())) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg());
            }
            // 获取商品数据
            List<ProductResponse> productResponses = response.getData().getData();
            if (CollectionUtils.isEmpty(productResponses)) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg());
            }
            // 构建商品信息
            List<SearchItem> searchItems = productResponses.stream().map(productResponse -> {
                try {
                    return this.buildSearchItems(productResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new FCException("系统错误");
                }
            }).collect(Collectors.toList());
            this.searchRepository.saveAll(searchItems);
            limit = productResponses.size();
            page++;
            productSearchRequest.setPage(page);
        } while (limit == 100);
        Long endTime = System.currentTimeMillis();
        log.info("导入商品完成，耗时{}", endTime - startTime);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_IMPORT_SUCCESS.getMsg());
    }

    /**
     * 删除索引库所有商品
     *
     * @return
     */
    @Override
    public FCResponse<Void> deleteAllGoodsToElasticSearch() {
        this.searchRepository.deleteAll();
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_DELETE_ELASTICSEARCH.getMsg());
    }

    /**
     * 首页获取最新商品
     *
     * @param productIndexSearchRequest
     * @return
     */
    @Override
    public FCResponse<List<ProductResponse>> getNewProductIndex(ProductIndexSearchRequest productIndexSearchRequest) {
        try {
            // 自定义查询构建器
            NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
            // 添加查询条件,查询上架的商品
            queryBuilder.withQuery(QueryBuilders.termQuery("saleAble", 1));
            // 添加分页
            queryBuilder.withPageable(PageRequest.of(productIndexSearchRequest.getPageFrom(), productIndexSearchRequest.getPageSize()));
            Page<SearchItem> searchResponse = this.searchRepository.search(queryBuilder.build());
            if (CollectionUtils.isEmpty(searchResponse.getContent())) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg(), null);
            }
            List<SearchItem> searchItems = searchResponse.getContent();
            List<ProductResponse> productResponses = searchItems.stream().map(searchItem -> {
                return this.buildProductResponse(searchItem);
            }).collect(Collectors.toList());
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), productResponses);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 根据商品id查询商品
     *
     * @param productId
     * @return
     */
    @Override
    public FCResponse<ProductResponse> getProductById(Long productId) {
        if (ObjectUtil.isEmpty(productId) || productId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.product.PRODUCT_ID_ERROR.getMsg());
        }
        // 自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加查询条件
        queryBuilder.withQuery(QueryBuilders.termQuery("productId", productId));
        // 获取结果集
        Page<SearchItem> search = this.searchRepository.search(queryBuilder.build());
        if (CollectionUtils.isEmpty(search.getContent())) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg());
        }
        SearchItem searchItem = search.getContent().get(0);
        ProductResponse productResponse = this.buildProductResponse(searchItem);
        // 每点击一次增加一次点击量
        this.stringRedisTemplate.opsForValue().increment(PRODUCT_VIEW + productId.toString(), 1L);
        log.info("商品浏览量增加，商品Id：{}",productId);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), productResponse);
    }

    /**
     * 将商品定时导入到索引库
     *
     * @return
     */
    @Override
    public FCResponse<Void> importGoodsToElasticSearchTime() {
        // 查询的起始页
        Integer page = 1;
        // 每页查询的数量
        Integer limit = 100;
        // 分页查询数据
        // 创建查询数据
        ProductSearchRequest productSearchRequest = new ProductSearchRequest();
        productSearchRequest.setPage(page);
        productSearchRequest.setLimit(limit);
        productSearchRequest.setSaleAble(1);
        Long startTime = System.currentTimeMillis();
        log.info("定时导入商品开始,现在时间是：{}", DateUtil.date(new Date()));
        do {
            FCResponse<DataResponse<List<ProductResponse>>> response = this.goodsClient.getPageProductTime(productSearchRequest);
            if (!response.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), response.getMsg());
            }
            if (CollectionUtils.isEmpty(response.getData().getData())) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg());
            }
            // 获取商品数据
            List<ProductResponse> productResponses = response.getData().getData();
            if (CollectionUtils.isEmpty(productResponses)) {
                return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg());
            }
            // 构建商品信息
            List<SearchItem> searchItems = productResponses.stream().map(productResponse -> {
                try {
                    return this.buildSearchItems(productResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new FCException("系统错误");
                }
            }).collect(Collectors.toList());
            this.searchRepository.saveAll(searchItems);
            limit = productResponses.size();
            page++;
            productSearchRequest.setPage(page);
        } while (limit == 100);
        Long endTime = System.currentTimeMillis();
        log.info("定时导入商品完成，耗时{}", endTime - startTime);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_IMPORT_SUCCESS.getMsg());
    }

    /**
     * 根据分类id查询商品
     *
     * @param productSearchRequest
     * @return
     */
    @Override
    public FCResponse<List<ProductResponse>> getProductByCategoryId(ProductSearchRequest productSearchRequest) {

        if (StringUtils.isEmpty(productSearchRequest.getSubCateId())){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.category.CATEGORY_ID_ERROR.getMsg());
        }
        // 自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加查询条件
        queryBuilder.withQuery(QueryBuilders.termQuery("categoryId", productSearchRequest.getSubCateId()));
        // 添加分页
        queryBuilder.withPageable(PageRequest.of(productSearchRequest.getPage(), productSearchRequest.getLimit()));
        Page<SearchItem> searchResponse = this.searchRepository.search(queryBuilder.build());
        if (CollectionUtils.isEmpty(searchResponse.getContent())) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.product.PRODUCT_DATA_EMPTY.getMsg(), null);
        }
        List<SearchItem> searchItems = searchResponse.getContent();
        List<ProductResponse> productResponses = searchItems.stream().map(searchItem -> {
            return this.buildProductResponse(searchItem);
        }).collect(Collectors.toList());
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.product.PRODUCT_GET_SUCCESS.getMsg(), productResponses);
    }

    /**
     * 更新商品状态
     *
     * @param elProductStatusDTO
     */
    @Override
    public Boolean updateProductStatus(ElProductStatusDTO elProductStatusDTO) {

        // 先根据商品Id查询商品信息
        // 自定义查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加查询条件
        queryBuilder.withQuery(QueryBuilders.termQuery("productId", elProductStatusDTO.getProductId()));
        // 获取结果集
        Page<SearchItem> search = this.searchRepository.search(queryBuilder.build());
        if (CollectionUtils.isEmpty(search.getContent())) {
            log.error("查询到的商品为空,参数：{}",elProductStatusDTO);
            return false;
        }
        SearchItem searchItem = search.getContent().get(0);
        // 修改状态
        searchItem.setSaleAble(elProductStatusDTO.getSaleAble());
        try {
            this.searchRepository.save(searchItem);
            log.info("ElasticSearch中商品状态更新成功");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            log.error("ElasticSearch中商品状态更新成功");
            return false;
        }
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public Boolean deleteGoods(Long id) {
        try {
            this.searchRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 从索引库获取商品转化为productResponse
     *
     * @param searchItem
     * @return
     */
    private ProductResponse buildProductResponse(SearchItem searchItem) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(searchItem.getProductId());
        productResponse.setCategoryId(searchItem.getCategoryId());
        // 根据分类id查询分类信息
        FCResponse<Category> categoryResponse = this.categoryClient.getCategoryById(searchItem.getCategoryId());
        if (ObjectUtil.isEmpty(categoryResponse.getData())) {
            return productResponse;
        }
        Category category = categoryResponse.getData();
        productResponse.setCategoryName(category.getName());
        productResponse.setCreateTime(searchItem.getCreateTime());
        productResponse.setUpdateTime(searchItem.getUpdateTime());
        // 获取图片
        List<String> images = Arrays.asList(searchItem.getImages().split(","));
        productResponse.setImages(images);
        // 获取价格
        List<String> prices = Arrays.asList(searchItem.getPrices().split(","));
        productResponse.setPrice(Integer.parseInt(prices.get(0)));
        // 获取标题
        List<String> allTitle = Arrays.asList(searchItem.getAllTitle().split(","));
        productResponse.setTitle(allTitle.get(0));
        // 获取特殊参数
        List<String> specialParam = StringUtil.getFirstBlankString(searchItem.getAllTitle());
        productResponse.setSpecialParam(specialParam);
        productResponse.setSku(searchItem.getSku());
        productResponse.setMerchantName(searchItem.getMerchantName());
        productResponse.setMerchantNumber(searchItem.getMerchantNumber());
        productResponse.setView(searchItem.getView());
        productResponse.setStoreId(searchItem.getStoreId());
        return productResponse;
    }


    /**
     * 构建商品信息
     *
     * @param productResponse
     * @return
     */
    private SearchItem buildSearchItems(ProductResponse productResponse) {

        // 收集sku的必要字段信息
        List<Map<String, Object>> skuMapList = new ArrayList<>();
        SearchItem searchItem = new SearchItem();
        searchItem.setProductId(productResponse.getId());
        searchItem.setCategoryId(productResponse.getCategoryId());
//        searchItem.setTitle(productResponse.getTitle());
        searchItem.setCreateTime(productResponse.getCreateTime());
        searchItem.setUpdateTime(productResponse.getUpdateTime());
        searchItem.setView(productResponse.getView());
        searchItem.setStoreId(productResponse.getStoreId());
        searchItem.setSaleAble(productResponse.getSaleAble());
        // 根据商户Id查询商户号和商家名称
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(productResponse.getMerchantId());
        if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            log.error("该商品{}无商户号", productResponse.getId());
            return searchItem;
        }
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        // 设置商户号和商户名称
        searchItem.setMerchantName(merchantResponse.getMerchantName());
        searchItem.setMerchantNumber(merchantResponse.getNumber());
        // 根据分类id查询所有的分类下参数
        FCResponse<List<ParamResponse>> paramResponse = this.paramClient.getParamByCategoryId(productResponse.getCategoryId());
        if (!paramResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            log.error("该商品{}无分类参数", productResponse.getId());
            return searchItem;
        }
        if (CollectionUtils.isEmpty(paramResponse.getData())) {
            return searchItem;
        }
        List<ParamResponse> paramResponses = paramResponse.getData();

        // 根据商品id查询所有的sku
        FCResponse<List<ProductSku>> productSkuResponse = this.goodsClient.getProductSkuByProductId(productResponse.getId());
        if (!productSkuResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            log.error("该商品{}无Sku", productResponse.getId());
            return searchItem;
        }
        if (CollectionUtils.isEmpty(productSkuResponse.getData())) {
            return searchItem;
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder priceStringBuilder = new StringBuilder();
        StringBuilder titleStringBuilder = new StringBuilder();
        List<ProductSku> productSkus = productSkuResponse.getData();
        productSkus.forEach(productSku -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", productSku.getId());
            map.put("title", productSku.getTitle());
            map.put("price", productSku.getPrice());
            map.put("images", productSku.getImages());
            stringBuilder.append(productSku.getImages()).append(",");
            priceStringBuilder.append(productSku.getPrice()).append(",");
            titleStringBuilder.append(productSku.getTitle()).append(",");
            skuMapList.add(map);
        });
        String image = stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
        String prices = priceStringBuilder.deleteCharAt(priceStringBuilder.length() - 1).toString();
        String allTitle = titleStringBuilder.deleteCharAt(titleStringBuilder.length() - 1).toString();
        searchItem.setImages(image);
        searchItem.setPrices(prices);
        searchItem.setAllTitle(allTitle);
        // 根据商品获取商品详细信息
        FCResponse<ProductDetail> productDetailResponse = this.goodsClient.getProductDetailByProductId(productResponse.getId());
        if (!productDetailResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            log.error("商品{}无详细信息",productResponse.getId());
            return searchItem;
        }
        if (ObjectUtil.isEmpty(productDetailResponse.getData())) {
            return searchItem;
        }
        ProductDetail productDetail = productDetailResponse.getData();
        Map<String, Object> genericParamMap = JsonUtils.parseMap(productDetail.getGenericParam(), String.class, Object.class);
        Map<String, Object> specs = new HashMap<String, Object>();
        paramResponses.forEach(param -> {
            assert genericParamMap != null;
            String value = (String) genericParamMap.get(param.getId().toString());
            specs.put(param.getName(), value);
        });
        searchItem.setSku(JsonUtils.serialize(skuMapList));
        searchItem.setSpecs(specs);
        return searchItem;
    }
}
