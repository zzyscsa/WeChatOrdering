package com.scsa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.scsa.dataobject.OrderDetail;
import com.scsa.enums.OrderStatusEnum;
import com.scsa.enums.PayStatusEnum;
import com.scsa.utils.EnumUtil;
import com.scsa.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/7/29 20:41
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //如果字段是null，则不返回，如果字段必须返回，就给它一个初始值！
public class OrderDTO {

    private String orderId;

    /** 买家姓名 */
    private String buyerName;


    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信Openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态,默认0为新下单 */
    private Integer orderStatus;

    /** 支付状态, 默认0等待支付 */
    private Integer payStatus;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /* 这个订单包含哪些商品（购物车） */
    List<OrderDetail> orderDetailList;

    @JsonIgnore //转为json忽略这个方法
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
