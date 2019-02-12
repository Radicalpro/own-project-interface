package com.ty;

import com.ty.constants.SysConstants;
import com.ty.project.CommonResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot 启动类
 *
 * @author tianyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResponse<String> login(String userName, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        subject.login(token);
        return new CommonResponse<>(SysConstants.SUCCESS_CODE, SysConstants.SUCCESS_STRING, subject.getSession().getId().toString());
    }

    @RequestMapping(value = "/unLogin", method = RequestMethod.GET)
    public CommonResponse<Object> unLogin() {
        return new CommonResponse<>(SysConstants.FAIL_CODE, "请登录", null);
    }

    @RequestMapping(value = "/unAuth", method = RequestMethod.GET)
    public CommonResponse<Object> unAuth() {
        return new CommonResponse<>(SysConstants.FAIL_CODE, "没权限", null);
    }

}

