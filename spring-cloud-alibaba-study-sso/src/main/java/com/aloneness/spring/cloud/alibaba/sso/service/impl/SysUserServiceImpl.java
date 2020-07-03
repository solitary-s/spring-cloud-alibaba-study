package com.aloneness.spring.cloud.alibaba.sso.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.aloneness.spring.cloud.alibaba.sso.mapper.SysUserMapper;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUser;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUserExample;
import com.aloneness.spring.cloud.alibaba.sso.service.SysUserService;
/**
 * 
 * 
 * @author aloneness
 * @date 2020/7/3
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Override
    public long countByExample(SysUserExample example) {
        return baseMapper.countByExample(example);
    }
    @Override
    public int deleteByExample(SysUserExample example) {
        return baseMapper.deleteByExample(example);
    }
    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return baseMapper.selectByExample(example);
    }
    @Override
    public int updateByExampleSelective(SysUser record,SysUserExample example) {
        return baseMapper.updateByExampleSelective(record,example);
    }
    @Override
    public int updateByExample(SysUser record,SysUserExample example) {
        return baseMapper.updateByExample(record,example);
    }
    @Override
    public int updateBatch(List<SysUser> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<SysUser> list) {
        return baseMapper.batchInsert(list);
    }
}
