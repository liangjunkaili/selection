package com.course.selection.dto;

import com.course.selection.bean.Coupons;
import com.course.selection.bean.Goods;
import com.course.selection.bean.Message;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodDetails {
    private GoodsDto goods;
    private Coupons coupons;
    private List<Message> message;
}
