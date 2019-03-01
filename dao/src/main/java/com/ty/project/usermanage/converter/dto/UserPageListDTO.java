package com.ty.project.usermanage.converter.dto;

import com.ty.project.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册dto
 *
 * @author tianyi
 * @since 2019-02-13
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class UserPageListDTO extends PageDTO {

    /**
     * 用户名
     */
    private String userName;

}
