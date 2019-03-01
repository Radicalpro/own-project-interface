package com.ty.project.dto;

import lombok.Data;

/**
 * 分页基础dto
 *
 * @author tianyi
 * @since 2019-03-01
 */
@Data
public class PageDTO {

    /**
     * 每页显示条数，默认 10
     */
    private Long size;

    /**
     * 当前页
     */
    private Long current;

}
