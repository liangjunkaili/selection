package com.course.selection.bean;

import lombok.*;

/**
 * @ClassName Order
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/17 7:15 AM
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {
    private Integer oid;
    private Integer uid;
    private Integer gid;
    private Integer state;
    private Integer num;
    private Integer price;
    private String type1;
    private String type2;
    private String img;
    private String title;
}
