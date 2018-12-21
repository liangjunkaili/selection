package com.course.selection.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@ApiModel("首页商品对象")
public class GoodDto {
    private String title;
    private String img;
    private String label;
    private String intro;
    private Integer price;
}
