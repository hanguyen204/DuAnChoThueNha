<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 19/10/2023
  Time: 10:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Confirm Logout</title>
</head>
<body>
<h1>Confirm Logout</h1>
<p>Are you sure you want to sign out ?</p>
<%--khi ấn confirm thì nó sẽ chuyển về trang đăng nhập --%>
<form action="/logout" method="post">
  <input type="submit" value="Confirm">
</form>
<%--ấn cancel thì nó sẽ trở lại trang home.jsp--%>
<form action="/home.jsp">
  <input type="submit" value="Cancel">
</form>
</body>
</html>
