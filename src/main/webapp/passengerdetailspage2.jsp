<%@page import="java.util.List"%>
<%@page import="beanClasses.Reservation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<Reservation> travellers = (List<Reservation>) session.getAttribute("Travellers");
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
	</nav>
	<a href="index.jsp">Login Page</a> >> Admin >> <a href="passengerdetailspage1.jsp">Journey Details</a> >> Final Details
	<h2>Passenger Details</h2>
	<fieldset>
		<legend>
			<h3>The Passenger Details are:</h3>
		</legend>
		<h4>
			<form action="adminservlet" method="post" onsubmit="return msg()">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td>Route Id: <%=travellers.get(0).getRoute().getRid()%></td>
						<td>Journey Id: <%=travellers.get(0).getJourney().getJid()%></td>
					</tr>
					<tr>
						<td>Source:</td>
						<td><%=travellers.get(0).getFrom()%></td>
					</tr>
					<tr>
						<td>Destination:</td>
						<td><%=travellers.get(0).getTo()%></td>
					</tr>
					<tr>
						<td>Date Of journey:</td>
						<td colspan="2"><%=travellers.get(0).getDate()%></td>
					</tr>
					<tr>
						<td>Type Of Bus:</td>
						<td colspan="2">
							<%
								if (travellers.get(0).getType().contentEquals("N"))
									out.println("Normal");
								else
									out.println("Deluxe");
							%>
						</td>
					</tr>
					<tr>
						<td colspan="2">List of Details:</td>
					</tr>
					<tr></tr>
				</table>
				<table border="1" align="center" width="500">
					<tr>
						<th>Si.No.</th>
						<th>PNR</th>
						<th>NAME</th>
						<th>SEATS</th>
						<th>IDPROOF</th>
					</tr>
					<%
						for (int i = 0; i < travellers.size(); i++) {
							Reservation newReservation = travellers.get(i);
							out.print("<tr><td>" + (i + 1) + "</td><td>" + newReservation.getPnr() + "</td><td>"
									+ newReservation.getName() + "</td><td>" + newReservation.getSeats() + "</td><td>"
									+ newReservation.getId() + "</td></tr>");
						}
					%>
				</table>
				<br>
	</fieldset>
	</form>
	</h4>
	<script type="text/javascript">
		function msg() {
			if (document.getElementById("s").value == document
					.getElementById("d").value) {
				alert("select different destination other than source");
				return false;
			}
		}
	</script>
</body>
</html>