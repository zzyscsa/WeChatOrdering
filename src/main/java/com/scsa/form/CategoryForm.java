package com.scsa.form;

import lombok.Data;


/**
 * 类目表单
 * @Author: SCSA
 * @Date: 2020/8/3 22:39
 */
@Data
public class CategoryForm {

    /** 类目id */
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;
}
