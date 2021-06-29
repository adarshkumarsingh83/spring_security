<%--
* @author Adarsh Kumar
* @author $LastChangedBy: Adarsh Kumar$
* @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
* @Espark @copyright all right reserve
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<BR/>
<BR/>
<BR/>
<BR/>

<div class="espark" style="text-align: center">

    <div class="container">
        <div class="jumbotron" style="text-align: center">
            <div class="alert alert-danger">
                <h3> ${message}</h3>
            </div>
            <h3>FOR</h3>
            <div class="alert alert-danger">
                <h3> ${username}</h3>
            </div>
        </div>
    </div>
</div>
</body>
</html>