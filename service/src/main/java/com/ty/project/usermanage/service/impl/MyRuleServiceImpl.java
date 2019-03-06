package com.ty.project.usermanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ty.constants.SysConstants;
import com.ty.project.exception.MyException;
import com.ty.project.usermanage.converter.dto.RuleAddDTO;
import com.ty.project.usermanage.converter.enums.RuleTypeEnum;
import com.ty.project.usermanage.entity.MyRuleEntity;
import com.ty.project.usermanage.mapper.MyRuleMapper;
import com.ty.project.usermanage.service.IMyRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author tianyi
 * @since 2019-03-04
 */
@Service
public class MyRuleServiceImpl extends ServiceImpl<MyRuleMapper, MyRuleEntity> implements IMyRuleService {

    @Resource
    private MyRuleMapper ruleMapper;

    @Override
    public void add(RuleAddDTO ruleAddDTO, String userName) {
        //判断pid的正确性
        if (!SysConstants.INTEGER_ZORE.equals(ruleAddDTO.getPid())) {
            if (ruleMapper.selectCount(new QueryWrapper<MyRuleEntity>().lambda().eq(MyRuleEntity::getId, ruleAddDTO.getPid())) == 0) {
                throw new MyException(SysConstants.ERROR_CODE, "父节点错误");
            }
        }
        //判断ruleType
        if(RuleTypeEnum.valueOf(ruleAddDTO.getRuleType()).equals(RuleTypeEnum.ERROR)){
            throw new MyException(SysConstants.ERROR_CODE, "角色类型错误");
        }
        ruleMapper.insert(MyRuleEntity.builder()
                .ruleName(ruleAddDTO.getRuleName())
                .ruleType(ruleAddDTO.getRuleType())
                .ruleDetail(ruleAddDTO.getRuleDetail())
                .pid(ruleAddDTO.getPid())
                .addUid(userName)
                .build());
    }
}
