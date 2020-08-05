package com.scsa.service.impl;

import com.scsa.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: SCSA
 * @Date: 2020/8/5 15:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1596367922699858448");
        pushMessageService.orderStatus(orderDTO);
    }
}