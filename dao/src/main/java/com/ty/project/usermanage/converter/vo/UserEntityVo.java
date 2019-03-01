package com.ty.project.usermanage.converter.vo;

import lombok.Data;

/**
 * 用户表Vo
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Data
public class UserEntityVo {

    /**
     * 用户id主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 0:正常 1:冻结
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 角色名
     */
    private String roleName;

}
