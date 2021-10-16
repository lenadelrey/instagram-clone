<%--
  Created by IntelliJ IDEA.
  User: Елена Альбертовна
  Date: 29.07.2021
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-6">
            <p>User <a href="/account?userId=${requestScope.post.user.id}">${requestScope.post.user.name}</a></p>
            <p>Description: ${requestScope.post.description}</p>
            <form action="/like" method="post">
                <input type="hidden" value="${requestScope.post.id}" name="postId">
                <button type="submit" class="btn btn-primary">Like</button>
            </form>
            <p>${requestScope.likes}</p>
            <c:if test="${requestScope.isCreator}">
                <a href="/editPost?postId=${requestScope.post.id}">Edit</a>
                <form action="/deletePost" method="post">
                    <input type="hidden" value="${requestScope.post.id}" name="postId">
                    <button type="submit" class="btn btn-primary">Delete post</button>
                </form>
            </c:if>
            <c:forEach var="comment" items="${requestScope.comments}">
                <p><a href="/account?userId=${comment.user.id}">${comment.user.name}:</a></p>
                <p class="card-text"><c:out value="${comment.text}"/></p>
            </c:forEach>
            <form action="/createComment" method="post">
                <div class="mb-3">
                    <input type="hidden" value="${requestScope.post.id}" name="postId">
                    <label for="exampleInputEmail" class="form-label">Add comment</label>
                    <input type="text" name="comment" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
