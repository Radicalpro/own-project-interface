package com.ty.project.controller;

import com.ty.constants.SysConstants;
import com.ty.project.exception.MyException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * 公共Controller
 *
 * @author tianyi
 * @since 2019-02-02
 */
public class BaseController {

    /**
     * 参数校验方法
     *
     * @param result 校验结果
     */
    protected void checkValidResult(BindingResult result) {
        if (result != null && result.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errorMsg.append(error.getDefaultMessage());
            }
            throw new MyException(SysConstants.ERROR_CODE, errorMsg.toString());
        }
    }

    /**
     * 获取当前用户人信息
     *
     * @return userName
     */
    protected String getUserName(){
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotEmpty(userName)){
            return userName;
        }else {
            return "system";
        }
    }
}
