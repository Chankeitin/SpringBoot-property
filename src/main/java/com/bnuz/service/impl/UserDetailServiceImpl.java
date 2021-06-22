package com.bnuz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnuz.mapper.UserMapper;
import com.bnuz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chanchitin
 * @date 2021/5/5
 */

@Service(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StrUtil.isEmpty(username)){
            throw new RuntimeException("用户名不能为空");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userMapper.selectOne(wrapper);
        if(user == null){
            throw new UsernameNotFoundException(String.format("%s这个用户不存在",username));
        }
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roleByUsername = userMapper.getRoleByUsername(username);
        roleByUsername.forEach(role_name ->{
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role_name);
            authorities.add(authority);

        });
        UserAuth userAuth = new UserAuth();
        userAuth.setUser(user);
        userAuth.setAuthorities(authorities);
        return userAuth;


        //return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
