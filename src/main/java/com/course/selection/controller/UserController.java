package com.course.selection.controller;

import com.course.selection.dto.Result;
import com.course.selection.enums.ResultEnum;
import com.course.selection.service.OrderService;
import com.course.selection.service.UserCouponService;
import com.course.selection.service.UserService;
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
            @RequestParam(value = "uid",required = false) Integer uid
    ){
        return userCouponService.getMyCoupons(uid);
    }

    @ApiOperation("我的订单")
    @PostMapping("getMyOrders")
    public Result getMyOrders(
            @RequestParam(value = "uid",required = false) Integer uid
    ){
        return orderService.getMyOrders(uid);
    }

    @ApiOperation("我的报告")
    @PostMapping("getMyPoster")
    public Result getMyPoster(
            @RequestParam(value = "uid",required = false) Integer uid
    ){
        return orderService.getMyOrders(uid);
    }

}
