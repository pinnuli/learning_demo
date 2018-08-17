<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/6
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>

<%--application实现用户间数据的共享，可存放全局边变量，相当于java的静态变量--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application对象</title>
</head>
<body>
    <h1>application对象</h1>
    <%
        application.setAttribute("city","广州");
        application.setAttribute("postcode","510000");
        application.setAttribute("email","guangzhou@163.com");
    %>
    所在城市：<%=application.getAttribute("city")%><br>
    所有属性：
    <%
        Enumeration attributes = application.getAttributeNames();
        while (attributes.hasMoreElements()){
            out.println(attributes.nextElement() + "&nbsp;&nbsp;");
        }
    %><br>

    jsp(serviet)引擎名和版本号：<%=application.getServerInfo()%><br>
</body>
</html>
