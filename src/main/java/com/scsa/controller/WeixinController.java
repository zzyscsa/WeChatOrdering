package com.scsa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: SCSA
 * @Date: 2020/7/31 17:23
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        //获取code
        log.info("code={}", code);
        //通过code访问这个地址获取网页授权access_token，access_token里就有openid
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxcb29648d6ad1f58f&secret=1b65a3ef0da65e61e13c5ddf0e3681ef&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}
