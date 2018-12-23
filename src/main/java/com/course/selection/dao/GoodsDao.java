package com.course.selection.dao;

import com.course.selection.bean.Goods;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsDao {
    List<Goods> queryGoods(Map<String, Object> param);

    Goods queryGoodsById(@Param("id") Integer id);

    void addGoods(@Param("goods") Goods goods);
}
