package com.pinnuli.service;

import com.pinnuli.bean.Command;
import com.pinnuli.bean.CommandContent;
import com.pinnuli.bean.Message;
import com.pinnuli.dao.CommandDao;
import com.pinnuli.dao.MessageDao;
import com.pinnuli.entity.Page;
import com.pinnuli.util.Iconst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author: pinnuli
 * @date: 18-8-20
 */

public class QueryService {

    public List<Message> queryMessageList(String command, String description, Page page) {
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        MessageDao messageDao = new MessageDao();
        int totalNumber = messageDao.count(message);
        page.setTotalNumber(totalNumber);
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("message", message);
        parameter.put("page", page);
        return messageDao.queryMessageList(parameter);
    }

    public String queryByCommand(String command) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList;
        if(Iconst.HELP_COMMAND.equals(command)){
            commandList = commandDao.queryCommandList(null, null);
            StringBuilder result = new StringBuilder();
            System.out.println(commandList.size());
            for (int i = 0; i < commandList.size(); i++) {
                if(i != 0 ){
                    result.append("<br/>");
                }
                result.append("回复【" + commandList.get(i).getName() + "】可以查看" + commandList.get(i).getDescription());
            }
            return result.toString();
        }
        commandList = commandDao.queryCommandList(command, null);
        if(commandList.size()>0){
            List<CommandContent> contentList = commandList.get(0).getContentList();
            int i = new Random().nextInt(contentList.size());
            return contentList.get(i).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }

    public List<Message> queryMessageListByPage(String command, String description, Page page) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        parameter.put("message", message);
        parameter.put("page", page);
        MessageDao messageDao = new MessageDao();

        return messageDao.queryMessageListByPage(parameter);
    }
}
