package com.ty.project.usermanage.controller;


import com.ty.constants.SysConstants;
import com.ty.project.controller.BaseController;
import com.ty.project.response.CommonResponse;
import com.ty.project.usermanage.converter.dto.RoleAddDTO;
import com.ty.project.usermanage.converter.dto.RuleAddDTO;
import com.ty.project.usermanage.service.IMyRuleService;
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
 * 权限表 前端控制器
 * </p>
 *
 * @author tianyi
 * @since 2019-03-04
 */
@RestController
@RequestMapping("/rule")
public class MyRuleController extends BaseController {

    @Resource
    private IMyRuleService myRuleService;

    /**
     * 新增权限
     *
     * @param ruleAddDTO    新增权限dto
     * @param bindingResult 参数校验类
     * @return CommonResponse
     */
    @PostMapping(value = "/add")
    @RequiresPermissions("ruld:add")
    public CommonResponse<String> add(@Valid @RequestBody RuleAddDTO ruleAddDTO, BindingResult bindingResult) {
        checkValidResult(bindingResult);
        myRuleService.add(ruleAddDTO, getUserName());
        return new CommonResponse<>(SysConstants.SUCCESS_CODE, SysConstants.SUCCESS_STRING, "");
    }

}
