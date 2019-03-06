package com.ty.project.usermanage.converter.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * 新增权限dto
 *
 * @author tianyi
 * @since 2019-03-06
 */
@Data
public class RuleAddDTO {

    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称不为空")
    private String ruleName;

    /**
     * 权限地址
     */
    @NotBlank(message = "权限地址不为空")
    private String ruleDetail;

    /**
     * 1: 菜单 2: 面包学 3: 权限
     */
    @NotEmpty(message = "权限类型不为空")
    private Integer ruleType;

    /**
     * 父id
     */
    @NotEmpty(message = "父权限不为空")
    private Integer pid;

}
