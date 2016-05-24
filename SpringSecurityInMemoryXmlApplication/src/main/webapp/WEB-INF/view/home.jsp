<%--
       * @author Adarsh Kumar
       * @author $LastChangedBy: Adarsh Kumar$
       * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
       *
--%>
<%@page isELIgnored="false" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<br/>
<br/>

<div id="logout" align="right">
    <a href="<c:url value="/logout.do" />"> Logout</a>
</div>
<div align="left">
    <h3>Message : ${message}</h3>

    <h3>Username : ${username}</h3>
</div>
<div align="center">
    <h1> HOME PAGE </h1>

    <div align="center">

        <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
            <br><a href="superadmin/home.do">Super Admin Home</a>
        </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_ADMIN')">
            <br><a href="admin/home.do">Admin Home</a>
        </sec:authorize>

        <sec:authorize access="hasAnyRole('ROLE_SUPERADMIN','ROLE_ADMIN','ROLE_USER')">
            <br><a href="user/home.do">User Home</a>
        </sec:authorize>
    </div>
</div>
</body>
</html>