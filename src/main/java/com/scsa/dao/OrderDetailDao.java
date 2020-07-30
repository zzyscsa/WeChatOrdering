package com.scsa.dao;

import com.scsa.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/7/29 18:32
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> { //类型、主键类型

    List<OrderDetail> findByOrderId(String orderId);
}
