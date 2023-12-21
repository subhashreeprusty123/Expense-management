<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>
form {
  max-width: 400px;
  margin: 0 auto;
}

/* Style form inputs */
form input {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  box-sizing: border-box;
}
form a {
  color: #007bff; /* Change to your preferred text color */
  text-decoration: none;
}

/* Add hover effect to the anchor within a form */
form a:hover {
  text-decoration: underline;
}
 h1 {
      text-align: center;
      margin: 0;
    }
</style>
<body>
	<h1>Login</h1>
	
	<form action="LoginUser" method="post">
	Username: <input type="text" name="username" required><br><br>
	Password: <input type="password" name="password" required="required"><br><br>
	<input type="submit" value="submit">
	<a href="NewUser.jsp">New User</a>
	</form>
	
</body>
</html>