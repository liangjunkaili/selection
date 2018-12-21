package com.course.selection.bean;

import lombok.*;

/**
 * @ClassName OrderPeopleList
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/20 9:23 AM
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderPeopleList {
    private Integer id;
    private Integer oid;
    private String name;
    private String title;
    private Integer gender;
    private String phone;
    private String birthdayTime;
    private String address;
    /**
     * 报告链接
     */
    private String rurl;
    /**
     * 讲解链接
     */
    private String eurl;
    private Integer state;
}
