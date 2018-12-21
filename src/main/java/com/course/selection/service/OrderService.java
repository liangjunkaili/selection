package com.course.selection.service;

import com.course.selection.dto.Result;

public interface OrderService {
    Result getMyOrders(Integer uid);
}
