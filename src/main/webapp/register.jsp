<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
</head>
<body>
<h1>Register</h1>

<% if (request.getParameter("success") != null) { %>
<p>Registration successful.</p>
<% } else if (request.getParameter("error") != null) { %>
<% if (request.getParameter("error").equals("password")) { %>
<p>Passwords do not match.</p>
<% } else if (request.getParameter("error").equals("username")) { %>
<p>Username already exists.</p>
<% } else if (request.getParameter("error").equals("insert")) { %>
<p>Error occurred while inserting user.</p>
<% } %>
<% } %>

<form action="register" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br>

  <label for="confirmPassword">Confirm Password:</label>
  <input type="password" id="confirmPassword" name="confirmPassword" required><br>

  <label for="phone">Phone:</label>
  <input type="text" id="phone" name="phone" required><br>

  <input type="submit" value="Register">
</form>
</body>
</html>