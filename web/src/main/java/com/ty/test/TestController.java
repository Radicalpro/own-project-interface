package com.ty.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 *
 * @author tianyi
 * @date 2019-01-22
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试1
     *
     * @return name
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        return "ty";
    }
}
