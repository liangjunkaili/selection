package com.course.selection.controller;

import com.course.selection.bean.Goods;
import com.course.selection.dto.Result;
import com.course.selection.service.GoodsService;
import com.course.selection.util.ResultUtil;
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
    public Result getGoods(){
        Map<String,Object> map = new HashMap<>();
        List<Goods> goods = goodsService.queryGoods(map);
        Goods goods1 = Goods.builder().title(goods.get(0).getTitle()).build();
        return ResultUtil.success(goods1);
    }
}
