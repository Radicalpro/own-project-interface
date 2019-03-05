package com.ty.project.usermanage.converter.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 角色权限更新dto
 *
 * @author tianyi
 * @since 2019-03-05
 */
@Data
public class RoleRuleUpdateDTO {

    /**
     * 角色id集合
     */
    List<Integer> roleIds;

    /**
     * 角色id
     */
    @NotNull(message = "角色信息错误")
    Integer id;
}
