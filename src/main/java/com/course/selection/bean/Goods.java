package com.course.selection.bean;

import lombok.*;

import java.io.Serializable;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/17 7:12 AM
 * @Version 1.0
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int id;
    private String img;
    private String title;
    private String intro;
    private String label;
    /**
     * 单位为分，都为整数
     */
    private int price;

}
