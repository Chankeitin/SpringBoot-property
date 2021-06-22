package com.bnuz.controller;


import com.bnuz.common.Result;
import com.bnuz.dto.MenuDto;
import com.bnuz.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Chanchitin
 * @since 2021-06-01
 */
@Api(tags = "菜单展示模块")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "获取展示菜单列表")
    @GetMapping("/getMenuList")
    public Result getMenuList(){
        List<MenuDto> menus = menuService.queryMenuList();
        return Result.ok().data("menuList",menus);
    }
}

