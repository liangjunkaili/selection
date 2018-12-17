package com.course.selection.service.impl;

import com.course.selection.bean.Goods;
import com.course.selection.dao.GoodsDao;
import com.course.selection.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsServicImpl
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/17 7:36 AM
 * @Version 1.0
 **/
@Service
public class GoodsServicImpl implements GoodsService{
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> queryGoods(Map<String, Object> param) {
        return goodsDao.queryGoods(param);
    }
}
