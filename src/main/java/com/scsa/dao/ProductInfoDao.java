package com.scsa.dao;

import com.scsa.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/7/28 21:06
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    /* 查询上架的商品 */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
