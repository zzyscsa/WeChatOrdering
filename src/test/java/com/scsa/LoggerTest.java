package com.scsa;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: SCSA
 * @Date: 2020/7/27 23:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class); //要写当前类，也可使用注解

    @Test
    public void test1() {
        logger.debug("debug..."); //不输出
        logger.info("info..."); //info是默认级别，在其之上的都输出
        logger.error("error..."); //输出
    }

    @Test
    public void test2() {
        String name = "scsa";
        String password = "123456";
        log.debug("debug...");
        log.info("name: {}, password: {}", name, password); //输出变量
        log.error("error...");
    }
}
