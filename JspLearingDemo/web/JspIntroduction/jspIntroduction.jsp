<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/3
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp学习</title>
</head>
<body>
<h1>大家好啊！</h1>
<!-- 这是html注释，客户端可见 -->
<%-- 这是jsp注释，客户端不可见 --%>

<%--jsp脚本--%>
<%
    // 单行注释
    /*多行注释*/
    out.println("大家好，我在学jsp");
%>

<%--jsp声明变量方法--%>
<%!
    String name = "pinnuli";
    int add(int x, int y){
        return  x+y;
    }
%>

<%--jsp表达式--%>
<h2>hello, <%=name %></h2>
<p>x+y= <%= add(10,5)%></p>

</body>
</html>

