package com.pinnuli.service;

import com.pinnuli.bean.Message;

import java.util.List;
import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-8-27
 */
public interface MessageService {

    public List<Message> queryMessageList();

    public List<Message> queryMessageListByPage(Map<String, Object> parameter);

    int count();
}
