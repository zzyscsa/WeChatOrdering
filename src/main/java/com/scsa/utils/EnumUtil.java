package com.scsa.utils;

import com.scsa.enums.CodeEnum;

/**
 * @Author: SCSA
 * @Date: 2020/8/1 23:20
 */
public class EnumUtil {

    /**
     * 根据code返回枚举
     * 这里约定实现CodeEnum接口的类才能使用getByCode方法！使用这个方法必须有code属性
     * @param code
     * @param enumClass 枚举类型
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) { //这个getCode是CodeEnum接口的方法
                return each;
            }
        }
        return null;
    }
}