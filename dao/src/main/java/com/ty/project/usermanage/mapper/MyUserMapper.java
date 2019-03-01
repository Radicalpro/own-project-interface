package com.ty.project.usermanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ty.project.usermanage.converter.dto.UserPageListDTO;
import com.ty.project.usermanage.converter.vo.UserEntityVo;
import com.ty.project.usermanage.entity.MyUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 Mapper 接口
 *
 * @author tianyi
 * @since 2019-02-12
 */
public interface MyUserMapper extends BaseMapper<MyUserEntity> {

    /**
     * 分页查询
     *
     * @param page            分页数据
     * @param userPageListDTO 其他参训参数
     * @return List<MyUserEntity>
     */
    List<UserEntityVo> selectPageVo(Page<UserEntityVo> page, @Param("dto") UserPageListDTO userPageListDTO);
}
