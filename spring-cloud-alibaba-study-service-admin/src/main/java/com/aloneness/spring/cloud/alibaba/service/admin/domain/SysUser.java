package com.aloneness.spring.cloud.alibaba.service.admin.domain;

import com.aloneness.well.mybatis.plus.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 
 * 
 * @author aloneness
 * @date 2020/7/3
 */
@Getter
@Setter
@ToString
public class SysUser extends BaseEntity implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 登录账号
     */
    private String userCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}