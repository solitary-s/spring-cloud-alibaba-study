package com.aloneness.spring.cloud.alibaba.sso.service;

import com.aloneness.spring.cloud.alibaba.sso.domain.SysUser;

public interface LoginService {

    /**
     * 登录
     *
     * @param loginCode
     * @param password
     * @return
     */
    public SysUser login(String loginCode, String password);
}
