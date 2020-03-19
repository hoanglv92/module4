<%--
  Created by IntelliJ IDEA.
  User: hoanglv
  Date: 19/03/2020
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link type="text/css" href="<c:url value="../css/style.css" />"  rel="stylesheet">
    <title>Trang chu</title>
  </head>
  <body>
  <div class="show">
  <form action="/translate" method="get">
    <input type="text" name="input">
    <input type="submit">
  </form>
  </div>
  <div class="showkq">
    <h1>Nghia: ${output}</h1>
  </div>
  </body>
</html>
