package com.course.selection.dao;

import com.course.selection.bean.UserCoupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCouponDao {
    List<UserCoupon> findByUid(@Param("uid") Integer uid);
}
