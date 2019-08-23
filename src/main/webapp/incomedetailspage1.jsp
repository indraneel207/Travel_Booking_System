<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("function", "incomedetails");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>Admin Functions</title>
</head>
<body>
	<header>
		<h1><a href="index.jsp">State Road Transport Corporation</a></h1>
	</header>
	<nav>
		<h3>
			<a href="buscountpage1.jsp">Bus Count Details</a> | <a
				href="incomedetailspage1.jsp">Income Details</a> | <a href="passengerdetailspage1.jsp">Passenger Details</a>
		</h3>
	</nav>
	<a href="index.jsp">Login Page</a> >> Admin >> Income Details
	<h2>Income Details</h2>
	<fieldset>
		<legend>
			<h3>Give the Date of Journey-Details:</h3>
		</legend>
		<h4>
			<form action="adminservlet" method="post">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td>Date Of journey</td>
						<td colspan="2"><input type="date" name="date"
							value="2019-07-01" min="2019-07-01" max="2019-07-02"></td>
					</tr>
				</table>
				<br>
				<center>
					<input type="submit" value="Get Details">
				</center>
	</fieldset>
	</form>
	</h4>
</body>
</html>