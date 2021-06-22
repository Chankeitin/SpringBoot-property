package com.bnuz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnuz.common.Result;
import com.bnuz.pojo.RoleUser;
import com.bnuz.pojo.User;
import com.bnuz.service.RoleUserService;
import com.bnuz.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@Api(tags = "注册模块")
@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleUserService roleUserService;
    @PostMapping("/register")
    public Result register(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "nickname",required = false) String nickname,
                           @RequestParam(name = "description",required = false) String description){
        if(username==null)
            return Result.error().message("注册失败！用户名不能为空");
        if(password==null)
            return Result.error().message("注册失败！密码不能为空");
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username",username);
        User user = userService.getBaseMapper().selectOne(wrapper);
        if(user==null){
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setNickname(nickname);
            newUser.setDescription(description);
            userService.getBaseMapper().insert(newUser);
            User getUser = userService.getBaseMapper().selectOne(wrapper);
            Integer id = getUser.getId();
            RoleUser roleUser = new RoleUser();
            roleUser.setUserId(id);
            roleUser.setRoleId(2);
            roleUserService.getBaseMapper().insert(roleUser);
            return Result.ok().message("注册成功");
        }else{
            return Result.error().message("注册失败！用户已存在");
        }
    }
}
