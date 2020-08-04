package com.scsa.aspect;

import com.scsa.constant.CookieConstant;
import com.scsa.constant.RedisConstant;
import com.scsa.exception.SellAuthorizeException;
import com.scsa.exception.SellException;
import com.scsa.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 卖家身份验证
 * @Author: SCSA
 * @Date: 2020/8/4 23:11
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //execution([可见性] 返回类型 [声明类型].方法名(参数) [异常])
    //以Seller开头的controller中的所有方法，方法参数任意，并且排除登录登出操作的controller
    @Pointcut("execution(public * com.scsa.controller.Seller*.*(..))" +
              "&& !execution(public * com.scsa.controller.SellerUserController.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() {
        //获取http的request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellAuthorizeException();
        }

        //查询redis
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellAuthorizeException();
        }

    }


}
