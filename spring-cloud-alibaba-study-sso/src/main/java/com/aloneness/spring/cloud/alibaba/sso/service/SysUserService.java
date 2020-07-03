package com.aloneness.spring.cloud.alibaba.sso.service;

import java.util.List;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUser;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUserExample;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * 
 * 
 * @author aloneness
 * @date 2020/7/3
 */
public interface SysUserService extends IService<SysUser>{


    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    List<SysUser> selectByExample(SysUserExample example);

    int updateByExampleSelective(SysUser record,SysUserExample example);

    int updateByExample(SysUser record,SysUserExample example);

    int updateBatch(List<SysUser> list);

    int batchInsert(List<SysUser> list);

}
