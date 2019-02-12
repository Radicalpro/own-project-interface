package com.ty.config.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * 测试权限登录类
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Data
public class UserInfo implements Serializable {

    private Integer id;

    private String userName;

    private String password;

}
