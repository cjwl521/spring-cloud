package com.imdoc.product.service;

import com.imdoc.product.ProductApplicationTests;
import com.imdoc.product.dataobject.ProductCategory;
import com.imdoc.product.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
@Component
public class CategoryServiceTest extends ProductApplicationTests{

    @Autowired
    private CategoryService categoryService;
    @Test
    public void findByCategoryTypeIn ( ) {
        List <ProductCategory> list = categoryService.findByCategoryTypeIn ( Arrays.asList ( 11, 22 ) );
        Assert.assertTrue ( list.size ()>0 );
    }
}