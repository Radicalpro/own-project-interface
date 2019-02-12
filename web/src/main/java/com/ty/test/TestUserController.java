package com.ty.test;


import com.ty.constants.SysConstants;
import com.ty.project.CommonResponse;
import com.ty.project.controller.BaseController;
import com.ty.test.entity.TestUser;
import com.ty.test.service.ITestUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试数据库 前端控制器
 *
 * @author tianyi
 * @since 2019-02-02
 */
@RestController
@RequestMapping("/test")
public class TestUserController extends BaseController {

    @Resource
    private ITestUserService testUserService;

    @GetMapping(value = "/getAllList")
    @RequiresPermissions("test:read:list")
    public CommonResponse<List<TestUser>> getAllList() {
        return new CommonResponse<>(SysConstants.SUCCESS_CODE, SysConstants.SUCCESS_STRING, testUserService.list());
    }

}
