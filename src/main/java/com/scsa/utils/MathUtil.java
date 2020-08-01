package com.scsa.utils;

/**
 * @Author: SCSA
 * @Date: 2020/8/1 16:35
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较2个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if(result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
