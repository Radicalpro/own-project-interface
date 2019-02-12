package com.ty.project.user.entity;

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
 * 用户表
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("my_user")
public class MyUserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 加密盐值
     */
    private String saltValue;

    /**
     * 0:正常 1:冻结
     */
    private Boolean status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加人
     */
    private String addUid;

    /**
     * 注册时间
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
    private Boolean isDelete;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;


}
