package com.ty.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ty.user.entity.MyUserEntity;
import com.ty.user.mapper.MyUserMapper;
import com.ty.user.service.IMyUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUserEntity> implements IMyUserService {

}
