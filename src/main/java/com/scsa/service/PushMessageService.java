package com.scsa.service;

import com.scsa.dto.OrderDTO;

/**
 * 消息推送
 * @Author: SCSA
 * @Date: 2020/8/5 15:33
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息推送
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
