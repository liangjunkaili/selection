package com.course.selection.service;

import com.course.selection.dto.Result;

public interface ReasonService {
    Result addReason(String reason);

    Result getReason();
}
