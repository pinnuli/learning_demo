<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/5
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试不同页面是否是同一个session</title>
</head>
<body>

    Session的ID：
    <%=session.getId()%><br>

    Session中获取属性值：
    <%=session.getAttribute("username")%>

    <p>说明与上一个页面是同一个session</p>
    
</body>

</html>
