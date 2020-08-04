package com.scsa.handler;

import com.scsa.config.ProjectUrlConfig;
import com.scsa.exception.SellAuthorizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常捕获
 * @Author: SCSA
 * @Date: 2020/8/4 23:31
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http://sell.springboot.cn/sell/qr/oTgZpwYZvIiYcMAZ7rdLbSqKBR-Q&response_type=code&scope=snsapi_login&state=http://mrscsa.natapp1.cc/sell/wechat/qrUserInfo
    @ExceptionHandler(value = SellAuthorizeException.class)
    public ModelAndView handlerSellerAuthorizeException() {
        return new ModelAndView("redirect:"+"https://open.weixin.qq.com/connect/qrconnect?appid=wx6ad144e54af67d87&redirect_uri=http://sell.springboot.cn/sell/qr/oTgZpwYZvIiYcMAZ7rdLbSqKBR-Q&response_type=code&scope=snsapi_login&state=http://mrscsa.natapp1.cc/sell/wechat/qrUserInfo");
    }

}
