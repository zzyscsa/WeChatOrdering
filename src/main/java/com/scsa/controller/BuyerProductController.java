package com.scsa.controller;

import com.scsa.VO.ProductInfoVO;
import com.scsa.VO.ProductVo;
import com.scsa.VO.ResultVo;
import com.scsa.dataobject.ProductCategory;
import com.scsa.dataobject.ProductInfo;
import com.scsa.service.CategoryService;
import com.scsa.service.ProductService;
import com.scsa.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @Author: SCSA
 * @Date: 2020/7/28 22:04
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
//    //假如传入参数sellerId，只有在sellerId 长度大于3 且 结果不为0才进行缓存
//    @Cacheable(cacheNames = "product", key = "#sellerId", condition = "#sellerId.length() > 3", unless = "#result.getCode()!=0")
    @Cacheable(cacheNames = "product", key = "123") //加入缓存
    public ResultVo list() {
        // 1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for(ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 查出数据后进行数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    /*把一个对象的值拷贝到另一个对象*/
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVo.setProductInfoVOList(productInfoVOList);
            productVoList.add(productVo);
        }



        return ResultVOUtil.success(productVoList);
    }

}
