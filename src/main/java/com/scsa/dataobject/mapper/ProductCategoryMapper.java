package com.scsa.dataobject.mapper;

import com.scsa.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 使用Mybatis注解操作数据库
 * @Author: SCSA
 * @Date: 2020/8/5 23:14
 */
public interface ProductCategoryMapper {

    /**
     * 插入数据
     */
    @Insert("insert into product_category(category_name, category_type) " +
                "values (#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name, category_type) " +
            "values (#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory); //sql语句对应对象里面的字段


    /**
     * 查询数据
     */
    @Select("select * from product_category where category_type = #{categoryType}")
    //查出来返回的结果数据库字段映射实体类
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
    })
    ProductCategory findByCategoryType(Integer categoryType);


    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_name", property = "categoryName"),
    })
    List<ProductCategory> findByCategoryName(String categoryName); //结果有多条记录，返回list集合


    /**
     * 更新数据
     */
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    //多个参数传递加@Param注解
    int updateByCategoryType(@Param("categoryName") String categoryName, @Param("categoryType") Integer categoryType);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryObject(ProductCategory productCategory);


    /**
     * 删除数据
     */
    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);



    ProductCategory  selectByCategoryType(Integer categoryType);

}
