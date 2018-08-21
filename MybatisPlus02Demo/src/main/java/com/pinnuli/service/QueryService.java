package com.pinnuli.service;

import com.pinnuli.bean.Command;
import com.pinnuli.bean.CommandContent;
import com.pinnuli.bean.Message;
import com.pinnuli.dao.CommandDao;
import com.pinnuli.dao.MessageDao;
import com.pinnuli.util.Iconst;

import java.util.List;
import java.util.Random;

/**
 * @author: pinnuli
 * @date: 18-8-20
 */

public class QueryService {

    public List<Message> queryMessageList(String command, String description) {
        MessageDao messageDao = new MessageDao();
        return messageDao.queryMessageList(command, description);
    }

    public String queryByCommand(String command) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList = null;
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
}
