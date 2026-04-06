<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>

Book list:
<br>
<c:forEach items="${bookList}" var="book">
    Title: ${book.title}
    <br>
    Author: ${book.author}
    <br>
    ISBN: ${book.isbn}
    <br>
    <br>
</c:forEach>

</body>
</html>
