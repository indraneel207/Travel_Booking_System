<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="beanClasses.Reservation"%>
<%
	session.setAttribute("function", "successreserve");
	Reservation reservation = (Reservation) session.getAttribute("newTraveller");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>Success!</title>
</head>
<body onload="myFunction()" onafterprint="myFunction2()">
	<header>
		<h1><a href="index.jsp">State Road Transport Corporation</a></h1>
	</header>
	<nav>
		<h3>
			<a href="reservationpage1.jsp">Reservation</a> | <a
				href="cancellation.jsp">Cancellation</a> | <a href="checkticket.jsp">View Ticket</a>
		</h3>
	</nav>
	<a href="index.jsp">Login Page</a> >> User >> <a href="reservationpage1.jsp">check for Reservation</a> >> Confirmed
	<h2>Reservations</h2>

	<fieldset>
		<legend>
			<h3>Ticket Details</h3>
		</legend>
		<h4>
			<form name="Form1">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td>PNR:</td>
						<td><%=reservation.getPnr()%></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><%=reservation.getName()%></td>
					</tr>
					<tr>
						<td>Id Proof:</td>
						<td><%=reservation.getId()%></td>
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
								if (reservation.getType().contentEquals("N"))
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
					<button onclick="myFun()">Print the Ticket</button>
				</center>
	</fieldset>
	</form>
	</h4>
	<script type="text/javascript">
		function myFun() {
			window.print();
		}
		function myFunction() {
			alert("Booking Confirmed!");
		}
		function myFunction2() {
			window.location.href = 'reservationpage1.jsp';
		}
	</script>
</body>
</html>