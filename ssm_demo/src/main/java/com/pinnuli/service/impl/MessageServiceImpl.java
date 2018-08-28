package com.pinnuli.service.impl;

import com.pinnuli.bean.Message;
import com.pinnuli.dao.MessageDao;
import com.pinnuli.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-8-27
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> queryMessageList() {
        return messageDao.queryMessageList();
    }

    @Override
    public List<Message> queryMessageListByPage(Map<String, Object> parameter) {
        return messageDao.queryMessageListByPage(parameter);
    }

    @Override
    public int count() {
        return messageDao.count();
    }

}
