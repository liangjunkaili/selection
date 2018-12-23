package com.course.selection.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
@ApiModel("首页对象")
public class IndexDto {
    private List<GoodDto> goodDtos;
    private List<ImgDto> imgDtos;
}
