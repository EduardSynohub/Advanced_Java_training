<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mvc13 book</title>
</head>
<body>

<form method="post" action="/mvc13">
  <label>
    Enter title of the book:
    <input type="text" name="title">
  </label>
  <label>
    Enter author:
    <input type="text" name="author">
  </label>
  <label>
    Enter isbn:
    <input type="number" min="0" step="1" name="isbn">
  </label>
  <label>
    <button type="submit">Submit</button>
  </label>
</form>

</body>
</html>
