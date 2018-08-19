<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/4
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out内置对象</title>
</head>
<body>
    <h1></h1>
    <%
        out.println("<h2>静夜思</h2>");
        out.println("床前明月光<br>");
        out.println("疑是地上霜<br>");
        out.flush();
        /*out.clear();会抛出异常*/
        out.clearBuffer();//这里不会抛出异常
        out.println("举头望明月<br>");
        out.println("低头思故乡<br>");
    %>
    缓冲区大小：<%= out.getBufferSize()%>byte<br>
    缓冲区剩余大小：<%= out.getRemaining()%>byte<br>
    是否自动清空缓冲区：<%= out.isAutoFlush()%><br>

</body>
</html>
