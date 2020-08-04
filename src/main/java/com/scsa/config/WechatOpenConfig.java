package com.scsa.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 微信开放平台配置类
 * @Author: SCSA
 * @Date: 2020/8/4 17:47
 */
@Component
public class WechatOpenConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    //第三方sdk用的是同样的接口WxMpService
    @Bean
    public WxMpService wxOpenService() {
        WxMpService wxOpenService = new WxMpServiceImpl();
        wxOpenService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxOpenService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(accountConfig.getOpenAppId());
        wxMpConfigStorage.setSecret(accountConfig.getOpenAppSecret());
        return wxMpConfigStorage;
    }

}
