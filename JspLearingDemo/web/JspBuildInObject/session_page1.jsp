<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/5
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session内置对象</title>
</head>
    <%--
    HttpSession的实例，
    周期：在第一个jsp页面被加载时自动创建，
    即浏览器连接到服务器开始，关闭浏览器离开这个服务器结束，
    在服务器的几个页面之间切换，服务器应当知道这是一个客户，
    就可以用session对象
    --%>

<body>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
        Date d = new Date(session.getCreationTime());
        session.setAttribute("username","pinnuli");
        session.setAttribute("password","123456");
        session.setAttribute("age",20);
//        session.setMaxInactiveInterval(10);

//设置session最大生成期限，单位秒,也可在web.xml中设置session-timeout

    %>
    Session创建时间：
    <%=sdf.format(d)%><br>

    Session的ID：
    <%=session.getId()%><br>

    Session中获取属性值：
    <%=session.getAttribute("username")%><br>

    Session保存的属性数组：
    <%
        String[] names = session.getValueNames();
        for(int i=0; i<names.length; i++){
            out.println(names[i] + "&nbsp;&nbsp;");
        }
//        session.invalidate();//销毁当前会话,每次刷新一次页面就会新建一个session
    %><br>
    <%--测试不同页面是否同一个session--%>
    <a href="session_page2.jsp">跳转到session_page2</a>
</body>

</html>
