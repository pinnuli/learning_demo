package com.pinnuli.dao;

import com.pinnuli.bean.Message;

import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-21
 */
public interface IMessage {

    public List<Message> queryMessageList(Message message);

}
