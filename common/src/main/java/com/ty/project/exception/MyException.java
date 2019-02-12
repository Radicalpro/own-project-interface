package com.ty.project.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目通用异常类
 *
 * @author tianyi
 * @since 2019-02-12
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MyException extends RuntimeException {

    private Integer code;

    private String message;

}
