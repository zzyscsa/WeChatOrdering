package com.scsa.service.impl;

import com.scsa.dto.OrderDTO;
import com.scsa.service.OrderService;
import com.scsa.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: SCSA
 * @Date: 2020/7/31 22:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1596107382518382695");
        payService.create(orderDTO);
    }
}