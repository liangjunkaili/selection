package com.course.selection.controller;

import com.course.selection.dto.Result;
import com.course.selection.enums.ResultEnum;
import com.course.selection.service.*;
import com.course.selection.util.COSUtil;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        return orderPeopleListService.getMyPoster(uid);
    }

    @ApiOperation("查看订单下的测试人员")
    @PostMapping("getPeople")
    public Result getPeople(
            @RequestParam(value = "oid",required = false) Integer oid
    ){
        return orderPeopleListService.getPeople(oid);
    }

    @ApiOperation("添加测试人员")
    @PostMapping("addPeople")
    public Result addPeople(
            @RequestParam(value = "oid",required = true) Integer oid,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "gender",required = false) Integer gender,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "birthdayTime",required = false) String birthdayTime,
            @RequestParam(value = "address",required = false) String address
    ){
        log.info("oid:{}",oid);
        return orderPeopleListService.addPeople(oid,name,gender,phone,birthdayTime,address);
    }

    @PostMapping("addIncomeRecord")
    public Result addIncomeRecord(
            @RequestParam(value = "uid",required = true) Integer uid,
            @RequestParam(value = "price",required = true) Integer price,
//            @RequestParam(value = "regTime",required = true) String regTime,
            @RequestParam(value = "other",required = true) String other,
            @RequestParam(value = "type",required = true) Integer type,
            @RequestParam(value = "img",required = true) MultipartFile file

    ){
        long timestemp = new Date().getTime();
        log.info(uid+"|"+price+"|"+other+"|"+type);
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("price",price);
        map.put("regTime", LocalDateTime.now());
        map.put("other",other);
        map.put("type",type);
        try {
            String str = COSUtil.uploadImage(file.getInputStream(),"/subject/"+timestemp+file.getOriginalFilename());
            map.put("img",str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = incomeRecordService.addIncomeRecord(map);
        log.info(i+"--");
        return ResultUtil.success();
    }

//    public Result queryIncomeByUid(){
//
//    }
}
