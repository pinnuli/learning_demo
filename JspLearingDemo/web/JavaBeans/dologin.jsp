<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/7
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setProperty动作标签</title>
</head>
<body>
    <jsp:useBean id="myUsers" class="com.po.Users" scope="application"></jsp:useBean>

    <%--根据表单自动匹配所有属性--%>
    <%--
    <jsp:setProperty name="myUsers" property="*"></jsp:setProperty>
    --%>

    <%--根据表单匹配部分属性--%>
    <%--
    <jsp:setProperty name="myUsers" property="username"></jsp:setProperty>
    -->

    <%--与表单无关，通过手工赋值给属性--%>
    <%--
    <jsp:setProperty name="myUsers" property="password" value="hahahaha"></jsp:setProperty>
    --%>

    <%--通过url传参数给属性赋值--%>
    <jsp:setProperty name="myUsers" property="password" param="testparam"></jsp:setProperty>
    <jsp:setProperty name="myUsers" property="username" value="pinnuli"></jsp:setProperty>

    <%--使用传统表达式获取属性值--%>
    <%--
    用户名：<%=myUsers.getUsername()%><br>
    密码：<%=myUsers.getPassword()%>
    -->

    <%--使用getProperty获取属性值--%>
    用户名：<jsp:getProperty name="myUsers" property="username"></jsp:getProperty><br>
    密码：<jsp:getProperty name="myUsers" property="password"></jsp:getProperty><br>

    <a href="testScope.jsp">测试scope的作用范围</a>
</body>
</html>
