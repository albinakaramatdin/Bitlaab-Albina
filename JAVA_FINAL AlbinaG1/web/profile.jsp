<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PROFILE</title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br><br>
    <h3 class="text-center">WELCOME!&nbsp;<%=user.getFulName()%></h3>
    <br><br>
    <form action="/logout" method="get">
        <button class="btn btn-success">Logout</button>
    </form>
</div>
</body>
</html>
