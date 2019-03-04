package com.ty.project.usermanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ty.constants.SysConstants;
import com.ty.project.exception.MyException;
import com.ty.project.usermanage.converter.dto.UserPageListDTO;
import com.ty.project.usermanage.converter.dto.UserRegisterDTO;
import com.ty.project.usermanage.converter.vo.UserEntityVo;
import com.ty.project.usermanage.entity.MyRoleEntity;
import com.ty.project.usermanage.entity.MyUserEntity;
import com.ty.project.usermanage.mapper.MyRoleMapper;
import com.ty.project.usermanage.mapper.MyUserMapper;
import com.ty.project.usermanage.service.IMyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.ty.constants.SysConstants.ROOT_USER;

/**
 * 用户表 服务实现类
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUserEntity> implements IMyUserService {

    @Resource
    private MyUserMapper myUserMapper;

    @Resource
    private MyRoleMapper myRoleMapper;

    @Override
    public void register(UserRegisterDTO userRegisterDTO, String userName) {
        //验证是否存在用户
        if (myUserMapper.selectCount(new QueryWrapper<MyUserEntity>().lambda().eq(MyUserEntity::getUserName, userRegisterDTO.getUserName())) > 0) {
            throw new MyException(SysConstants.ERROR_CODE, "已存在该用户");
        }
        //验证角色是否存在
        if (myRoleMapper.selectCount(new QueryWrapper<MyRoleEntity>().lambda().eq(MyRoleEntity::getId, userRegisterDTO.getRoleId())) == 0) {
            throw new MyException(SysConstants.ERROR_CODE, "该角色不存在");
        }
        myUserMapper.insert(MyUserEntity.builder()
                .userName(userRegisterDTO.getUserName())
                .password(userRegisterDTO.getPassword())
                .nickName(userRegisterDTO.getUserName())
                .roleId(userRegisterDTO.getRoleId())
                .addUid(userName).build());
    }

    @Override
    public IPage<UserEntityVo> selectPageVo(Page<UserEntityVo> page, UserPageListDTO userPageListDTO) {
        return page.setRecords(this.myUserMapper.selectPageVo(page, userPageListDTO));
    }
}
