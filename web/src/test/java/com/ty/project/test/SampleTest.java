package com.ty.project.test;

import com.ty.PlatformApplication;
import com.ty.project.test.entity.TestUser;
import com.ty.project.test.mapper.TestUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PlatformApplication.class})
public class SampleTest {

    @Resource
    private TestUserMapper testUserMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<TestUser> userList = testUserMapper.selectList(null);
        Assert.assertEquals(4, userList.size());
        userList.forEach(System.out::println);
    }
}
