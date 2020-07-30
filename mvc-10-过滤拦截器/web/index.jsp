<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <h1>${message}</h1>
  <body>
  <form action="${pageContext.request.contextPath}/login.do" method="post">
    <p>username<input type="text" name="username"></p>
    <p>password<input type="password" name="password"></p>
    <p><input type="submit"></p>
  </form>
  </body>
</html>
