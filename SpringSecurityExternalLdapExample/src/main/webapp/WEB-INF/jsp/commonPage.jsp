<%--
  Created by IntelliJ IDEA.
  User: Adarsh
  Date: 3/13/15
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All User Common Page</title>
</head>
<body>
<h1>Common Page</h1>

<p>Everyone has access to this page.</p>

<div>
    <div align="left">
        <a href="${pageContext.request.contextPath}/espark/main/admin">Admin page</a>
    </div>
    <div align="right">
        <a href="${pageContext.request.contextPath}/espark/auth/logout">Logout</a>
    </div>
</div>
<br>
<br>
<br>

<div align="center" style="color: darkgreen">
    <p>THIS IS THE COMMON PAGE FOR ALL THE USER EVERY ONE HAS ACCESS TO THIS PAGE</p>
</div>
</body>
</html>