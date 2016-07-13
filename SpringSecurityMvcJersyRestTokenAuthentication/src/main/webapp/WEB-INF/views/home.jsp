<%--
* @author Adarsh Kumar
* @author $LastChangedBy: Adarsh Kumar$
* @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
* @Espark @copyright all right reserve
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="espark" style="text-align: center">

    <div class="container">
        <div class="jumbotron" style="text-align: center">
            <div class="alert alert-info">
                <h4> ${message}</h4>
            </div>

            <h3>Username : ${username}</h3>

        </div>
        <div class="btn-group btn-block" role="group" aria-label="..." style="text-align: right">
            <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
                <a href="superadmin/home.do" class="btn btn-default">Super Admin Home</a>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPERADMIN')">
                <a href="admin/home.do" class="btn btn-default">Admin Home</a>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPERADMIN')">
                <a href="user/home.do" class="btn btn-default">User Home</a>
            </sec:authorize>
        </div>

    </div>

</div>

</body>
</html>