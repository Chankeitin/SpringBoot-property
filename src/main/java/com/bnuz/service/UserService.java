package com.bnuz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnuz.dto.UserListDto;
import com.bnuz.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
public interface UserService extends IService<User> {

    IPage<UserListDto> findUserPageByVO(Page<UserListDto> page,QueryWrapper<UserListDto> wrapper);
}
