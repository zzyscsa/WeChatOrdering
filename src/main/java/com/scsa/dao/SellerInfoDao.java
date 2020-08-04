package com.scsa.dao;

import com.scsa.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: SCSA
 * @Date: 2020/8/4 17:28
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
