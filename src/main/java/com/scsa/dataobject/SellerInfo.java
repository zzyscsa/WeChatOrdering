package com.scsa.dataobject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 卖家信息
 * @Author: SCSA
 * @Date: 2020/8/4 17:25
 */
@Data
@Entity
@NoArgsConstructor
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
