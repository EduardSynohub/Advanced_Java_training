<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Even numbers</title>
</head>
<body>

<c:forEach begin="2" end="10" step="2" var="number">
  ${number}<br>
</c:forEach>


</body>
</html>
