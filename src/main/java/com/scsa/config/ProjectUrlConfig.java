package com.scsa.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Url配置
 * @Author: SCSA
 * @Date: 2020/8/4 18:12
 */
@Data
@Component
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrlConfig {

    /**
     *  微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统项目url
     */
    public String sell;
}
