package com.course.selection.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@ApiModel("我的订单对象")
public class OrderDto {
    private String img;
    private Integer state;
    private Integer price;
    private Integer num;
    private String type1;
    private String type2;
    private String title;
}
