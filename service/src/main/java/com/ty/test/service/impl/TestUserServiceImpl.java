package com.ty.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ty.test.entity.TestUser;
import com.ty.test.mapper.TestUserMapper;
import com.ty.test.service.ITestUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试数据库 服务实现类
 * </p>
 *
 * @author tianyi
 * @since 2019-02-02
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {

}
