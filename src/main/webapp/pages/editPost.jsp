<%--
  Created by IntelliJ IDEA.
  User: Елена Альбертовна
  Date: 01.08.2021
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit post</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-6">
            <form action="/editPost" method="post">
                <div class="mb-3">
                    <input type="hidden" value="${param.postId}" name="postId">
                    <label for="exampleInputEmail" class="form-label">Description</label>
                    <input type="text" name="description" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
