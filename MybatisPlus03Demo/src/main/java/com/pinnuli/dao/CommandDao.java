package com.pinnuli.dao;

import com.pinnuli.bean.Command;
import com.pinnuli.bean.Message;
import com.pinnuli.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-20
 */

public class CommandDao {

    public List<Command> queryCommandList(String name, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = new ArrayList<Command>();
        Command command = new Command();
        command.setName(name);
        command.setDescription(description);
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行SQL语句
            commandList = sqlSession.selectList("Command.queryCommandList", command);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return commandList;
    }
}
