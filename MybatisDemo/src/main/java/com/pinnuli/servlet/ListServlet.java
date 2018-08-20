package com.pinnuli.servlet;

import com.pinnuli.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pinnuli
 */
@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //接收页面的值
        String command = request.getParameter("command");
        String description = request.getParameter("description");
        //向页面传值
        request.setAttribute("command", command);
        request.setAttribute("description", description);
        //查询消息列表
        QueryService listService = new QueryService();
        request.setAttribute("messageList", listService.queryMessageList(command, description));
        //跳转
        request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
    }
}
