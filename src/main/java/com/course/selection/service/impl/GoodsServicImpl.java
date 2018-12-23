package com.course.selection.service.impl;

import com.course.selection.bean.Goods;
import com.course.selection.dao.GoodsDao;
import com.course.selection.dto.GoodDto;
import com.course.selection.dto.ImgDto;
import com.course.selection.dto.IndexDto;
import com.course.selection.dto.Result;
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
            GoodDto goodDto = GoodDto.builder()
                    .img(good.getImg())
                    .intro(good.getIntro())
                    .label(good.getLabel())
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


}
