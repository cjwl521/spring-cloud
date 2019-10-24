package com.imdoc.product.repository;

import com.imdoc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
@RunWith (SpringRunner.class)
@SpringBootTest
public class ProductionInfoRepositoryTest {

    @Autowired
    private ProductionInfoRepository productionInfoRepository;

    @Test
    public void findByProductStatus ( ) {
        List <ProductInfo> list = productionInfoRepository.findByProductStatus (0);
        Assert.assertTrue ( list.size ()>0 );
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List <ProductInfo> list = productionInfoRepository.findByProductIdIn (Arrays.asList ("157875196366160022", "157875227953464068"));
        Assert.assertTrue (list.size ()>0);
    }
}