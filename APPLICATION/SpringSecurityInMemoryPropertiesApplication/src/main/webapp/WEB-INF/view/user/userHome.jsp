<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div id="logout" align="right">
    <a href="<c:url value="/logout.do" />"> Logout</a>
</div>
<div align="left" style="color: green;">
    <h3>Username : ${username}</h3>

    <h3>Message : ${message}</h3>
</div>
</body>
</html>