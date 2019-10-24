package com.imdoc.product.service.impl;

import com.imdoc.product.dataobject.ProductCategory;
import com.imdoc.product.repository.ProductCategoryRepository;
import com.imdoc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn (List <Integer> categoryType) {
        return productCategoryRepository.findByCategoryTypeIn ( categoryType );
    }
}
