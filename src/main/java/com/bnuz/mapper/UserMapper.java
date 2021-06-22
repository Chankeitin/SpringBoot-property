package com.bnuz.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnuz.dto.UserListDto;
import com.bnuz.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /*查询用户权限*/
    List<String> getRoleByUsername(String username);
    /*分页通过字段查询用户列表*/
    IPage<UserListDto> findUserPageByVO(Page<UserListDto> page,@Param(Constants.WRAPPER) QueryWrapper<UserListDto> wrapper);
}
