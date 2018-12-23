package com.course.selection.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
@Builder
@ApiModel("登录接口返回的用户对象")
public class UserDto {
    /**
     * 用户token
     */
    private String token;
    /**
     * uid
     */
    private Integer uid;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户收益
     */
    private Integer income;
    /**
     * 用户海报
     */
    private String poster;
}
