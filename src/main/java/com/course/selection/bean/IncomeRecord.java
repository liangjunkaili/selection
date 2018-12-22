package com.course.selection.bean;

import lombok.*;

/**
 * @ClassName IncomeRecord
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/20 9:23 AM
 * @Version 1.0
 **/
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeRecord {
    private int id;
    private int type;
    private int price;
    private String other;
    private String regTime;
    private String img;
}
