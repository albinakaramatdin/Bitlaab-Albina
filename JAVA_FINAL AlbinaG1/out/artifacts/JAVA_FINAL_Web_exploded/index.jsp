<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.User" %>
<%@ page import="model.News" %>
<%@ page import="db.DBManager" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <title>Index</title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <%
        List<News> news1 = DBManager.getAllNews1();
        for (News news : news1){
    %>
    <br>
    <div class="card w-75">
        <div class="card-body">
            <h5 class="card-title"><%=news.getTitle()%></h5>
            <p class="card-text"><%=news.getContent()%></p>
            <p><%=news.getUser().getFulName() + "/"+news.getUser().getEmail()%></p>
            <P><%=news.getPostDate()%></P>
            <a href="/newsDetails?id="<%=news.getId()%> class="btn btn-success">DETAILS</a>
        </div>
    </div>
    <%}%>
</div>
</body>
</html>
