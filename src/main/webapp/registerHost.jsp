<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 18/10/2023
  Time: 9:53 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Register</title>
</head>
<body>
<div style="text-align: center">
    <form action="register_Host" method="post">
        <h1 class="form-heading">Đăng kí Làm chủ nhà</h1>
        <c:if test="${not empty message}">
            <div style="color: red">${message}</div>
        </c:if>
        <div>
            <i>UserName: </i>
            <input type="text" name="username" placeholder="User Name" pattern="^[a-zA-Z0-9]+([._-][a-zA-Z0-9]+)*@gmail\\.com$">
        </div>
        <div>
            <i>Avatar: </i>
            <input type="text" name="url_image" placeholder="Link Url" >
        </div>
        <div>
            <i>Full Name: </i>
            <input type="text" name="full_name" placeholder="Input Full Name">
        </div>
        <div>
            <i>Address: </i>
            <input type="text" name="address" placeholder="Input Address">
        </div>
        <div>
            <i>Phone: </i>
            <input type="text" name="phone" placeholder="Tel" pattern="^(\\+?84|0)[0-9]{9,10}$">
        </div>
        <div>
            <i>Password: </i>
            <input type="password" name="password" placeholder="Password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,32}$">
        </div>
        <div>
            <i>Confirm Password: </i>
            <input type="password" name="confirm-password" placeholder="Confirm Password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,32}$">
        </div>
        <input type="submit" value="Xác nhận đăng ký" >
    </form>
</div>
</body>
</html>
