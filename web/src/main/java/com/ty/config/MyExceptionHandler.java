package com.ty.config;

import com.ty.project.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.ty"}, annotations = Controller.class)
public class MyExceptionHandler {

    /**
     * 未认证异常
     *
     * @return 异常响应
     */
    @ExceptionHandler(value = UnauthenticatedException.class)
    public CommonResponse<String> handleUnAuthorizationException() {
        return new CommonResponse<>(0, "", "您未登录");
    }

    /**
     * 未授权异常
     *
     * @return 异常响应
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public CommonResponse<String> handleAuthorizationException() {
        return new CommonResponse<>(0, "", "您没权限");
    }
}
