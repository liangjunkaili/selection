package com.course.selection.bean;

import lombok.*;

/**
 * @ClassName Coupons
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/20 9:17 AM
 * @Version 1.0
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coupons {
    private int id;
    private int price;
    private String reason;
    private String type;
    private int num;
    private int state;
    private int vaildTime;
}
