<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <style type="text/css">

        #loginField {
            width: 350px;
            margin: 50px auto;
        }

        #login input[type=text], #login input[type=password] {
            width: 191px;
        }

        #login input[type=button] {
            height: 27px;
            width: 194px;
            margin: 2px 0;
        }

        #loginError {
            border: 1px solid #f00;
        }

        #loginError p {
            background: #f00;
            margin: 3px;
            color: #fff;
            padding: 5px;
        }
    </style>
    <script type="text/javascript">
        function verifyEmpty() {
            var userName = document.getElementById("j_username").value;
            var userPwd = document.getElementById("j_password").value;
            if (userName == '') {
                document.getElementById("j_username").focus();
                document.getElementById("loginError").innerHTML = "EMPTY USER NAME";
                return false;
            }
            if (userPwd == '') {
                document.getElementById("j_password").focus();
                document.getElementById("loginError").innerHTML = "EMPTY USER PWD";
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="loginError">
    <c:if test="${not empty error}">
        <fieldset style="margin:5px 5px 5px 5px;  width: 320px; ">
            <div id="error" style="background-color: rgba(247, 16, 16, 0.777344);">
                <legend><strong style="color:black;">Error Window</strong></legend>
                <c:out value="${error}"/>
            </div>
        </fieldset>
    </c:if>
</div>

<div id="loginField">
    <form id="login" action="<c:url value='j_spring_security_check' />" method="POST" onsubmit="return verifyEmpty();">
        <fieldset style="margin:5px 5px 5px 5px;  width: 320px;  background-color:rgba(220, 218, 245, 0.41);">
            <legend><strong style="color:black;">Login Window</strong></legend>
            <table>
                <tr>
                    <td>User Name</td>
                    <td> &nbsp;</td>
                    <td><input type="text" id="j_username" name="j_username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td> &nbsp;</td>
                    <td><input type="password" id="j_password" name="j_password"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" name="commit" value="Log-In"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</div>
</body>
</html>