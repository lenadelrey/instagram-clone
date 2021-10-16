<%--
  Created by IntelliJ IDEA.
  User: Елена Альбертовна
  Date: 25.07.2021
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create post</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-6">
            <form action="/createPost" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail" class="form-label">Description</label>
                    <input type="text" name="description" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-warning" role="alert">
                        ${requestScope.message}
                </div>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
