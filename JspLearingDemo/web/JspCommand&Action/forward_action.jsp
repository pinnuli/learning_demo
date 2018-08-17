<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/9
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward动作</title>`
</head>
<body>
    <jsp:forward page="user.jsp">
        <%--用<jsp:param "></jsp:param>添加参数--%>
        <jsp:param name="email" value="11111111@163.com"></jsp:param>
    </jsp:forward>

    <%--
    <%
        request.getRequestDispatcher("user.jsp").forward(request,response);
    %>
    --%>
</body>
</html>
