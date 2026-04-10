<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author</title>
</head>
<body>

<p>
    Selected author: <c:out value="${param.author}" default="default author"/>
</p>

<p>
    <c:if test="${not empty param.author}">
        Selected author: ${param.author}
    </c:if>
</p>

</body>
</html>
