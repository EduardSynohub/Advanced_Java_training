<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First jsp file</title>
</head>
<body>

<p>Kilometers = ${param.get("km")}, miles = ${param.get("km") * 0.62}</p>
<p>Parameter km : <%= request.getParameter("km")%> </p>
<p>Parameter miles : <%= request.getParameter("miles")%> </p>

</body>
</html>
