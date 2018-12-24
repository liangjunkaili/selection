package com.course.selection.service.impl;

import com.course.selection.dao.CouponsDao;
import com.course.selection.dto.Result;
import com.course.selection.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponsServiceImpl implements CouponsService {
    @Autowired
    private CouponsDao couponsDao;
    @Override
    public void getMyCoupons(Integer uid) {

    }

    @Override
    public Result receiveCoupons(Integer uid, Integer cid) {
        return null;
    }
}
