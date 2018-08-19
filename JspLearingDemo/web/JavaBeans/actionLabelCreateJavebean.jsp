<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/7
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用jsp动作标签创建Javabean</title>
</head>
<body>
    <jsp:useBean id="myUsers" class="com.po.Users" scope="page"></jsp:useBean>
    <h1>使用普通方式创建Javabean的实例</h1>
    <%
        myUsers.setUsername("pinnuli");
        myUsers.setPassword("123456");
    %>
    用户名：<%=myUsers.getUsername()%><br>
    密码：<%=myUsers.getPassword()%>
</body>
</html>
