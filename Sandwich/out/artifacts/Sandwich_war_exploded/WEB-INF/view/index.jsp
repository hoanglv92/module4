<%--
  Created by IntelliJ IDEA.
  User: hoanglv
  Date: 22/03/2020
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Gia vi</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form id="sandwich" action="/index" method="post">
    <input type="checkbox" id="lettuce" name="lettuce" value="lettuce">
    <label for="lettuce"> lettuce</label><br>
    <input type="checkbox" id="tomato" name="tomato" value="tomato">
    <label for="tomato"> tomato</label><br>
    <input type="checkbox" id="mustard" name="mustard" value="mustard">
    <label for="mustard"> mustard</label><br>
    <input type="checkbox" id="sprouts" name="sprouts" value="sprouts">
    <label for="sprouts"> sprouts</label><br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
