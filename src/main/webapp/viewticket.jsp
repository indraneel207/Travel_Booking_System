<%@page import="beanClasses.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Reservation reservation = (Reservation)session.getAttribute("newTraveller");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>View Ticket</title>
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
	<a href="index.jsp">Login Page</a> >> User >> <a href="checkticket.jsp">check for Ticket</a> >> View-Ticket
	<h2>View Ticket</h2>
	<fieldset>
		<legend>
			<h3>Ticket:</h3>
		</legend>
		<h4>
			<h3>Ticket Details:</h3>
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td><label>Route Id:</label></td><td><%=reservation.getRoute().getRid()%></td>
					</tr>
					<tr>
						<td><label>Bus Id:</label></td><td><%=reservation.getJourney().getBus().getBid()%></td>
					</tr>
					<tr>
						<td><label>PNR:</label></td><td><%=reservation.getPnr()%></td>
					</tr>
					<tr>
						<td><label>Name</label></td><td><%=reservation.getName()%></td>
					</tr>
					<tr>
						<td><label>Id:</label></td><td><%=reservation.getId()%></td>
					</tr>
					<tr>
						<td><label>From:</label></td><td><%=reservation.getFrom()%></td>
					</tr>
					<tr>
						<td><label>To:</label></td><td><%=reservation.getTo()%></td>
					</tr>
					<tr>
						<td><label>Seats:</label></td><td><%=reservation.getSeats()%></td>
					</tr>
					<tr>
						<td><label>Date Of Journey:</label></td><td><%=reservation.getDate()%></td>
					</tr>
					<tr>
						<td><label>Bus Type:</label></td><td><%=reservation.getType()%></td>
					</tr>
				</table>
				<br>
				<center>
					<input type="button" value="Go to Main page" onclick="window.location.href='index.jsp'">
				</center>
	</fieldset>
	</h4>
</body>
</html>