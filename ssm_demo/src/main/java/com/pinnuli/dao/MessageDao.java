package com.pinnuli.dao;

import com.pinnuli.bean.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: pinnuli
 * @date: 18-8-27
 */
@Repository
public interface MessageDao {

    public List<Message> queryMessageList();

    public List<Message> queryMessageListByPage(Map<String, Object> parameter);

    int count();
}
