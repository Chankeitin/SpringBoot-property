package com.bnuz.controller;


import com.bnuz.common.Result;
import com.bnuz.pojo.Role;
import com.bnuz.service.RoleService;
import com.bnuz.util.AnonymousAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

//    @AnonymousAccess //匿名
    @GetMapping("/findRole")
    public Result findRole(){
        List<Role> roles = roleService.getBaseMapper().selectList(null);
        return Result.ok().data("role",roles);
    }

    @GetMapping("/findRoleById")
    public Result findRoleById(@RequestParam("roleId") Integer roleId){
        Role role = roleService.getBaseMapper().selectById(roleId);
        return Result.ok().data("role",role);
    }
}

