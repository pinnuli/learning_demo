<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/5
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response内置对象</title>
</head>
<body>
    <%
        response.setContentType("text/html;charset=utf-8");
        out.println("<h1>response内置对象</h1>");
        out.println("<hr>");
        //out.flush();
        /* 因为getWrite获得的输出流对象会先于内置对象out输出，
        所以要先清空缓冲区，使out强制输出，否则结果会是先输出outer
        再输出out*/

        PrintWriter outer = response.getWriter();
        outer.println("大家好，我是response生成的输出流outer");
//        response.sendRedirect("login.jsp");//重定向
//        response.sendRedirect("request.jsp");
        request.getRequestDispatcher("request.jsp").forward(request,response);//转发
    %>
</body>
</html>
