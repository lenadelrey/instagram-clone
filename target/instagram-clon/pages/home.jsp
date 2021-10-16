<%--
  Created by IntelliJ IDEA.
  User: Елена Альбертовна
  Date: 25.07.2021
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <c:forEach var="post" items="${requestScope.posts}">
                <div class="card mt-5 mb-2">
                    <div class="card-body">
                        <h5 class="card-title">${post.user.name}</h5>
                        <p class="card-text"><c:out value="${post.description}"/></p>
                        <form action="/like" method="post">
                            <input type="hidden" value="${requestScope.post.id}" name="postId">
                            <button type="submit" class="btn btn-primary">Like</button>
                        </form>
                        <p>${requestScope.likes}</p>
                        <a href="/post?id=${post.id}" class="btn btn-primary">Go to post</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
