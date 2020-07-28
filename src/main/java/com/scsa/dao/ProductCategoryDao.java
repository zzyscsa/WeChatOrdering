package com.scsa.dao;

import com.scsa.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/7/28 18:11
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    /* 根据类目类型查询 */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
