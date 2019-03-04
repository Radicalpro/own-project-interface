package com.ty.project.usermanage.converter.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册dto
 *
 * @author tianyi
 * @since 2019-02-13
 */
@Data
public class RoleAddDTO {

    /**
     * 角色名
     */
    @NotBlank(message = "角色名不为空")
    private String roleName;

    /**
     * 备注
     */
    private String remark;

}
