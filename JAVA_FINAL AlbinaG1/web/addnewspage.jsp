<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.User" %>
<html>
<head>
    <title>Add Blog Page </title>
    <%@include file="links.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br>
    <div class="row mt-3">
        <div class="col-6 mx-auto">
            <form action="/addNews" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Title News</label>
                    <input name="title" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Content</label>
                    <textarea name="content" class="form-control"></textarea>
                </div>
                <button type="submit" class="btn btn-success">Enter</button>
            </form>
        </div>
    </div>
</body>
</html>
