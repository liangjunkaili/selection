package com.course.selection.service.impl;

import com.course.selection.bean.Coupons;
import com.course.selection.bean.Goods;
import com.course.selection.bean.Message;
import com.course.selection.dao.CouponsDao;
import com.course.selection.dao.GoodsDao;
import com.course.selection.dao.MessageDao;
import com.course.selection.dto.*;
import com.course.selection.service.GoodsService;
import com.course.selection.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private CouponsDao couponsDao;
    @Autowired
    private MessageDao messageDao;
    @Override
    public List<Goods> queryGoods(Map<String, Object> param) {
        return goodsDao.queryGoods(param);
    }

    @Override
    public Result index() {
        //查询首页信息
        List<Goods> goods = goodsDao.queryGoods(new HashMap<>());
        List<GoodDto> goodDtos = new ArrayList<>();
        List<ImgDto> imgDtos = new ArrayList<>();
        int i = 0;
        for (Goods good : goods) {
            if (i < 3) {
                i++;
                ImgDto imgDto = ImgDto.builder()
                        .id(good.getId())
                        .img(good.getImg())
                        .build();
                imgDtos.add(imgDto);
            }
            String[] split = good.getLabel().split("\\|");

            GoodDto goodDto = GoodDto.builder()
                    .img(good.getImg())
                    .intro(good.getIntro())
                    .label(split)
                    .price(good.getPrice())
                    .title(good.getTitle())
                    .id(good.getId())
                    .build();
            goodDtos.add(goodDto);
        }
        IndexDto indexDto = IndexDto.builder()
                .goodDtos(goodDtos)
                .imgDtos(imgDtos)
                .build();
        return ResultUtil.success(indexDto);
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public Result getGoodById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<Goods> goods = goodsDao.queryGoods(map);
        Coupons coupons = couponsDao.findById(goods.get(0).getFlag());
        List<Message> messages = messageDao.findByGoodId(goods.get(0).getId());
        Goods good = goods.get(0);
        String[] split = good.getLabel().split("\\|");
        GoodsDto goodsDto = GoodsDto.builder()
                .bamount(good.getBamount())
                .detail(good.getDetail())
                .flag(good.getFlag())
                .icard(good.getIcard())
                .img(good.getImg())
                .img1(good.getImg1())
                .img2(good.getImg2())
                .img3(good.getImg3())
                .intro(good.getIntro())
                .id(good.getId())
                .label(split)
                .num(good.getNum())
                .weight(good.getWeight())
                .title(good.getTitle())
                .oprice(good.getOprice())
                .price(good.getPrice())
                .build();
        GoodDetails goodDetails = GoodDetails.builder()
                .goods(goodsDto)
                .coupons(coupons)
                .message(messages)
                .build();
        return ResultUtil.success(goodDetails);
    }
}
