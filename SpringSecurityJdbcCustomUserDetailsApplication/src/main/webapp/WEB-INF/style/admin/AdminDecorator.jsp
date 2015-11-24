<%--
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html>
<head>
    <title><decorator:title default="SiteMesh Integration"/></title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <decorator:head/>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
</head>
<body>

<div id="header">
    <jsp:include page="/header.style"/>
</div>
<br/><br/><br/>
<div id="logout" align="right">
    <a href="<c:url value="/logout.do" />"> Logout</a>
</div>

<div id="content">
    <decorator:body/>
</div>

<div id="footer">
    <jsp:include page="/footer.style"/>
</div>

</body>
</html>


