package com.imdoc.product.service;

import com.imdoc.product.dataobject.ProductCategory;
import com.imdoc.product.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
public interface CategoryService {

    List <ProductCategory> findByCategoryTypeIn (List <Integer> categoryType);
}
