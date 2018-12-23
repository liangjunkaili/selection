package com.course.selection.bean;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Reason {
    private  Integer id;
    private String reason;
}
