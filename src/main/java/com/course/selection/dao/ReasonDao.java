package com.course.selection.dao;

import com.course.selection.bean.Reason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReasonDao {
    void insert(@Param("reason") Reason reason);

    List<Reason> findAll();
}
