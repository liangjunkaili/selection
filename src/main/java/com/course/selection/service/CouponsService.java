package com.course.selection.service;

import com.course.selection.dto.Result;

public interface CouponsService {
    void getMyCoupons(Integer uid);

    Result receiveCoupons(Integer uid, Integer cid);
}
