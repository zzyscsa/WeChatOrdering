package com.scsa.controller;

import com.lly835.bestpay.model.PayResponse;
import com.scsa.dto.OrderDTO;
import com.scsa.enums.ResultEnum;
import com.scsa.exception.SellException;
import com.scsa.service.OrderService;
import com.scsa.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 支付
 * @Author: SCSA
 * @Date: 2020/7/31 21:43
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    /**
     * 创建支付
     * @param orderId
     * @param returnUrl
     * @param map
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) throws UnsupportedEncodingException {
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }

        //2. 发起支付
        PayResponse payResponse = payService.create(orderDTO);

        //给前端传递参数
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl.startsWith("http://") ? returnUrl : URLEncoder.encode(returnUrl, "utf-8"));

        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {

        payService.notify(notifyData);

        //返回给微信处理的结果，不要持续给我发异步通知
        //使用模板
        return new ModelAndView("/pay/success");
    }
}
