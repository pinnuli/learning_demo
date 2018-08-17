<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/6
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>不常用对象</title>
</head>
<body>
    <h3>page:</h3>当前page页面的字符串描述：<%=page.toString()%><br><br>

   <h3>pageContext:</h3>用户名：从session中获取属性-<%=pageContext.getSession().getAttribute("username")%><br>
    <%--跳转到其他页面--%>
   <%--<%
       pageContext.forward("out.jsp");
   %>--%>
    include方法，包含其他页面:
        <%
            pageContext.include("out.jsp");
        %>

</body>
</html>
