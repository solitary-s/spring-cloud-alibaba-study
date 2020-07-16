package com.aloneness.spring.cloud.alibaba.service.admin.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.aloneness.spring.cloud.alibaba.service.admin.domain.SysUser;
import com.aloneness.spring.cloud.alibaba.service.admin.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/login")
    @ResponseBody
    public SysUser login(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (StrUtil.isEmpty(authorization)) {
            return null;
        }

        String loginCode = redisService.get(authorization);
        if (StrUtil.isEmpty(loginCode)) {
            return null;
        }

        String userJson = redisService.get(loginCode);
        if (StrUtil.isEmpty(userJson)) {
            return null;
        }

        SysUser sysUser = JSONUtil.toBean(userJson, SysUser.class);
        if (ObjectUtil.isNotNull(sysUser)) {
            request.getSession().setAttribute(authorization, sysUser);
            return sysUser;
        }
        return null;
    }
}
