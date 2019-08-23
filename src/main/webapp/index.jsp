<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Reservation Portal</title>
<link rel="stylesheet" href="decoration.css">
</head>
<body>
	<header>
		<h1><a href="index.jsp">State Road Transport Corporation</a></h1>
	</header>
	Login Page >>
	<br>
	<fieldset>
		<legend>
			<h3>Welcome User!</h3>
		</legend>
		<h4>
			<input type="button" value="Login as a Guest User"
				onclick="window.location.href='reservationpage1.jsp'">
		</h4>
		<form action="indexservlet" method="POST">
			or
			<h4>Login as an Administrator</h4>
			<table align="center">
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input type="submit" name="submit" value="Login">
		</form>
	</fieldset>
</body>
</html>