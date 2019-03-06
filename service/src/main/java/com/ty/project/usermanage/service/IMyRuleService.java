package com.ty.project.usermanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ty.project.usermanage.converter.dto.RuleAddDTO;
import com.ty.project.usermanage.entity.MyRuleEntity;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author tianyi
 * @since 2019-03-04
 */
public interface IMyRuleService extends IService<MyRuleEntity> {

    /**
     * 新增权限
     *
     * @param ruleAddDTO  新增权限dto
     * @param userName 操作人
     */
    void add(RuleAddDTO ruleAddDTO, String userName);
}
