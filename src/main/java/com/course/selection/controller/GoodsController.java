package com.course.selection.controller;

import com.course.selection.bean.Goods;
import com.course.selection.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/17 7:17 AM
 * @Version 1.0
 **/
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("getGoods")
    public List<Goods> getGoods(){
        Map<String,Object> map = new HashMap<>();
        List<Goods> goods = goodsService.queryGoods(map);
        System.out.println(goods.get(0).getIntro());
        return goods;
    }
}
