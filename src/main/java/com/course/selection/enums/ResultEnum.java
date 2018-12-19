package com.course.selection.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum {
    TEST(001, "test"),

    SUCCESS(200, "ok"),

    SERVER_ERROR(500, "服务器错误"),

    CODE_ERROR(10001, "微信code不正确"),

    NOT_LOGIN(10002, "用户未登录"),

    ENCRYPT_ERR(10003, "用户数据解密出错"),

    GET_TOKEN_ERR(10004, "获取token和openid出错"),

    PARAM_ERR(10006, "参数错误");

    private Integer state;
    private String msg;

}
