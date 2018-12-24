package com.course.selection.controller;

import com.course.selection.dto.Result;
import com.course.selection.enums.ResultEnum;
import com.course.selection.service.*;
import com.course.selection.util.HttpUtil;
import com.course.selection.util.ResultUtil;
import com.course.selection.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@Log4j2
@Api
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserCouponService userCouponService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderPeopleListService orderPeopleListService;
    @Autowired
    private IncomeRecordService incomeRecordService;

    @ApiOperation("用户登录")
    @PostMapping("login")
    public Result login(@RequestParam(value = "code", required = false) String code,
                        @RequestParam(value = "encryptedData", required = false) String encryptedData,
                        @RequestParam(value = "iv", required = false) String iv,
                        @RequestParam(value = "channel", required = false) String channel,
                        @RequestParam(value = "shareId", required = false) Integer uid,
                        HttpServletRequest request) throws IOException {
        String ip = HttpUtil.getIpAddr(request);
        log.info("code :{},encryptedData:{},iv:{},channel:{},ip:{}", code, encryptedData, iv, channel, ip);
        if (StringUtil.UNDEFINED.equals(encryptedData) || StringUtil.UNDEFINED.equals(iv)) {
            return ResultUtil.error(ResultEnum.PARAM_ERR);
        }
        Result result = userService.login(code, encryptedData, iv, channel, ip, uid);
        return result;
    }

    @ApiOperation("我的优惠券")
    @PostMapping("getMyCoupons")
    public Result getMyCoupons(
            @RequestParam(value = "uid", required = false) Integer uid
    ) {
        return userCouponService.getMyCoupons(uid);
    }

    @ApiOperation("我的订单")
    @PostMapping("getMyOrders")
    public Result getMyOrders(
            @RequestParam(value = "uid", required = false) Integer uid
    ) {
        return orderService.getMyOrders(uid);
    }

    @ApiOperation("我的报告")
    @PostMapping("getMyPoster")
    public Result getMyPoster(
            @RequestParam(value = "uid", required = false) Integer uid
    ) {
        return orderPeopleListService.getMyPoster(uid);
    }

    @ApiOperation("查看订单下的测试人员")
    @PostMapping("getPeople")
    public Result getPeople(
            @RequestParam(value = "oid", required = false) Integer oid
    ) {
        return orderPeopleListService.getPeople(oid);
    }

    @ApiOperation("添加测试人员")
    @PostMapping("addPeople")
    public Result addPeople(
            @RequestParam(value = "oid", required = true) Integer oid,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "gender", required = false) Integer gender,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "birthdayTime", required = false) String birthdayTime,
            @RequestParam(value = "address", required = false) String address
    ) {
        log.info("oid:{}", oid);
        return orderPeopleListService.addPeople(oid, name, gender, phone, birthdayTime, address);
    }


    @ApiOperation("修改测试人员")
    @PostMapping("updatePeople")
    public Result updatePeople(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "gender", required = false) Integer gender,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "birthdayTime", required = false) String birthdayTime,
            @RequestParam(value = "address", required = false) String address
    ) {
        log.info("id:{}", id);
        return orderPeopleListService.updatePeople(id, name, gender, phone, birthdayTime, address);
    }


//    public Result queryIncomeByUid(){
//
//    }


    @PostMapping("orderGoods")
    @ApiOperation("生成订单")
    public Result orderGoods(
            @RequestParam(value = "uid") Integer uid,
            @RequestParam(value = "gid") Integer gid,
            @RequestParam(value = "num") Integer num,
            @RequestParam(value = "price") Integer price,
            @RequestParam(value = "type1") String type1,
            @RequestParam(value = "type2") String type2
    ) {
        return orderService.orderGoods(uid, gid, num, price, type1, type2);
    }
}
