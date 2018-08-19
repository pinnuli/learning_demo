<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/4
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>get与post</title>
</head>
<body>
    <h1>用户登录</h1>

    <form name="regFrom" action="request.jsp" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"/></td>
            </tr>

            <tr>
                <td>爱好：</td>
                <td><input type="checkbox" name="favorite" value="read"/>读书</td>
                <td><input type="checkbox" name="favorite" value="music"/>音乐</td>
                <td><input type="checkbox" name="favorite" value="movie"/>电影</td>
                <td><input type="checkbox" name="favorite" value="internet"/>上网</td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>


        <br>
        <br>
        <a href="request.jsp?username=林晓乙">url传参</a>;

    </form>
</body>
</html>
