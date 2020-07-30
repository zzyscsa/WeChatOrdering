package com.scsa.dto;

import lombok.Data;

/**
 * 购物车对象
 * @Author: SCSA
 * @Date: 2020/7/29 21:39
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
