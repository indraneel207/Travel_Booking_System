<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>Cancellation</title>
</head>
<body>
	<header>
		<h1><a href="index.jsp">State Road Transport Corporation</a></h1>
	</header>
	<nav>
		<h3>
			<a href="reservationpage1.jsp">Reservation</a> | <a
				href="cancellation.jsp">Cancellation</a> | <a href="checkticket.jsp">View Ticket</a>
		</h3>
	</nav>
	<a href="index.jsp">Login Page</a> >> User >> <a href="cancellation.jsp">check for Cancellation</a> >> Confirmed
	<h2>Cancellations</h2>
	<fieldset>
		<legend>
			<h3>Cancellation Success!</h3>
		</legend>
		<h4>
			<center>Succesfully Cancelled a Ticket!</center>
			<input type="button" value="Go to Main page" onclick="window.location.href='index.jsp'">
	</fieldset>
	</h4>
</body>
</html>