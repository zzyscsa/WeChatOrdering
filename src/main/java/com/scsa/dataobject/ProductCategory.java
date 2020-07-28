package com.scsa.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * @Author: SCSA
 * @Date: 2020/7/28 18:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate //自动填入当前更新时间，如果需要的话
public class ProductCategory {
    /* 类目id */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /* 类目名字 */
    private String categoryName;
    /* 类目编号 */
    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
