package com.ty.commonenums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

import java.util.Arrays;

/**
 * 删除枚举
 *
 * @author tianyi
 * @since 2019-02-02
 */
public enum IsDeleteEnum {

    /**
     * 删除标记
     */
    NOT_DELETE(0, "未删除"),
    DELETE(1, "删除"),
    ERROR(99, "异常");

    @EnumValue
    @Getter
    private final int code;

    @Getter
    private final String des;

    IsDeleteEnum(int code, String des){
        this.code = code;
        this.des = des;
    }

    public static IsDeleteEnum valueOf(int code) {
        return Arrays.stream(IsDeleteEnum.values())
                .filter(a -> a.getCode() == code)
                .findFirst().orElse(IsDeleteEnum.ERROR);
    }
}
