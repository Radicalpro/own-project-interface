package com.ty.test.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.ty.commonclass.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试数据库
 * </p>
 *
 * @author tianyi
 * @since 2019-02-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TestUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id 主键
     */
    @TableId
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 0:未删除 1:已删除
     */
    @TableLogic
    private Integer isDelete;

}
