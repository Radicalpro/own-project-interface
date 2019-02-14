package com.ty.project.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ty.project.user.converter.dto.UserRegisterDTO;
import com.ty.project.user.entity.MyUserEntity;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author tianyi
 * @since 2019-02-12
 */
public interface IMyUserService extends IService<MyUserEntity> {

    /**
     * 注册新用户
     *
     * @param userRegisterDTO 入参
     */
    void register(UserRegisterDTO userRegisterDTO);
}
