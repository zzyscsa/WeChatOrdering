package com.scsa.config;

import com.lly835.bestpay.config.WxPayH5Config;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 支付配置
 * @Author: SCSA
 * @Date: 2020/7/31 21:55
 */
@Component
public class WechatPayConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    //运行的时候就会自动注入BestPayServiceImpl类的属性，全局唯一的实例
    @Bean
    public BestPayServiceImpl bestPayService() {
        WxPayH5Config wxPayH5Config = new WxPayH5Config();
        wxPayH5Config.setAppId(accountConfig.getMpAppId());
        wxPayH5Config.setAppSecret(accountConfig.getMpAppSecret());
        wxPayH5Config.setKeyPath(accountConfig.getKeyPath());
        wxPayH5Config.setMchId(accountConfig.getMchId());
        wxPayH5Config.setMchKey(accountConfig.getMchKey());
        wxPayH5Config.setNotifyUrl(accountConfig.getNotifyUrl());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayH5Config(wxPayH5Config);
        return bestPayService;
    }

//    WxPayH5Config也在Bean空间中，但是实例没有属性
//    @Bean
//    public WxPayH5Config wxPayH5Config() {
//        WxPayH5Config wxPayH5Config = new WxPayH5Config();
//
//        return wxPayH5Config;
//    }

}
