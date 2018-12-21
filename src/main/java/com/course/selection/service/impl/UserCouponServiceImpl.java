package com.course.selection.service.impl;

import com.course.selection.bean.Coupons;
import com.course.selection.bean.UserCoupon;
import com.course.selection.dao.CouponsDao;
import com.course.selection.dao.UserCouponDao;
import com.course.selection.dto.Result;
import com.course.selection.dto.UserCouponDto;
import com.course.selection.service.UserCouponService;
import com.course.selection.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCouponServiceImpl implements UserCouponService {
    @Autowired
    private UserCouponDao userCouponDao;
    @Autowired
    private CouponsDao couponsDao;

    @Override
    public Result getMyCoupons(Integer uid) {
        List<UserCoupon> coupons = userCouponDao.findByUid(uid);
        List<UserCouponDto> couponsList = new ArrayList<>();
        if (coupons != null && coupons.size() != 0) {
            for (UserCoupon coupon: coupons
                 ) {
                Coupons cp = couponsDao.findById(coupon.getCpid());
                UserCouponDto dto = UserCouponDto.builder()
                        .invalidDate(coupon.getInvalidDate())
                        .price(cp.getPrice())
                        .reason(cp.getReason())
                        .type(cp.getType())
                        .build();
                couponsList.add(dto);
            }
        }
        return ResultUtil.success(couponsList);
    }
}
