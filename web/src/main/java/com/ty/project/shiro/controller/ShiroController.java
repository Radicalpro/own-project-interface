package com.ty.project.shiro.controller;

import com.ty.constants.SysConstants;
import com.ty.project.response.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * shiro 公共控制类
 *
 * @author tianyi
 * @since 2019-02-12
 */
@RestController
@RequestMapping("/shiro")
public class ShiroController {

    @GetMapping(value = "/unLogin")
    public CommonResponse<Object> unLogin() {
        return new CommonResponse<>(SysConstants.ERROR_CODE, "请登录", null);
    }

    @GetMapping(value = "/unAuth")
    public CommonResponse<Object> unAuth() {
        return new CommonResponse<>(SysConstants.ERROR_CODE, "没权限", null);
    }

}
