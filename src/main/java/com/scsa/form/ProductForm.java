package com.scsa.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表单
 * @Author: SCSA
 * @Date: 2020/8/3 21:52
 */
@Data
public class ProductForm {

    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图地址 */
    private String productIcon;

    /** 类目编号 */
    private Integer categoryType;


}
