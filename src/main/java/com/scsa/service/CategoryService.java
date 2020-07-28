package com.scsa.service;

import com.scsa.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @Author: SCSA
 * @Date: 2020/7/28 20:33
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
