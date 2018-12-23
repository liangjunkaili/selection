package com.course.selection.dao;

import com.course.selection.bean.OrderPeopleList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderPeopleListDao {
    void insert(@Param("orderPeopleList") OrderPeopleList orderPeopleList);

    List<OrderPeopleList> findByUid(@Param("uid") Integer uid);

    List<OrderPeopleList> findByOid(@Param("oid") Integer oid);

    void update(@Param("orderPeopleList") OrderPeopleList orderPeopleList);

    OrderPeopleList findById(@Param("id") Integer id);
}
