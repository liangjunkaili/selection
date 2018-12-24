package com.course.selection.service;

import com.course.selection.bean.Goods;
import com.course.selection.dto.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsService
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/17 7:35 AM
 * @Version 1.0
 **/
public interface GoodsService {
    List<Goods> queryGoods(Map<String,Object> param);

    Result index();


    void addGoods(Goods goods);

    Result getGoodById(Integer id);
}
