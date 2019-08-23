<%@page import="java.util.List"%>
<%@page import="beanClasses.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<Reservation> list = (List<Reservation>) session.getAttribute("Travellers");
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
	<a href="index.jsp">Login Page</a> >> Admin >> <a href="incomedetailspage1.jsp">Income Details page 1</a> >> Final Details
	<h2>Income Details</h2>
	<fieldset>
		<legend>
			<h3>Bus Income confirm Details are:</h3>
		</legend>
		<h4>
			<form action="adminservlet" method="post" onsubmit="return msg()">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td>Date Of journey</td>
						<td colspan="2"><%=list.get(0).getJourney().getDate()%></td>
					</tr>
					</td>
					<tr>
						<td colspan="2">List of Details:</td>
					</tr>
					<tr></tr>
				</table>
				<table border="1" align="center" width="700">
					<tr>
						<th>Si.No.</th>
						<th>JID</th>
						<th>BID</th>
						<th>BUS TYPE</th>
						<th>SOURCE</th>
						<th>DESTINATION</th>
						<th>BOOKED SEATS</th>
						<th>TOTAL INCOME</th>
					</tr>
					<%
						int total = 0;
						for (int i = 0; i < list.size(); i++) {
							Reservation Traveller = list.get(i);
							out.print("<tr><td>" + (i + 1) + "</td><td>" + Traveller.getJourney().getJid() + "</td><td>"
									+ Traveller.getJourney().getBus().getBid() + "</td><td>");
							if (Traveller.getJourney().getBus().getType().contentEquals("N"))
								out.println("Normal");
							else
								out.println("Deluxe");
							out.print("</td><td>" + Traveller.getFrom() + "</td><td>" + Traveller.getTo() + "</td><td>"
									+ Traveller.getSeats() + "</td><td>" + Traveller.getFare() + "</td></tr>");
							total += Traveller.getFare();
						}
					%>
				</table>
				<%
					out.print("<center>Total Final Income : " + total + "</center>");
				%>
				<br>
	</fieldset>
	</form>
	</h4>
</body>
</html>