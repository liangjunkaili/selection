package com.course.selection.service;

import com.course.selection.dto.Result;

public interface OrderService {
    Result getMyOrders(Integer uid);

    Result orderGoods(Integer uid, Integer gid, Integer num, Integer price, String type1, String type2);

    /**
     * 支付完成
     * @param oid
     * @return
     */
    Boolean paySuccess(Integer oid);

    /**
     * 测评完成
     * @param oid
     * @return
     */
    Boolean testSuccess(Integer oid);
}
