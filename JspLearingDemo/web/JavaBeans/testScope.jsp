<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/7
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.po.Users" %>
<html>
<head>
    <title>测试scope作用范围</title>
</head>
<body>

    <jsp:useBean id="myUsers" class="com.po.Users" scope="application"></jsp:useBean>

    用户名：<jsp:getProperty name="myUsers" property="username"></jsp:getProperty><br>
    密码：<jsp:getProperty name="myUsers" property="password"></jsp:getProperty><br>

    <%--
    使用内置对象获取：
    用户名：<%=((Users)application.getAttribute("myUsers")).getUsername()%><br>
    密码： <%=((Users) application.getAttribute("myUsers")).getPassword()%><br>
    --%>
</body>
</html>
