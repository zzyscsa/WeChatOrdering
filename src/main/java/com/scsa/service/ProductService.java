package com.scsa.service;

import com.scsa.dataobject.ProductInfo;
import com.scsa.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * @Author: SCSA
 * @Date: 2020/7/28 21:15
 */
public interface ProductService {

    ProductInfo findOne(String ProductId);

    /**
     * 查询上架的所有商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有的商品，分页
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /* 加库存 */
    void increaseStock(List<CartDTO> cartDTOList);

    /* 减库存 */
    void decreaseStock(List<CartDTO> cartDTOList);
}
