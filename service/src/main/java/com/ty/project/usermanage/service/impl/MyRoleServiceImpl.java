package com.ty.project.usermanage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ty.constants.SysConstants;
import com.ty.project.exception.MyException;
import com.ty.project.usermanage.converter.dto.RoleAddDTO;
import com.ty.project.usermanage.converter.dto.RoleRuleUpdateDTO;
import com.ty.project.usermanage.converter.enums.RuleTypeEnum;
import com.ty.project.usermanage.entity.MyRoleEntity;
import com.ty.project.usermanage.entity.MyRuleEntity;
import com.ty.project.usermanage.mapper.MyRoleMapper;
import com.ty.project.usermanage.mapper.MyRuleMapper;
import com.ty.project.usermanage.service.IMyRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author tianyi
 * @since 2019-03-01
 */
@Service
public class MyRoleServiceImpl extends ServiceImpl<MyRoleMapper, MyRoleEntity> implements IMyRoleService {

    @Resource
    private MyRoleMapper myRoleMapper;

    @Resource
    private MyRuleMapper myRuleMapper;

    @Override
    public void add(RoleAddDTO roleAddDTO, String userName) {
        // 检查角色是否存在
        if (myRoleMapper.selectCount(new QueryWrapper<MyRoleEntity>().lambda().eq(MyRoleEntity::getRoleName, roleAddDTO.getRoleName())) > 0) {
            throw new MyException(SysConstants.ERROR_CODE, "角色名已存在");
        }
        myRoleMapper.insert(MyRoleEntity.builder()
                .roleName(roleAddDTO.getRoleName())
                .remark(roleAddDTO.getRemark())
                .addUid(userName)
                .build());
    }

    @Override
    public void updateRoleRule(RoleRuleUpdateDTO roleRuleUpdateDTO) {
        MyRoleEntity myRoleEntity = myRoleMapper.selectById(roleRuleUpdateDTO.getId());
        if (myRoleEntity != null) {
            if (CollectionUtils.isEmpty(roleRuleUpdateDTO.getRoleIds())) {
                myRoleEntity.setRoleRule("");
            } else {
                List<MyRuleEntity> myRuleEntityList = myRuleMapper.selectList(new QueryWrapper<MyRuleEntity>().lambda()
                        .eq(MyRuleEntity::getRuleType, RuleTypeEnum.CRUMBS)
                        .in(MyRuleEntity::getId, roleRuleUpdateDTO.getRoleIds()));
                myRoleEntity.setRoleRule(JSONObject.toJSONString(
                        myRuleEntityList.parallelStream().map(MyRuleEntity::getRuleDetail).collect(Collectors.toList()))
                );
            }
            myRoleMapper.updateById(myRoleEntity);
        } else {
            throw new MyException(SysConstants.ERROR_CODE, "角色信息错误");
        }
    }
}
