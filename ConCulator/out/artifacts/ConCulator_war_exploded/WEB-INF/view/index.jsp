<%--
  Created by IntelliJ IDEA.
  User: hoanglv
  Date: 22/03/2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>May tinh</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/index" method="post">
    <input type="text" name="snt">
    <input type="text" name="sth"><br>
    <input type="submit" name="orerator" value="+">
    <input type="submit" name="orerator" value="-">
    <input type="submit" name="orerator" value="*">
    <input type="submit" name="orerator" value="/">
  </form>
  <br>
  <h2 style="color: red">
    ket qua: ${result}
  </h2>
  </body>
</html>
