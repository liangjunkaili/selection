package com.course.selection.bean;

import lombok.*;

/**
 * @ClassName Message
 * @Description TODO
 * @Author junliang
 * @Date 2018/12/20 9:22 AM
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Message {
    private Integer id;
    private Integer goodsId;
    private String img;
    private String  content;
    private String name;
    private String time;
    private String reply;
    private String replyTime;
    private String nick;
}
