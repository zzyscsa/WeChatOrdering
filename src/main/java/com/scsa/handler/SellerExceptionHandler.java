package com.scsa.handler;

import com.scsa.VO.ResultVo;
import com.scsa.config.ProjectUrlConfig;
import com.scsa.exception.ResponseBankException;
import com.scsa.exception.SellAuthorizeException;
import com.scsa.exception.SellException;
import com.scsa.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @ExceptionHandler(value = SellException.class)
    @ResponseBody //返回json格式
    public ResultVo handlerSellException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    /** 假如有异常需要返回特定的http状态码 */
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException() {

    }

}
