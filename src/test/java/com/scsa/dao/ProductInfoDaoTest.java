package com.scsa.dao;

import com.scsa.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: SCSA
 * @Date: 2020/7/28 21:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo("123456","烤鸭",new BigDecimal(80),
                100, "很好吃的烤鸭",
                "http://xxxxx.jpg", 0, 3);

        productInfoDao.save(productInfo);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> byProductStatus = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0, byProductStatus.size());
    }
}