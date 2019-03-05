package com.ty.project.usermanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ty.project.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author tianyi
 * @since 2019-03-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("my_rule")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyRuleEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    private String ruleName;

    /**
     * 权限地址
     */
    private String ruleDetail;

    /**
     * 1: 菜单 2: 面包学 3: 权限
     */
    private Integer ruleType;

    /**
     * 父id
     */
    private Integer pid;

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
    private Integer isDelete;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;


}
