<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Register</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        h1 {
            font-family: Arial, sans-serif;
        }

        .alert-danger {
            font-family: Arial, sans-serif;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 mt-5">
            <h1 class="text-center">Register to be a homeowner</h1>
            <c:if test="${not empty message}">
                <div class="alert alert-danger">${message}</div>
            </c:if>
            <form action="/register_Host" method="post">
                <div class="mb-3">
                    <label class="form-label">Username:</label>
                    <input type="text" class="form-control" name="username" placeholder="Username" pattern="^[a-zA-Z0-9]+([._-][a-zA-Z0-9]+)*@gmail\.com$" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone:</label>
                    <input type="text" class="form-control" name="phone" placeholder="Phone" pattern="^(\\+?84|0)[0-9]{9,10}$" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Password:</label>
                    <input type="password" class="form-control" name="password" placeholder="Password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,32}$" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Confirm Password:</label>
                    <input type="password" class="form-control" name="confirm-password" placeholder="Confirm Password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,32}$" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>