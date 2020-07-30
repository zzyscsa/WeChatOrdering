package com.scsa.dao;

import com.scsa.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: SCSA
 * @Date: 2020/7/29 20:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456790");
        orderDetail.setOrderId("22222211");
        orderDetail.setProductId("1122");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductName("烤鸭");
        orderDetail.setProductPrice(new BigDecimal(79.2));
        orderDetail.setProductQuantity(3);

        OrderDetail order = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(order);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("22222211");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}