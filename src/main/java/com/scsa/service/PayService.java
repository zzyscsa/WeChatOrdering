package com.scsa.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.scsa.dto.OrderDTO;

/**
 * 支付
 * @Author: SCSA
 * @Date: 2020/7/31 21:45
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);

}
