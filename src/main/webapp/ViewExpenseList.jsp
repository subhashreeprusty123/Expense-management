<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="view"%>
    <%@page import="java.util.List" %>
    <%@page import="com.deloitte.Expense" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Expense List</title>
</head>
<style>

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}


th, td {
  padding: 12px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}


tr:nth-child(even) {
  background-color: #f2f2f2;
}
th {
  background-color: #344C6E;
  color: white;
}
tr:hover {
  background-color: #e5e5e5;
}

input {
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 16px;
      width: 200px;
      
    }
    

</style>
<body>


	<table border="1">
	<tr>
	<th>Expense Date</th>
	<th>Expense Description</th>
	<th>Expense type</th>
	<th>Amount</th>
	<th>Action</th>
	</tr>
	<view:forEach var="expense" items="${sessionScope.ExpenseList}">
	<tr>
	<td><view:out value="${expense.getExpense_date()}"></view:out></td>
	<td><view:out value="${expense.getExpense_type()}"></view:out></td>
	<td><view:out value="${expense.getExpense_desc()}"></view:out></td>
	<td><view:out value="${expense.getAmount()}"></view:out></td>
	<td><a href="DeleteExpense?expid=${expense.getExpense_id()}&userid=${expense.getUser_id()}">Delete</a></td>
	</tr>
	</view:forEach>
	</table>
	
	<view:set var="userid" value="${sessionScope.userid}"></view:set>
	<form action="AddExpense.jsp" method="post">
	<input type="hidden" name="userid" value='<view:out value="${userid}"></view:out>'>
	<input type="submit" value="Add Expense">
	</form>
	
	
	
	
</body>
</html>