<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/7
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--与创建普通java类一样，然后导入Javabean--%>
<%@page import="com.po.Users" %>

<html>
<head>
    <title>使用普通方式创建Javabean的实例</title>
</head>
<body>
    <h1>使用普通方式创建Javabean的实例</h1>
    <%
        Users user = new Users();
        user.setUsername("pinnuli");
        user.setPassword("123456");
    %>
    用户名：<%=user.getUsername()%><br>
    密码：<%=user.getPassword()%>
</body>
</html>
