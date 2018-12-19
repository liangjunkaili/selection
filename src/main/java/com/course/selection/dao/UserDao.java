package com.course.selection.dao;

import com.course.selection.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface UserDao {
    User findOneByOpenId(@Param("openId") String openId);

    void insert(@Param("user") User user);

    void update(@Param("avatar") String avatar,@Param("nickname") String nickname,@Param("gender") Integer gender,@Param("uid") Integer uid);

    User findOneByUid(@Param("uid") int uid);

    void updateActiveTime(@Param("uids") Set<Integer> activeUids);
}
