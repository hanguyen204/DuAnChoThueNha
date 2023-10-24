<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="css/app.css">
    @[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$">
    <div class="form-group">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">

        <input type="text" name="username" class="form-input" placeholder="Tên đăng nhập">
    <title>Form login unitop.vn</title>
    </div>
    </head>
<body>
<div id=" wrapper">
        <form action="/login" method="post" id="form-login">
            <h1 class="form-heading">Form đăng nhập</h1>

            <div class="form-group">
                <i class="far fa-user"></i>
                <i class="fas fa-key"></i>
                <input type="password" name="password" class="form-input" placeholder="Mật khẩu">
                <div id="eye">
                    <i class="far fa-eye"></i>
                </div>
            </div>
            <input type="submit" value="Đăng nhập" class="form-submit">
        </form>
    </div>

    </body>
</html>
