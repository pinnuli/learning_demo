<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/4
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>request内置对象</title>
</head>
<body>
    <%
        request.setCharacterEncoding("utf-8");//解决post中文乱码问题，但无法解决get，get解决需要直接Tomcat配置文件
        request.setAttribute("password","123456");//设置属性密码
    %>
    用户名：<%= request.getParameter("username")%><br>
    爱好：
    <%
        if(request.getParameterValues("favorite") != null){  //这里需要判断为不为空，jsp这里不能将String数组看为Boolean
            String[] favorites = request.getParameterValues("favorite");
            for (int i = 0; i < favorites.length; i++) {
                out.println(favorites[i] + "&nbsp;&nbsp;&nbsp;");
            }
        }
        String realPath = request.getRealPath("requset.jsp");%><br>

    密码：
    <%=request.getAttribute("password")%><br>

    请求体的MIME类型：
    <%=request.getContentType()%><br>

    协议类型和版本号：
    <%=request.getProtocol()%><br>

    服务器主机名：
    <%=request.getServerName()%><br>

    服务器端口号：
    <%=request.getServerPort()%><br>

    请求文件长度：
    <%=request.getContentLength()%><br>

    请求的客户端地址：
    <%=request.getRemoteAddr()%><<br>

    请求的真实路径：
    <%=request.getRealPath("requset.jsp")%><br>

    请求的上下文路径：
    <%=request.getContextPath()%>






</body>
</html>