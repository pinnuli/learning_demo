package com.pinnuli.servlet;

import com.pinnuli.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AutoReplyServlet")
public class AutoReplyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        QueryService queryService = new QueryService();
        out.write(queryService.queryByCommand(request.getParameter("content")));
        System.out.println(request.getParameter("content"));
        out.flush();
        out.close();
    }
}
