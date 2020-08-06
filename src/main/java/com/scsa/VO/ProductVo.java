package com.scsa.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * @Author: SCSA
 * @Date: 2020/7/28 22:16
 */
@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID = 2242702293664627371L;

    @JsonProperty("name") //序列化返回给前端的名字
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
