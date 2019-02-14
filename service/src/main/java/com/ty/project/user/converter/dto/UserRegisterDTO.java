package com.ty.project.user.converter.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册dto
 *
 * @author tianyi
 * @since 2019-02-13
 */
@Data
public class UserRegisterDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不为空")
    private String password;

}
