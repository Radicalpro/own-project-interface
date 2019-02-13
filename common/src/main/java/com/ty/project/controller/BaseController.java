package com.ty.project.controller;

import com.ty.constants.SysConstants;
import com.ty.project.exception.MyException;
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
}
