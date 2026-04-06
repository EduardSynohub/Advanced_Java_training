<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login with filter</title>
</head>
<body>

<p style="color:red;">
  ${error}
</p>

<form  method="post" action="/login">
  <label>
    Login: <input type="text"  name="username"/>
  </label>
  <label>
    Password: <input name="password" type="password"/>
  </label>
  <button type="submit">Sign in</button>
</form>




</body>
</html>
