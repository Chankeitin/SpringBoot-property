package com.bnuz.service.impl;

import com.bnuz.dto.CouponDto;
import com.bnuz.mapper.StoreMapper;
import com.bnuz.pojo.Coupon;
import com.bnuz.mapper.CouponMapper;
import com.bnuz.pojo.Store;
import com.bnuz.service.CouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Chanchitin
 * @since 2021-06-09
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public List<CouponDto> getCouponById(int id) {
        List<CouponDto> list = new ArrayList<>();
        //查询所有商家
        List<Store> stores = storeMapper.selectList(null);
        for (Store store : stores) {
            //获得每个商家的id
            Integer storeId = store.getId();
            Map<String, Object> map = new HashMap<>();
            map.put("user_id",id);
            map.put("shop_id",storeId);
            //查询出优惠券
            List<Coupon> couponChild = couponMapper.selectByMap(map);
            CouponDto couponDto = new CouponDto();
            couponDto.setCouponChild(couponChild);
            couponDto.setAvatar(store.getAvatar());
            couponDto.setStoreName(store.getStoreName());
            couponDto.setCreateTime(store.getCreateTime());
            couponDto.setId(storeId);
            list.add(couponDto);
        }

        return list;
    }
}
