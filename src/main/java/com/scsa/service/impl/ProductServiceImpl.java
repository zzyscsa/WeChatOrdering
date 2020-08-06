package com.scsa.service.impl;

import com.scsa.dao.ProductInfoDao;
import com.scsa.dataobject.ProductInfo;
import com.scsa.dto.CartDTO;
import com.scsa.enums.ProductStatusEnum;
import com.scsa.enums.ResultEnum;
import com.scsa.exception.SellException;
import com.scsa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/7/28 21:18
 */
@Service
//@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
//    @Cacheable(key = "123456") //不写key默认是传入参数的值
    public ProductInfo findOne(String ProductId) {
        return productInfoDao.findOne(ProductId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
//    @CachePut(key = "123456")
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    /**
     * 增加库存
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if(productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            //增加库存
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }

    /**
     * 减少库存
     * @param cartDTOList
     */
    @Override
    @Transactional //事务
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            //查询购物车里每件商品
            ProductInfo productInfo = productInfoDao.findOne(cartDTO.getProductId());
            if(productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            //扣减完的结果
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //重新设置库存
            productInfo.setProductStock(result);
            //保存
            productInfoDao.save(productInfo);
        }
    }

    /**
     * 商品上架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoDao.findOne(productId);
        if(productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUES_ERROR);
        }

        //更新状态
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoDao.save(productInfo);
    }

    /**
     * 商品下架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoDao.findOne(productId);
        if(productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUES_ERROR);
        }

        //更新状态
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoDao.save(productInfo);
    }
}
