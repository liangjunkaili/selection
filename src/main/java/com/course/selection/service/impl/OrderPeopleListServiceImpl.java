package com.course.selection.service.impl;

import com.course.selection.bean.Order;
import com.course.selection.bean.OrderPeopleList;
import com.course.selection.dao.OrderDao;
import com.course.selection.dao.OrderPeopleListDao;
import com.course.selection.dto.Result;
import com.course.selection.service.OrderPeopleListService;
import com.course.selection.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderPeopleListServiceImpl implements OrderPeopleListService {
    @Autowired
    private OrderPeopleListDao orderPeopleListDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public Result getMyPoster(Integer uid) {
        List<OrderPeopleList> orderPeopleLists = orderPeopleListDao.findByUid(uid);
        return ResultUtil.success(orderPeopleLists);
    }

    @Override
    public Result addPeople(Integer oid, String name, Integer gender, String phone, String birthdayTime, String address) {
        Order order = orderDao.findByOid(oid);
        OrderPeopleList orderPeopleList = OrderPeopleList.builder()
                .address(address)
                .birthdayTime(birthdayTime)
                .gender(gender)
                .name(name)
                .oid(oid)
                .phone(phone)
                .state(0)
                .title(order.getTitle())
                .build();
        orderPeopleListDao.insert(orderPeopleList);
        return ResultUtil.success();
    }

    @Override
    public Result getPeople(Integer oid) {
        List<OrderPeopleList> orderPeopleLists = orderPeopleListDao.findByOid(oid);
        return ResultUtil.success(orderPeopleLists);
    }
}
