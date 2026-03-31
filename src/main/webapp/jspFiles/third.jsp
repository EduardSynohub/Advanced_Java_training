<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Third</title>
</head>
<body>
<%
  String a = request.getParameter("a");
  String b = request.getParameter("b");

  if (a != null && b != null) {
%>

This is a: <%= a %>
<br>
<br>
This is b: <%= b %>

<%
  } else {
%>
This is a: none
<br>
<br>
This is b: none
<%
  }
%>
</body>
</html>
