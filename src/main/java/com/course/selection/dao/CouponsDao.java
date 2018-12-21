package com.course.selection.dao;

import com.course.selection.bean.Coupons;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CouponsDao {
    Coupons findById(@Param("id") Integer id);
}
