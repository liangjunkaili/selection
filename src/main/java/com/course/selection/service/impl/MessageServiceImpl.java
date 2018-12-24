package com.course.selection.service.impl;

import com.course.selection.bean.Message;
import com.course.selection.bean.User;
import com.course.selection.dao.MessageDao;
import com.course.selection.dao.UserDao;
import com.course.selection.dto.Result;
import com.course.selection.service.MessageService;
import com.course.selection.util.DateUtil;
import com.course.selection.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;
 @Autowired
    private UserDao userDao;
    @Override
    public Result leaveMessage(Integer uid, Integer gid, String content) {
        User user = userDao.findOneByUid(uid);
        Message message = Message.builder()
                .content(content)
                .goodsId(gid)
                .img(user.getAvatar())
                .name(user.getNickname())
                .time(DateUtil.localDateTimeFormat(LocalDateTime.now(), DateUtil.FORMAT_PATTERN1))
                .build();
        messageDao.insert(message);
        return ResultUtil.success();
    }

    @Override
    public Result reply(Integer id, String reply, String nick) {
        Message message = messageDao.findById(id);
        message.setNick(nick);
        message.setReply(reply);
        message.setReplyTime(DateUtil.localDateTimeFormat(LocalDateTime.now(), DateUtil.FORMAT_PATTERN1));
        messageDao.update(message);
        return null;
    }

}
