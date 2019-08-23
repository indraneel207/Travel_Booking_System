<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String message = (String) session.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>Failed!</title>
</head>
<body>
	<header>
		<h1>State Road Transport Corporation</h1>
	</header>
	<nav>
		<h3>
			<a href="reservationpage1.jsp">Reservation</a> | <a
				href="cancellation.jsp">Cancellation</a> | <a href="index.jsp">Start
				Page</a>
		</h3>
	</nav>
	<h2>Reservations</h2>
	<fieldset>
		<legend>
			<h3>Failed!</h3>
		</legend>
		<h3><%=message%></h3>
	</fieldset>
</body>
</html>