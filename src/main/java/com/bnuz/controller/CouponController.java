package com.bnuz.controller;


import com.bnuz.common.Result;
import com.bnuz.dto.CommentDto;
import com.bnuz.dto.CouponDto;
import com.bnuz.service.CouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @since 2021-06-09
 */
@Api(tags = "优惠券模块")
@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;


    @ApiOperation(value = "获取优惠券列表")
    @GetMapping("/getCouponList")
    public Result getCouponList(@RequestParam(name = "userId") Integer userId){
        List<CouponDto> couponById = couponService.getCouponById(userId);
        return Result.ok().message("获取优惠券成功").data("CouponList",couponById);

    }
}

