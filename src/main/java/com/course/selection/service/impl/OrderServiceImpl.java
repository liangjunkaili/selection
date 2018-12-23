package com.course.selection.service.impl;

import com.course.selection.bean.Goods;
import com.course.selection.bean.Order;
import com.course.selection.bean.OrderPeopleList;
import com.course.selection.dao.GoodsDao;
import com.course.selection.dao.OrderDao;
import com.course.selection.dao.OrderPeopleListDao;
import com.course.selection.dto.OrderDto;
import com.course.selection.dto.Result;
import com.course.selection.service.OrderService;
import com.course.selection.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderPeopleListDao orderPeopleListDao;
    @Override
    public Result getMyOrders(Integer uid) {
        List<Order> orders =  orderDao.findByUid(uid);
        List<OrderDto> dtos = new ArrayList<>();
        orders.forEach(order -> {
            OrderDto orderDto = OrderDto.builder()
                    .img(order.getImg())
                    .title(order.getTitle())
                    .num(order.getNum())
                    .price(order.getPrice())
                    .state(order.getState())
                    .type1(order.getType1())
                    .type2(order.getType2())
                    .build();
            dtos.add(orderDto);
        });
        return ResultUtil.success(dtos);
    }

    @Override
    public Result orderGoods(Integer uid, Integer gid, Integer num, Integer price, String type1, String type2) {
        Goods goods = goodsDao.queryGoodsById(gid);
        Order order = Order.builder()
                .uid(uid)
                .gid(gid)
                .num(num)
                .type1(type1)
                .type2(type2)
                .price(price)
                .title(goods.getTitle())
                .img(goods.getImg())
                .state(0)
                .build();
        orderDao.insert(order);
        return ResultUtil.success();
    }

    @Override
    public Boolean paySuccess(Integer oid) {
        try {
            orderDao.paySuccess(oid);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean testSuccess(Integer oid) {
        List<OrderPeopleList> peoples = orderPeopleListDao.findByOid(oid);
        for (OrderPeopleList people : peoples) {
            if (people.getState() == 0) {
                return false;
            }
        }
        orderDao.testSuccess(oid);
        return true;
    }

}
