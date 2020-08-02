package com.scsa.enums;

/**
 * 这个接口用于约定，约定实现这个接口的类才能使用EnumUtil工具类
 * @Author: SCSA
 * @Date: 2020/8/1 23:18
 */
public interface CodeEnum<T> {
    T getCode(); //枚举类中的@Getter就整合了getCode方法了,说明枚举类有code属性
}
