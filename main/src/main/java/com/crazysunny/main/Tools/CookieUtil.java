package com.crazysunny.main.Tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static final int COOKTIME = 60 * 60 * 24;

    public static void AddCookie(HttpServletResponse response, String cookieName, String value)
    {
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setPath("/");
        cookie.setMaxAge(COOKTIME);
        response.addCookie(cookie);
    }

    public static void DeleteCookie(HttpServletResponse response,String cookieName)
    {
        Cookie cookie = new Cookie(cookieName,null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static String getCookieValueByName(HttpServletRequest request, String cookieName)
    {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }
}
