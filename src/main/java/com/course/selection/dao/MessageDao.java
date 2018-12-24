package com.course.selection.dao;

import com.course.selection.bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageDao {
    void insert(@Param("message") Message message);

    Message findById(@Param("id") Integer id);
    List<Message> findByGoodId(@Param("goodId") Integer goodId);

    void update(@Param("message") Message message);
}
