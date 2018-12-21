package com.course.selection.service.impl;

import com.course.selection.bean.Order;
import com.course.selection.dao.OrderDao;
import com.course.selection.dto.Result;
import com.course.selection.service.OrderService;
import com.course.selection.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Result getMyOrders(Integer uid) {
        List<Order> orders =  orderDao.findByUid(uid);
        return ResultUtil.success(orders);
    }
}
