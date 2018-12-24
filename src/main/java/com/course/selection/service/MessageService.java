package com.course.selection.service;

import com.course.selection.dto.Result;

public interface MessageService {
    Result leaveMessage(Integer uid, Integer gid, String message);

    Result reply(Integer id, String reply, String nick);
}
