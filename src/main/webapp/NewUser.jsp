<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
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
input {
  width: 50%;
  padding: 10px;
  margin-bottom: 10px;
  box-sizing: border-box;
}
 h1 {
      text-align: center;
      margin: 0;
    }
</style>
<body>
	<h1>New User</h1>
	<form action="AddUser" method="post">
	Name: <input type="text" name="name"  required><br><br>
	Username: <input type="text" name="username"  required><br><br>
	Password: <input type="password" name="password"  required="required"><br><br>
	<input type="submit" value="submit">
	
	</form>
	<input type="submit" value="cancel">
</body>
</html>