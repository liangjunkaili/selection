package com.course.selection.service.impl;

import com.course.selection.bean.Order;
import com.course.selection.dao.OrderDao;
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
}
