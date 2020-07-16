package com.aloneness.spring.cloud.alibaba.service.admin.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.aloneness.well.framework.enums.ErrorCodeEnum;
import com.aloneness.well.framework.exception.assertException.ApiAssert;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *拦截器
 */
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (StrUtil.isEmpty(token)) {
            ApiAssert.failure(ErrorCodeEnum.UNAUTHORIZED.convert("请携带token"));
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String token = request.getHeader("Authorization");
        Object attribute = request.getSession().getAttribute(token);
        if (ObjectUtil.isNull(attribute)) {
            ApiAssert.failure(ErrorCodeEnum.UNAUTHORIZED.convert("token失效"));
        }
    }
}
