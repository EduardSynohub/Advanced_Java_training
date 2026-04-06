<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mvc12</title>
</head>
<body>

<c:forEach begin="${start}" end="${end}" var="number">
    ${number}<br>
</c:forEach>

</body>
</html>
