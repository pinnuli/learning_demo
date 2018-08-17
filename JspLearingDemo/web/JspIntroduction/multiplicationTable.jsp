<%@ page import="java.util.concurrent.Callable" %><%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/4
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        // 通过表达式实现
        String printMultiTable1(){
            String s = "";
            for (int i=1; i<=9; i++){
                for (int j=1; j<=i;j++){
                    s += i + "*" + j + "=" + (i*j) + "&nbsp;&nbsp;&nbsp;";
                }
                s += "<br>"; //换行
            }
            return s;
        }

        // 通过脚本实现
        void printMultiTable2(JspWriter out) throws Exception{
            for (int i=1; i<=9; i++){
                for (int j = 1; j <= i; j++) {
                    out.println(i + "*" + j + "=" + (i*j) + "&nbsp;&nbsp;&nbsp;");
                }
                out.println("<br>");
            }
        }
    %>

    <h1>九九乘法表</h1>
    <%= printMultiTable1()%>
    <br>
    <% printMultiTable2(out);%>

</body>
</html>
