package com.course.selection.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户信息
 * @author lw
 * @data 2018/10/25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String openId;//微信接口返回的唯一id
    private String unionId;//
    private String nickname;//用户昵称
    private String avatar;//用户头像url
    private Integer gender;//用户性别
    private LocalDateTime regTime;//创建时间
    private LocalDateTime activeTime;//活跃时间
    @Builder.Default
    private String channel="default";//用户渠道
    private String ip;//第一次登陆的ip地址
    private String city;//城市
    private String province;//省份
    private String country;//国家
    private Integer income;//累计收益
    private Integer orders;//推广订单数
    private String poster;//我的海报



}
