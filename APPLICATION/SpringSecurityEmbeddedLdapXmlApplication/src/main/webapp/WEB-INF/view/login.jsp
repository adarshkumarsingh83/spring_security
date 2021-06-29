<%--
* @author Adarsh Kumar
* @author $LastChangedBy: Adarsh Kumar$
* @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
* @Espark @copyright all right reserve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="espark" style="text-align: center">
    <div class="container">
        <div class="jumbotron" style="text-align: center">
            <form id="login" action="<c:url value='j_spring_security_check' />" method="POST">
                <fieldset class="alert-success">
                    <legend><strong style="color:black;">Login Window</strong></legend>
                    <c:if test="${not empty error}">
                        <fieldset>
                            <div class="alert-danger">
                                <h3><c:out value="${error}"/></h3>
                            </div>
                        </fieldset>
                    </c:if>

                    <div class="form-group" style="text-align: left">
                        <label for="j_username">Username</label>
                        <input type="text" id="j_username" name="j_username" class="form-control" required/>
                    </div>
                    <div class="form-group" style="text-align: left">
                        <label for="j_password">Password</label>
                        <input type="password" id="j_password" name="j_password" class="form-control" required/>
                    </div>
                    <div class="form-actions">
                        <button type="submit" ng-disabled="form.$invalid || dataLoading"
                                class="btn btn-danger btn-block">Login
                        </button>
                    </div>
                </fieldset>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

        </div>
    </div>
</div>
</body>
</html>