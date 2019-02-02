package com.ty.test;


import com.ty.commonclass.BaseController;
import com.ty.commonclass.CommonResponse;
import com.ty.test.entity.TestUser;
import com.ty.test.service.ITestUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 测试数据库 前端控制器
 * </p>
 *
 * @author tianyi
 * @since 2019-02-02
 */
@RestController
@RequestMapping("/test/test-user")
public class TestUserController extends BaseController {

    @Resource
    private ITestUserService testUserService;

    @RequestMapping(value = "/getAllList", method = RequestMethod.GET)
    public CommonResponse<List<TestUser>> getAllList() {
        return new CommonResponse<>(0, "成功", testUserService.list());
    }

}
