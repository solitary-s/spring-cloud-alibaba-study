package com.aloneness.spring.cloud.alibaba.sso.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUser;
import com.aloneness.spring.cloud.alibaba.sso.service.ISysUserService;
import com.aloneness.spring.cloud.alibaba.sso.service.LoginService;
import com.aloneness.spring.cloud.alibaba.sso.service.RedisService;
import com.aloneness.well.framework.enums.ErrorCodeEnum;
import com.aloneness.well.framework.exception.assertException.ApiAssert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ISysUserService userService;

    @Override
    public SysUser login(String loginCode, String password) {

        String json = redisService.get(loginCode);

        if (StrUtil.isNotEmpty(json)) {
            SysUser user = JSONUtil.toBean(json, SysUser.class);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }

        SysUser user = userService.getOne(new QueryWrapper<SysUser>().eq("USER_CODE", loginCode));

        if (ObjectUtil.isNull(user)) {
            return null;
        }

        if (user.getPassword().equals(password)) {
            // 有效期一天
            redisService.put(loginCode, JSONUtil.toJsonStr(user), 60*60*24);
            return user;
        }

        else {
            return null;
        }
    }
}
