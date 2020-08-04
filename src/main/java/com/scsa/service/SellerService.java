package com.scsa.service;

import com.scsa.dataobject.SellerInfo;

/**
 * 卖家端
 * @Author: SCSA
 * @Date: 2020/8/4 17:32
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
