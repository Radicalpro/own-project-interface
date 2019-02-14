package com.ty.project.user.converter.dto;

import lombok.Data;

/**
 * 用户登录dto
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Data
public class UserLoginDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

}
