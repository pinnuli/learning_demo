package com.pinnuli.dao;

import com.pinnuli.bean.Message;
import com.pinnuli.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pinnuli
 * @date: 18-8-20
 */

public class MessageDao {

    /*public List<Message> queryMessageList(String command, String description){
        List<Message> messagesList = new ArrayList<Message>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?useSSL=false", "root", "root");

            StringBuilder sql = new StringBuilder("select ID, COMMAND, DESCRIPTION, CONTENT from message where 1=1");
            List<String> paramList = new ArrayList<String>();
            if (command != null && !"".equals(command.trim())) {
                sql.append(" and COMMAND=?");
                paramList.add(command);
            }
            if (description != null && !"".equals(description.trim())) {
                sql.append(" and DESCRIPTION like \"%\"?\"%\"");
                System.out.println(sql.toString());
                paramList.add(description);
            }
            PreparedStatement statement = conn.prepareStatement(sql.toString());
            for (int i = 0; i < paramList.size(); i++) {
                statement.setString(i + 1, paramList.get(i));
                System.out.println(statement.toString());
            }
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getString("ID"));
                message.setCommand(rs.getString("COMMAND"));
                message.setDescription(rs.getString("DESCRIPTION"));
                message.setContent(rs.getString("CONTENT"));
                messagesList.add(message);
                System.out.println(message.getId());
                System.out.println(messagesList.size());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messagesList;
    }*/

    public List<Message> queryMessageList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = new ArrayList<Message>();
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行SQL语句,这里将通过IMessage查询
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            messageList = iMessage.queryMessageList(message);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    public void deleteOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行SQL语句
            sqlSession.delete("Message.deleteOne", id);
            sqlSession.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void deleteBatch(List<Integer> idList) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            // 通过sqlSession执行SQL语句
            sqlSession.delete("Message.deleteBatch", idList);
            sqlSession.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        messageDao.queryMessageList("", "");
    }
}
