package com.bnuz.controller;

import com.bnuz.common.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chanchitin
 * @date 2021/6/1
 */
@Api(tags = "判断是否登录模块")
@RestController
public class IsLoginController {

    @GetMapping("/isLogin")
    public Result isLogin(){
        return Result.ok().message("用户已登录");
    }
}
