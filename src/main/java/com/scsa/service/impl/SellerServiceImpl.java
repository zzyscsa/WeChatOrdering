package com.scsa.service.impl;

import com.scsa.dao.SellerInfoDao;
import com.scsa.dataobject.SellerInfo;
import com.scsa.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: SCSA
 * @Date: 2020/8/4 17:34
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}
