package com.ty.project.usermanage.controller;


import com.ty.constants.SysConstants;
import com.ty.project.controller.BaseController;
import com.ty.project.response.CommonResponse;
import com.ty.project.usermanage.converter.dto.RoleAddDTO;
import com.ty.project.usermanage.service.IMyRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author tianyi
 * @since 2019-03-01
 */
@RestController
@RequestMapping("/role")
public class MyRoleController extends BaseController {

    @Resource
    private IMyRoleService myRoleService;

    /**
     * 新增角色
     *
     * @param roleAddDTO    新增角色dto
     * @param bindingResult 参数校验类
     * @return CommonResponse
     */
    @PostMapping(value = "/add")
    @RequiresPermissions("role:add")
    public CommonResponse<String> add(@Valid @RequestBody RoleAddDTO roleAddDTO, BindingResult bindingResult) {
        checkValidResult(bindingResult);
        myRoleService.add(roleAddDTO, getUserName());
        return new CommonResponse<>(SysConstants.SUCCESS_CODE, SysConstants.SUCCESS_STRING, "");
    }

}
