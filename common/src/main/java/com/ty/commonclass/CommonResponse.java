package com.ty.commonclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公告的前端返回类
 *
 * @author tianyi
 * @since 2019-02-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse<T> {

    /**
     * 返回码 0成功
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T content;
}
