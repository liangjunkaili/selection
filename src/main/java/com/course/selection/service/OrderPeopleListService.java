package com.course.selection.service;

import com.course.selection.dto.Result;

public interface OrderPeopleListService {
    Result getMyPoster(Integer uid);

    Result addPeople( Integer oid, String name, Integer gender, String phone, String birthdayTime, String address);

    Result getPeople(Integer oid);
}
