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
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
</head>
<body>

<div id="header">
    <jsp:include page="/header.style"/>
</div>
<br/><br/><br/>

<div style="text-align: left">
    <div class="btn-group btn-block" role="group" aria-label="..." style="text-align: right">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h4>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value='/logout.do' />"
                                                                     class='btn btn-default'>
            Logout</a>
            </c:if>

            <a href="../home.do" class="btn btn-default">Espark Home</a></h4>
    </div>
</div>

<div id="content">
    <decorator:body/>
</div>

<div id="footer">
    <jsp:include page="/footer.style"/>
</div>

</body>
</html>


