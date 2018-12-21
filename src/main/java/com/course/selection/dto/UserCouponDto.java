package com.course.selection.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Builder
@ApiModel("我的优惠券对象")
public class UserCouponDto {
    private Integer price;
    private String reason;
    private String type;
    private String invalidDate;
    private Integer state;
}
