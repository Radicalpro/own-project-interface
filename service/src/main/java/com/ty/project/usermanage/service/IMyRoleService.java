package com.ty.project.usermanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ty.project.usermanage.converter.dto.RoleAddDTO;
import com.ty.project.usermanage.entity.MyRoleEntity;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author tianyi
 * @since 2019-03-01
 */
public interface IMyRoleService extends IService<MyRoleEntity> {

    /**
     * 新增
     *
     * @param roleAddDTO 新增角色dto
     * @param userName   操作人
     */
    void add(RoleAddDTO roleAddDTO, String userName);
}
