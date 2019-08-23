<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("function", "checkforreserve");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>User Functions</title>
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
	<a href="index.jsp">Login Page</a> >> User >> check for availability >>
	<h2>Reservations</h2>
	<fieldset>
		<legend>
			<h3>Check For Availability</h3>
		</legend>
		<h4>
			<form action="userservlet" method="post" onsubmit="return msg()">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td><label>Source:</label><select name="source" id="s">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>

						</select></td>
						<td>Destination:<select name="destination" id="d">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>

						</select></td>
					</tr>
					<tr>
						<td>No Of Seats:</td>
						<td colspan="2">1<input type="radio" name="seats" value="1"
							checked>&nbsp; 2<input type="radio" name="seats"
							value="2">&nbsp; 3<input type="radio" name="seats"
							value="3">&nbsp; 4<input type="radio" name="seats"
							value="4">&nbsp;
						</td>
					</tr>
					<tr>
						<td>Date Of journey</td>
						<td colspan="2"><input type="date" name="date"
							value="2019-07-01" min="2019-07-01" max="2019-07-02"></td>
					</tr>
					<tr>
						<td>Type Of Bus</td>
						<td colspan="2">Normal<input type="radio" name="bustype"
							value="N" checked>&nbsp; Delux<input type="radio"
							name="bustype" value="D">&nbsp;
						</td>
					</tr>
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
			if (document.getElementById("s").value == document
					.getElementById("d").value) {
				alert("select different destination other than source");
				return false;
			}
		}
	</script>
</body>
</html>