<%--
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<head>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="../static/js/jquery.js"></script>
    <script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
</head>
<body>
<div class="espark" style="text-align: center">

    <div class="container">
        <div class="jumbotron" style="text-align: center">
            <div style="text-align: right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h2>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />">
                        Logout</a></h2>
                </c:if>
            </div>

            <div class="alert alert-info">
                <h4> ${title}</h4>
            </div>

            <h5> ${message}</h5>
        </div>
    </div>


</div>
</body>
</html>