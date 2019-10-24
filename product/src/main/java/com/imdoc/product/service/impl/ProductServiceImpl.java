package com.imdoc.product.service.impl;

import com.imdoc.product.common.DecreaseStockInput;
import com.imdoc.product.common.ProductInfoOutput;
import com.imdoc.product.dataobject.ProductInfo;
import com.imdoc.product.enums.ProductStatusEnum;
import com.imdoc.product.enums.ResultEnum;
import com.imdoc.product.exception.ProductException;
import com.imdoc.product.repository.ProductionInfoRepository;
import com.imdoc.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductionInfoRepository productionInfoRepository;
    @Override
    public List<ProductInfo> findUpAll ( ) {
        return productionInfoRepository.findByProductStatus ( ProductStatusEnum.UP.getCode () );
    }

    @Override
    public List <ProductInfo> findList (List <String> productIdList) {
        return productionInfoRepository.findByProductIdIn (productIdList);
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<> ();
        for (DecreaseStockInput decreaseStockInput: decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productionInfoRepository.findById(decreaseStockInput.getProductId());
            //判断商品是否存在
            if (!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            //库存是否足够
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException (ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productionInfoRepository.save(productInfo);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
