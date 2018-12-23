package com.course.selection.service.impl;

import com.course.selection.bean.Reason;
import com.course.selection.dao.ReasonDao;
import com.course.selection.dto.Result;
import com.course.selection.service.ReasonService;
import com.course.selection.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonServiceImpl implements ReasonService {
    @Autowired
    private ReasonDao reasonDao;
    @Override
    public Result addReason(String reason) {
        reasonDao.insert(Reason.builder().reason(reason).build());
        List<Reason> all = reasonDao.findAll();
        return ResultUtil.success(all);
    }

    @Override
    public Result getReason() {
        List<Reason> all = reasonDao.findAll();
        return ResultUtil.success(all);
    }

}
