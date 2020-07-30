package com.scsa.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 订单表单验证
 * @Author: SCSA
 * @Date: 2020/7/30 18:15
 */
@Data
public class OrderForm {

    /** 买家姓名，加入表单验证注解 */
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /** 买家手机号 */
    @NotEmpty(message = "手机号不能为空")
    private String phone;

    /** 买家地址 */
    @NotEmpty(message = "地址不能为空")
    private String address;

    /** 买家Openid */
    @NotEmpty(message = "openid不能为空")
    private String openid;

    /** 购物车 */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
