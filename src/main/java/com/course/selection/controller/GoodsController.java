package com.course.selection.controller;

import com.course.selection.bean.Goods;
import com.course.selection.dto.Result;
import com.course.selection.service.CouponsService;
import com.course.selection.service.GoodsService;
import com.course.selection.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CouponsService couponsService;
    @RequestMapping("getGoods")
    public Result getGoods() {
        Map<String, Object> map = new HashMap<>();
        List<Goods> goods = goodsService.queryGoods(map);
        return ResultUtil.success(goods);
    }

    @ApiOperation("获取商品详情")
    @GetMapping("getGoodById")
    public Result getGoodById(
            @RequestParam(value = "id",required = false) Integer id) {

        return goodsService.getGoodById(id);
    }

    /**
     * 领取优惠券
     * @param
     * @return
     */
    @RequestMapping("receiveCoupons")
    public Result receiveCoupons(@RequestParam(value = "uid",required = false) Integer uid,
                                 @RequestParam(value = "cid",required = false) Integer cid) {

        return couponsService.receiveCoupons(uid,cid);
    }

    @GetMapping("index")
    public Result index(){
        return goodsService.index();
    }
}