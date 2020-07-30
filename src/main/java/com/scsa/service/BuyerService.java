package com.scsa.service;

import com.scsa.dto.OrderDTO;

/**
 * 买家
 * @Author: SCSA
 * @Date: 2020/7/30 21:54
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
