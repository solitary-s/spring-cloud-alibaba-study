package com.aloneness.spring.cloud.alibaba.sso.mapper;

import com.aloneness.spring.cloud.alibaba.sso.domain.SysUser;
import com.aloneness.spring.cloud.alibaba.sso.domain.SysUserExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author aloneness
 * @date 2020/7/3
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    List<SysUser> selectByExample(SysUserExample example);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateBatch(List<SysUser> list);

    int batchInsert(@Param("list") List<SysUser> list);
}