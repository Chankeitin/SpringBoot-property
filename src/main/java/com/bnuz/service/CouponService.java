package com.bnuz.service;

import com.bnuz.dto.CouponDto;
import com.bnuz.pojo.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-06-09
 */
public interface CouponService extends IService<Coupon> {

    public List<CouponDto> getCouponById(int id);
}
