package com.pinnuli.dao;

import com.pinnuli.bean.Message;

import java.util.List;
import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-8-21
 */
public interface IMessage {

    public List<Message> queryMessageList(Map<String, Object> parameter);

    public List<Message> queryMessageListByPage(Map<String, Object> parameter);

    int count(Message message);
}
