<%--
  Created by IntelliJ IDEA.
  User: Adarsh
  Date: 3/13/15
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Admin Page</h1>

<p>Only admins have access to this page.</p>

<div align="right">
    <a href="${pageContext.request.contextPath}/espark/auth/logout">Logout</a>
</div>
<div align="left">
    <a href="${pageContext.request.contextPath}/espark/main/common">Common Page</a>
</div>
<div align="center" style="color: #ff0000">
    <p>ADMIN HOME PAGE ONLY ADMIN HAS ACCESS TO THIS PAGE</p>
</div>
</body>
</html>