<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 03.04.2017
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name=request.getParameter("uname");
    out.print("welcome "+name);
%>