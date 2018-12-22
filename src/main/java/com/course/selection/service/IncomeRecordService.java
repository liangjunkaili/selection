package com.course.selection.service;

import com.course.selection.bean.IncomeRecord;

import java.util.List;
import java.util.Map;

public interface IncomeRecordService {
    int addIncomeRecord(Map<String,Object> param);
    List<IncomeRecord> queryIncomeRecords(Map<String,Object> param);
}
