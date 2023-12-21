<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
 h1 {
      text-align: center;
      margin: 0;
    }
form select {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #fff;
  font-size: 16px;
  color: #555;
}

</style>
<body>

<h1>Add Expense</h1>
<% int userid = Integer.parseInt((String)request.getParameter("userid")); 
System.out.println("add expense"+ userid);
%>
<form action="AddProduct" method="post">
		<input type="hidden" value="<%=userid %>" name="userid">
		Expense Date :<input type="text" name="expdate"><br><br>
		Expense Description :<input type="text" name="expdesc"><br><br>
		Expense Type :
		<select name="exptype">
		<option type="text" value="Gadget" name="exptype">Gadget</option>
		<option type="text" value="Stationary" name="exptype">Stationary</option>
		</select><br><br>
		Amount: <input type="number" name="expamount"><br><br>
		
		<%--<input type="submit" name="clear" value="clear"> --%>
		<input type="submit" name="submit" value="submit">
	</form>
</body>
</html>