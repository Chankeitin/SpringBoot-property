package com.bnuz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnuz.dto.UserListDto;
import com.bnuz.pojo.User;
import com.bnuz.mapper.UserMapper;
import com.bnuz.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<UserListDto> findUserPageByVO(Page<UserListDto> page, QueryWrapper<UserListDto> wrapper) {
        return this.baseMapper.findUserPageByVO(page,wrapper);
    }
}
