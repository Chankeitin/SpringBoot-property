package com.bnuz.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnuz.common.Result;
import com.bnuz.dto.UserListDto;
import com.bnuz.pojo.Role;
import com.bnuz.service.RoleService;
import com.bnuz.service.UserService;
import com.bnuz.util.AnonymousAccess;
import com.bnuz.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chanchitin
 * @since 2021-05-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    /*
     * 按条件分页查询用户列表
     */
    @PostMapping("/findUserPageByVO")
    public Result findUserPageByVO(@RequestParam(required = true,defaultValue = "1")Integer current,
                                   @RequestParam(required = true,defaultValue = "6")Integer size,
                                   @RequestBody UserVO userVO){
        //对用户进行分页
        Page<UserListDto> page = new Page<>(current,size);
        QueryWrapper<UserListDto> wrapper = getWrapper(userVO);
        IPage<UserListDto> userPage = userService.findUserPageByVO(page, wrapper);
        long total = userPage.getTotal();
        List<UserListDto> records = userPage.getRecords();
        return Result.ok().data("total",total).data("records",records);
    }

    private QueryWrapper<UserListDto> getWrapper(UserVO userVO){
        QueryWrapper<UserListDto> wrapper = new QueryWrapper<>();
        if(userVO!=null){

            if(!StringUtils.isEmpty(userVO.getUsername())){
                wrapper.eq("username",userVO.getUsername());
            }
            if(!StringUtils.isEmpty(userVO.getNickname())) {
                wrapper.eq("nickname", userVO.getNickname());
            }
            if(!ObjectUtils.isEmpty(userVO.getRoleId())) {
                Role role = roleService.getBaseMapper().selectById(userVO.getRoleId());
                if (role != null) {
                    wrapper.eq("role_name", role.getRoleName());
                }

            }
        }
        return wrapper;
    }
}

