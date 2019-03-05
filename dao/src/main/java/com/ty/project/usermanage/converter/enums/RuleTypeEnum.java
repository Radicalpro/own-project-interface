package com.ty.project.usermanage.converter.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

import java.util.Arrays;

/**
 * 权限类型枚举值
 *
 * @author tianyi
 * @since 2019-03-05
 */
public enum RuleTypeEnum {

    /**
     * 1: 菜单 2: 面包学 3: 权限
     */
    MENU(1, "菜单"),
    CRUMBS(2, "菜单"),
    AUTH(3, "权限"),
    ERROR(4, "");

    @EnumValue
    @Getter
    private final int code;

    @Getter
    private final String des;

    RuleTypeEnum(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public static RuleTypeEnum valueOf(int code) {
        return Arrays.stream(RuleTypeEnum.values())
                .filter(a -> a.getCode() == code)
                .findFirst().orElse(RuleTypeEnum.ERROR);
    }


}
