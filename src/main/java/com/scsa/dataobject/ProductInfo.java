package com.scsa.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品
 * @Author: SCSA
 * @Date: 2020/7/28 21:01
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

    @Id
    private String productId;

    /* 名字 */
    private String productName;

    /* 单价 */
    private BigDecimal productPrice;

    /* 库存 */
    private Integer productStock;

    /* 描述 */
    private String productDescription;

    /* 小图地址 */
    private String productIcon;

    /* 状态：0正常1下加 */
    private Integer productStatus;

    /* 类目编号 */
    private Integer categoryType;
}
