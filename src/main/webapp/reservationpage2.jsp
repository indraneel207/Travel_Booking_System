<%@page import="beanClasses.Reservation"%>
<%@page import="beanClasses.Reservation.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("function", "confirmreserve");
	Reservation reservation = (Reservation) session.getAttribute("newTraveller");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>Reservation</title>
</head>
<body onload="myFunction()">
	<header>
		<h1><a href="index.jsp">State Road Transport Corporation</a></h1>
	</header>
	<nav>
		<h3>
			<a href="reservationpage1.jsp">Reservation</a> | <a
				href="cancellation.jsp">Cancellation</a> | <a href="checkticket.jsp">View Ticket</a>
		</h3>
	</nav>
	<a href="index.jsp">Login Page</a> >> User >> <a href="reservationpage1.jsp">check for availability</a> >> Confirmation
	<h2>Reservations</h2>

	<fieldset>
		<legend>
			<h3>Confirm Details</h3>
		</legend>
		<h4>
			<form name="Form1" action="userservlet" method="post"
				onsubmit="return msg()">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name"
							placeholder="enter your text here"></td>
					</tr>
					<tr>
						<td>Id Proof:</td>
						<td><input type="text" name="idproof"
							placeholder="enter your text here"></td>
					</tr>
					<tr>
						<td>Source:</td>
						<td><%=reservation.getFrom()%></td>
					</tr>
					<tr>
						<td>Destination:</td>
						<td><%=reservation.getTo()%></td>
					</tr>
					<tr>
						<td>Route Id:</td>
						<td><%=reservation.getRoute().getRid()%></td>
					</tr>
					<tr>
						<td>No Of Seats:</td>
						<td colspan="2"><%=reservation.getSeats()%></td>
					</tr>
					<tr>
						<td>Date Of journey</td>
						<td colspan="2"><%=reservation.getDate()%></td>
					</tr>
					<tr>
						<td>Type Of Bus</td>
						<td colspan="2">
							<%
								if (reservation.getType().contains("N"))
									out.println("Normal");
								else
									out.println("Deluxe");
							%>
						</td>
					</tr>
					<tr>
						<td>Total Fare:</td>
						<td><%=reservation.getFare()%> * <%=reservation.getSeats()%>
							= <%=reservation.getFare() * reservation.getSeats()%></td>
					</tr>
				</table>
				<br>
				<center>
					<input type="submit" value="Confirm Booking">
				</center>
	</fieldset>
	</form>
	</h4>
	<script type="text/javascript">
		function myFunction() {
			alert("Seats are available!");
		}
		function msg() {
			var name = document.forms["Form1"]["name"];
			var idproof = document.forms["Form1"]["idproof"];
			if (idproof.value == "" || idproof.value.length != 12) {
				window.alert("Please enter your valid idproof!");
				idproof.focus();
				return false;
			}
			if (name.value == "" || name.value == "name") {
				window.alert("Please enter your valid name!");
				name.focus();
				return false;
			}
		}
	</script>
</body>
</html>