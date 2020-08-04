package com.scsa.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 * @Author: SCSA
 * @Date: 2020/8/4 19:05
 */
public class CookieUtil {

    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(7200);
        response.addCookie(cookie);
    }

    public static void get() {

    }
}
