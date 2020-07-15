package com.aloneness.spring.cloud.alibaba.sso.interceptor;

import cn.hutool.core.util.StrUtil;
import com.aloneness.spring.cloud.alibaba.sso.util.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = CookieUtil.getCookieValue(request, "Authorization");
        if (StrUtil.isEmpty(authorization)) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
