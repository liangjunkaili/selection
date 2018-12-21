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
    private Integer img;
    private Integer content;
    private Integer name;
    private Integer time;
    private Integer reply;
    private Integer replyTime;
    private Integer nick;
}
