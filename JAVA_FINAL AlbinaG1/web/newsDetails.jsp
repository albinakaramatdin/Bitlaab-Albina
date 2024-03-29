<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.User" %>
<%@ page import="model.News" %>
<html>
<head>
    <title>Title</title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
        <%
        News news = (News) request.getAttribute("newsDetails");
        if (news!=null){
    %>
    <div class="card w-75">
        <div class="card-body">
            <h5 class="card-title"><%=news.getTitle()%></h5>
            <p class="card-text"><%=news.getContent()%></p>
            <p><%=news.getUser().getFulName()%></p>
            <p><%=news.getPostDate()%></p>
            <br>
            <%
                if (user != null) {
            %>
            <form action="addComment" method="post">
                <input type="hidden" value="<%=news.getId()%>" name="newsId">
                <textarea class="form-control" name="commentText"></textarea>
                <br>
                <button class="btn btn-success">SUBMIT</button>
            </form>
            <%}%>
        </div>
    </div>
        <%}%>
</div>
</body>
</html>
