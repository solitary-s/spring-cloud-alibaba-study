package com.aloneness.spring.cloud.alibaba.sso.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aloneness.spring.cloud.alibaba.sso.mapper.SysUserMapper;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUser;
import com.aloneness.spring.cloud.alibaba.sso.service.ISysUserService;
/**
 * 
 * 
 * @author aloneness
 * @date 2020/7/3
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
