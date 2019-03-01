package com.ty.project.usermanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ty.project.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author tianyi
 * @since 2019-03-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("my_role")
public class MyRoleEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色权限
     */
    private String roleRule;

    /**
     * 0:正常 1:冻结
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加人
     */
    private String addUid;

    /**
     * 添加时间
     */
    private LocalDateTime addTime;

    /**
     * 修改人
     */
    private String updateUid;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 0: 删除 1: 未删除
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;


}
