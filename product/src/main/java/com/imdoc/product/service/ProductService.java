package com.imdoc.product.service;

import com.imdoc.product.common.DecreaseStockInput;
import com.imdoc.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
public interface ProductService {

    /**
     * 查询所有在架商品
     * @return list
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
