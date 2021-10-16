<%--
  Created by IntelliJ IDEA.
  User: Елена Альбертовна
  Date: 25.07.2021
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/registration" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail" class="form-label">Name</label>
        <input type="text" name="name" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Login</label>
        <input type="text" name="login" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<c:if test="${requestScope.message != null}">
    <div class="alert alert-warning" role="alert">
            ${requestScope.message}
    </div>
</c:if>
</body>
</html>
