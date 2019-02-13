package com.ty.common.handle;

import com.ty.constants.SysConstants;
import com.ty.project.exception.MyException;
import com.ty.project.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
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
     * defaultExceptionHandler
     *
     * @param ex 捕获异常
     * @return 异常响应
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse<String> defaultExceptionHandler(Exception ex) {
        log.error(ExceptionUtils.getStackTrace(ex));
        return new CommonResponse<>(getErrorCode(ex), getErrorMsg(ex), null);
    }

    /**
     * 未认证异常
     *
     * @return 异常响应
     */
    @ExceptionHandler(value = UnauthenticatedException.class)
    public CommonResponse<String> handleUnAuthorizationException() {
        return new CommonResponse<>(SysConstants.ERROR_CODE, "您未登录", null);
    }

    /**
     * 未授权异常
     *
     * @return 异常响应
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public CommonResponse<String> handleAuthorizationException() {
        return new CommonResponse<>(SysConstants.ERROR_CODE, "您没权限", null);
    }

    /**
     * 验证错误异常
     *
     * @return 异常响应
     */
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public CommonResponse<String> handleIncorrectCredentialsException() {
        return new CommonResponse<>(SysConstants.ERROR_CODE, "用户名密码错误", null);
    }

    /**
     * 账户状态异常
     *
     * @return 异常响应
     */
    @ExceptionHandler(value = LockedAccountException.class)
    public CommonResponse<String> handleLockedAccountException() {
        return new CommonResponse<>(SysConstants.ERROR_CODE, "账户状态错误", null);
    }

    /**
     * 获取异常code
     *
     * @param ex 捕获异常
     * @return 异常code
     */
    private Integer getErrorCode(Exception ex) {
        Integer code = SysConstants.ERROR_CODE;
        if (ex instanceof MyException) {
            code = ((MyException) ex).getCode();
        }
        return code;
    }

    /**
     * 获取异常message
     *
     * @param ex 捕获异常
     * @return 异常message
     */
    private String getErrorMsg(Exception ex) {
        return StringUtils.defaultIfBlank(ex.getMessage(), SysConstants.ERROR_STRING);
    }

}
