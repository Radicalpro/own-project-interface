package com.ty.project.user.controller;


import com.ty.constants.SysConstants;
import com.ty.project.response.CommonResponse;
import com.ty.project.controller.BaseController;
import com.ty.project.user.entity.MyUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表 前端控制器
 *
 * @author tianyi
 * @since 2019-02-12
 */
@RestController
@RequestMapping("/user")
public class MyUserController extends BaseController {



    @GetMapping(value = "/login")
    public CommonResponse<String> login(MyUserEntity myUserEntity) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(myUserEntity.getUserName(), myUserEntity.getPassword());
        subject.login(token);
        return new CommonResponse<>(SysConstants.SUCCESS_CODE, SysConstants.SUCCESS_STRING, subject.getSession().getId().toString());
    }
}
