package com.pinnuli.servlet;

import com.pinnuli.entity.Page;
import com.pinnuli.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author pinnuli
 */
@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {

    private Pattern pattern = Pattern.compile("[0-9]{0,9}");

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
        String currentPage = request.getParameter("currentPage");

        //创建分页对象
        Page page = new Page();
        if(currentPage == null || !pattern.matcher(currentPage).matches()){
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(Integer.valueOf(currentPage));
        }
        QueryService listService = new QueryService();
        //查询消息列表并传给页面
        request.setAttribute("messageList", listService.queryMessageListByPage(command, description, page));
        System.out.println(page.getCurrentPage());
        //向页面传值
        request.setAttribute("command", command);
        request.setAttribute("description", description);
        request.setAttribute("page", page);
        //跳转
        request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
    }
}
