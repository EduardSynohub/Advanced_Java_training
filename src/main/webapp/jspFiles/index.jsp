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

<jsp:include page="footer.jsp"/>
<br>
<br>
<a href="footer.jsp">Footer</a>
</body>
</html>
