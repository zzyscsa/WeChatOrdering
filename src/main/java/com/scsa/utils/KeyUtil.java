package com.scsa.utils;

import java.util.Random;

/**
 * @Author: SCSA
 * @Date: 2020/7/29 21:09
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        /** 生成6位随机数 */
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
