package com.course.selection.service;

import com.course.selection.dto.Result;

import java.io.IOException;

public interface UserService {

    Result login(String code, String encryptedData, String iv, String channel, String ip, Integer uid) throws IOException;
}
