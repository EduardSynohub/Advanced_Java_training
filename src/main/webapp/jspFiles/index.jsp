<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Java Server Pages</title>
</head>
<body>
<a href="header.jsp">Header</a>
<br>
<br>
<jsp:include page="header.jsp"/>
<a href='<c:url value="/setCookieFoo"/>'>Set Cookie foo</a>
<br>
<a href="jsp3.jsp">Book form</a>
<br>
<a href="/mvc14">Book list</a>
<br>
<a href="login.jsp">Admin filter</a>

<jsp:include page="footer.jsp"/>
<br>
<br>
<a href="footer.jsp">Footer</a>
</body>
</html>
