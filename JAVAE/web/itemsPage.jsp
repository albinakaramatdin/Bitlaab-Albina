<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10.02.2024
  Time: 3:42
  To change this template use File | Settings | File Templates.
--%>
<% Item item = null; %>
<%@ page import="model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br><br>
    NAME: <span><%=item.getName()%></span>
    <br><br>
    PRICE: <span><%=item.getPrice()%></span>
    <br><br>
    AMOUNT: <span><%=item.getAmount()%></span>
    <br><br>
    <div style="display: flex">
        <div>
            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                DELETE

                DELETE
            </button>
        </div>
        <div style="margin-left: 10px">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal1">
                UPDATE
            </button>
        </div>
    </div>
    <!-- Modal for button DELETE-->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="${pageContext.request.contextPath}/deleteItem" method="post">
                    <div class="modal-body">
                        <input type="hidden" name="id" value="<%=item.getId()%>">
                        <h1 style="text-align: center">ARE YOU SURE?</h1>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
                        <button type="submit" class="btn btn-primary">YES</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Modal for button UPDATE-->
    <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="${pageContext.request.contextPath}/updateItem" method="post">
                    <div class="modal-body">
                        <div class="mb-3">
                            <input type="hidden" name="id" value="<%=item.getId()%>">
                            <label for="exampleInputEmail1" class="form-label">NAME:</label>
                            <label>
                                <input name="name" value="<%=item.getName()%>" type="text" class="form-control"
                                       aria-describedby="emailHelp">
                            </label>
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">PRICE:</label>
                            <label>
                                <input name="price" value="<%=item.getPrice()%>" type="text" class="form-control"
                                       aria-describedby="emailHelp">
                            </label>
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">AMOUNT:</label>
                            <input name="amount" value="<%=item.getAmount()%>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>