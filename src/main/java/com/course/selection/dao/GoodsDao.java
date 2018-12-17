package com.course.selection.dao;

import com.course.selection.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface GoodsDao {
    List<Goods> queryGoods(Map<String,Object> param);
}
