package com.imdoc.product.service;

import com.imdoc.product.ProductApplicationTests;
import com.imdoc.product.common.DecreaseStockInput;
import com.imdoc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;
    @Test
    public void findUpAll ( ) throws Exception{
        List <ProductInfo> list = productService.findUpAll ();
        Assert.assertTrue ( list.size ()>0 );
    }

    @Test
    public void findList () throws Exception {
        List<ProductInfo> list = productService.findList (Arrays.asList ("157875196366160022", "157875227953464068"));
        Assert.assertTrue ( list.size ()>0 );
    }

    @Test
    public void decreaseStock() throws Exception{
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875196366160022",2);
        productService.decreaseStock (Arrays.asList (decreaseStockInput));
    }
}