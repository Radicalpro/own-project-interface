package com.ty.project.usermanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ty.project.usermanage.converter.dto.UserPageListDTO;
import com.ty.project.usermanage.converter.dto.UserRegisterDTO;
import com.ty.project.usermanage.converter.vo.UserEntityVo;
import com.ty.project.usermanage.entity.MyUserEntity;

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
     * @param userName        用户名
     */
    void register(UserRegisterDTO userRegisterDTO, String userName);

    /**
     * 分页多表查询
     *
     * @param page            分页类
     * @param userPageListDTO 其他参数
     * @return 数据集合
     */
    IPage<UserEntityVo> selectPageVo(Page<UserEntityVo> page, UserPageListDTO userPageListDTO);
}
