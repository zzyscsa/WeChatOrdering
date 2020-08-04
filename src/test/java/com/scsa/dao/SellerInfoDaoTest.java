package com.scsa.dao;

import com.scsa.dataobject.SellerInfo;
import com.scsa.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: SCSA
 * @Date: 2020/8/4 17:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = sellerInfoDao.findByOpenid("abc");
        Assert.assertEquals("abc", sellerInfo.getOpenid());
    }

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        SellerInfo info = sellerInfoDao.save(sellerInfo);
        Assert.assertNotNull(info);
    }
}