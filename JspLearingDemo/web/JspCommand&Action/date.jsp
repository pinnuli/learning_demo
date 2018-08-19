<%--
  Created by IntelliJ IDEA.
  User: pinnuli
  Date: 2018/5/9
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.*" %>
<%@ page import="java.util.Date" %>
<%
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
    String s = sdf.format(d);
    out.println(s);
%>
