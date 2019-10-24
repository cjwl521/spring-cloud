package com.imdoc.product.repository;

import com.imdoc.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/8
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory ,String> {

    List<ProductCategory> findByCategoryTypeIn (List<Integer> categoryType);
}
