<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("function", "checkforticket");
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
	<a href="index.jsp">Login Page</a> >> User >> check for Ticket
	<h2>View Ticket</h2>
	<fieldset>
		<legend>
			<h3>Check For Ticket</h3>
		</legend>
		<h4>
			<form action="userservlet" method="post" onsubmit="return msg()">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td><label>PNR:</label><input type="number" name="pid" id="s"></td>
				</table>
				<br>
				<center>
					<input type="submit" value="Check">
				</center>
	</fieldset>
	</form>
	</h4>
	<script type="text/javascript">
		function msg() {
			if (document.getElementById("s").value.length != 5) {
				alert("Give 5 digit Correct PNR number");
				return false;
			}
		}
	</script>
</body>
</html>