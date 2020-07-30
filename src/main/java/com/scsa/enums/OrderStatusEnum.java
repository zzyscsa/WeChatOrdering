package com.scsa.enums;

import lombok.Getter;

/**
 * 订单状态
 * @Author: SCSA
 * @Date: 2020/7/29 18:15
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "已完结订单"),
    CANCEL(2, "已取消订单");


    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
