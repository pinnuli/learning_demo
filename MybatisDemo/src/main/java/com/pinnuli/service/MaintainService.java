package com.pinnuli.service;

import com.pinnuli.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-20
 */

public class MaintainService {

    public void deleteOne(String id){
        if(id != null && !"".equals(id.trim())){
            MessageDao messageDao = new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }

    public void deleteBatch(String[] ids){
        MessageDao messageDao = new MessageDao();
        List<Integer> idList = new ArrayList<Integer>();
        for(String id : ids){
            idList.add(Integer.valueOf(id));
        }
        messageDao.deleteBatch(idList);
    }
}
