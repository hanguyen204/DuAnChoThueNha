<%--
  Created by IntelliJ IDEA.
  User: namca
  Date: 10/19/23
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: auto;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 90vh;
            background-image: url("https://bizweb.dktcdn.net/100/348/067/files/thang-may-phuc-loc-518ead6c-f892-4f5f-8e45-ab315534ddf4.jpg?v=1593109233715");
        }

        .login-container {
            background-color: white;
            border-radius: 20px;
            padding: 40px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;

        }

        .login-container h2 {
            margin-bottom: 20px;
        }

        .login-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .login-container button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        .login-container button:hover {
            background-color: #45a049;
        }

        .not empty {
            color: red;
            margin-top: 10px;
        }

        .button-class {
            text-align: center;
        }

        .h2-class {
            text-align: center;
        }
        .forgot{
            text-align: right;
        }
    </style>
</head>
<body>
<form action="/servlet_Login" method="post">
    <div class="login-container">
        <div class="h2-class">
            <h2>Login</h2>
        </div>
        <div>
            Username: <input type="text" name="username" required><br>
            Password: <input type="password" name="password" required><br>
        </div>
        <div class="button-class">
            <button type="submit">Login</button>
        </div>
        <div>
            <c:if test="${not empty error}">
                <p>${error}</p>
            </c:if>
        </div>
        <div class="forgot"><a href="forgotPassword.jsp">Quên mật khẩu?</a></div>
    </div>
</form>
</body>
</html>
