package com.aloneness.spring.cloud.alibaba.sso.domain;

import com.aloneness.well.mybatis.plus.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 
 * @author aloneness
 * @date 2020/7/3
 */
@Getter
@Setter
@ToString
@Builder
@TableName(value = "t_sys_user")
public class SysUser extends BaseEntity implements Serializable {
    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 登录账号
     */
    @TableField(value = "USER_CODE")
    private String userCode;

    /**
     * 密码
     */
    @TableField(value = "PASSWORD")
    private String password;

    /**
     * 用户名
     */
    @TableField(value = "USER_NAME")
    private String userName;

    /**
     * 手机号码
     */
    @TableField(value = "PHONE")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "EMAIL")
    private String email;
}