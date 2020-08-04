package com.scsa.service.impl;

import com.scsa.dataobject.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: SCSA
 * @Date: 2020/8/4 17:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SellerServiceImplTest {

    private static final String openid = "abc";

    @Autowired
    private SellerServiceImpl sellerService;


    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid, sellerInfo.getOpenid());
    }
}