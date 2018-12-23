package com.course.selection.controller;


import com.course.selection.bean.Goods;
import com.course.selection.dto.Result;
import com.course.selection.service.GoodsService;
import com.course.selection.service.IncomeRecordService;
import com.course.selection.service.ReasonService;
import com.course.selection.util.CosUtil;
import com.course.selection.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@Log4j2
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private IncomeRecordService incomeRecordService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ReasonService reasonService;

    public static final String IMG_URL = "https://qinmi-1258355325.cos.ap-beijing.myqcloud.com/";

    @PostMapping("addIncomeRecord")
    public Result addIncomeRecord(
            @RequestParam(value = "uid", required = true) Integer uid,
            @RequestParam(value = "price", required = true) Integer price,
//            @RequestParam(value = "regTime",required = true) String regTime,
            @RequestParam(value = "other", required = true) String other,
            @RequestParam(value = "type", required = true) Integer type,
            @RequestParam(value = "img", required = true) MultipartFile file

    ) {
//        long timestemp = new Date().getTime();
        log.info(uid + "|" + price + "|" + other + "|" + type);
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("price", price);
        map.put("regTime", LocalDateTime.now());
        map.put("other", other);
        map.put("type", type);
        try {
            map.put("img", CosUtil.getImgUrl(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = incomeRecordService.addIncomeRecord(map);
        return ResultUtil.success();
    }

    @PostMapping("addGoods")
    @ApiOperation("添加商品")
    public Result addGoods(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "detail") String detail,
            @RequestParam(value = "file1") MultipartFile file1,//轮播图1
            @RequestParam(value = "file2") MultipartFile file2,//轮播图2
            @RequestParam(value = "file3") MultipartFile file3,//轮播图3
            @RequestParam(value = "file4") MultipartFile file4,//主图
            @RequestParam(value = "file5") MultipartFile file5,//邀请卡
            @RequestParam(value = "oprice") Integer oprice,
            @RequestParam(value = "price") Integer price,
            @RequestParam(value = "label") String label,
            @RequestParam(value = "intro") String intro,
            @RequestParam(value = "bamount") Integer bamount,
            @RequestParam(value = "flag") Integer flag,
            @RequestParam(value = "weight") Integer weight,
            @RequestParam(value = "num") Integer num
    ) {
        String img1 = null;
        String img2 = null;
        String img3 = null;
        String img = null;
        String icard = null;
        try {
            img1 = CosUtil.getImgUrl(file1);
            img2 = CosUtil.getImgUrl(file2);
            img3 = CosUtil.getImgUrl(file3);
            img = CosUtil.getImgUrl(file4);
            icard = CosUtil.getImgUrl(file5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Goods goods = Goods.builder()
                .bamount(bamount)
                .detail(detail)
                .flag(flag)
                .icard(icard)
                .img(img)
                .img1(img1)
                .img2(img2)
                .img3(img3)
                .intro(intro)
                .label(label)
                .num(num)
                .oprice(oprice)
                .price(price)
                .weight(weight)
                .title(title)
                .build();
        goodsService.addGoods(goods);
        return ResultUtil.success();
    }


    @PostMapping("addReason")
    @ApiOperation("添加返现理由")
    public Result addReason(@RequestParam("reason") String reason) {
        return reasonService.addReason(reason);
    }

    @GetMapping("getReason")
    @ApiOperation("获取返现理由")
    public Result getReason() {
        return reasonService.getReason();
    }
}
