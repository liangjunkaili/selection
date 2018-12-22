package com.course.selection.service.impl;


import com.course.selection.bean.IncomeRecord;
import com.course.selection.dao.IncomeRecordDao;
import com.course.selection.service.IncomeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IncomeRecordServiceImpl
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/22 7:37 AM
 * @Version 1.0
 **/
@Service("incomeRecordService")
public class IncomeRecordServiceImpl implements IncomeRecordService
{
    @Autowired
    private IncomeRecordDao incomeRecordDao;
    @Override
    public int addIncomeRecord(Map<String, Object> param) {
        return incomeRecordDao.addIncomeRecord(param);
    }

    @Override
    public List<IncomeRecord> queryIncomeRecords(Map<String, Object> param) {
        return incomeRecordDao.queryIncomeRecords(param);
    }
}
