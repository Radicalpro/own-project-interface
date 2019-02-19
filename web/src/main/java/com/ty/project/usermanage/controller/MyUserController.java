package com.ty.project.usermanage.controller;


import com.ty.constants.SysConstants;
import com.ty.project.controller.BaseController;
import com.ty.project.response.CommonResponse;
import com.ty.project.usermanage.converter.dto.UserLoginDTO;
import com.ty.project.usermanage.converter.dto.UserRegisterDTO;
import com.ty.project.usermanage.service.IMyUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户表 前端控制器
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class MyUserController extends BaseController {

    @Resource
    private IMyUserService myUserService;

    @PostMapping(value = "/login")
    public CommonResponse<String> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userLoginDTO.getUserName(), userLoginDTO.getPassword());
        subject.login(token);
        return new CommonResponse<>(SysConstants.SUCCESS_CODE, SysConstants.SUCCESS_STRING, subject.getSession().getId().toString());
    }

    /**
     * 注册新用户
     *
     * @param userRegisterDTO 注册dto
     * @param bindingResult   参数校验类
     * @return CommonResponse
     */
    @PostMapping(value = "/register")
    public CommonResponse<String> regiseter(@Valid @RequestBody UserRegisterDTO userRegisterDTO, BindingResult bindingResult) {
        checkValidResult(bindingResult);
        myUserService.register(userRegisterDTO);
        return new CommonResponse<>(SysConstants.SUCCESS_CODE, SysConstants.SUCCESS_STRING, "");
    }
}
