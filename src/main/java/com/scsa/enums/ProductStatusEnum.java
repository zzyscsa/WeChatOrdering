package com.scsa.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 商品状态
 * @Author: SCSA
 * @Date: 2020/7/28 21:20
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

}
