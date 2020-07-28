package com.scsa.dao;

import com.scsa.dataobject.ProductCategory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/7/28 18:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest extends TestCase {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest() {
        ProductCategory one = productCategoryDao.findOne(1);
        System.out.println(one);
    }

    @Test
    @Transactional //不把测试数据留在数据库中，完全回滚
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> byCategoryTypeIn = productCategoryDao.findByCategoryTypeIn(list);
        /*结果不为空就是查询成功*/
        Assert.assertNotEquals(0, byCategoryTypeIn.size());
    }

}