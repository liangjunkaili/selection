package com.course.selection.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Builder
@Data
@ToString
@ApiModel("首页轮播图对象")
public class ImgDto {
    private Integer id;
    private String img;
}
