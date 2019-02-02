package com.ty.test;


import com.ty.superclass.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
