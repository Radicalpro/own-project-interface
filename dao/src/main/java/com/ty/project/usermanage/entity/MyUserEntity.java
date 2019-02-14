package com.ty.project.usermanage.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.ty.project.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Arrays;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer isDelete;

    /**
     * 最后更新时间
     */
    private LocalDateTime lastUpdateTime;


    /**
     * 账户状态枚举
     */
    public enum StatusEnum {
        /**
         * 账户状态枚举
         */
        NORMAL(0, "正常"),
        FROZEN(1, "冻结"),
        ERROR(99, "状态错误");

        @EnumValue
        @Getter
        private final int code;

        @Getter
        private final String des;

        StatusEnum(int code, String des) {
            this.code = code;
            this.des = des;
        }

        public static StatusEnum valueOf(int code) {
            return Arrays.stream(StatusEnum.values())
                    .filter(a -> a.getCode() == code)
                    .findFirst().orElse(StatusEnum.ERROR);
        }
    }
}
