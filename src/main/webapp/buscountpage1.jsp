<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("function", "countbuses");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="decoration.css">
<meta charset="ISO-8859-1">
<title>Count Buses</title>
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
	<a href="index.jsp">Login Page</a> >> Admin >> Bus Count Details
	<h2>Buses Count Details</h2>
	<fieldset>
		<legend>
			<h3>Give the Journey Details:</h3>
		</legend>
		<h4>
			<form action="adminservlet" method="post" onsubmit="return msg()">
				<table align="center" cellspacing="10" width="300">
					<tr>
						<td><label>Source:</label> <select name="source" id="s">
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
						</select>
						</td>
					</tr>
					<tr>
						<td>Start Date Of journey</td>
						<td colspan="2"><input type="date" id="start" name="date1"
							value="2019-07-01" min="2019-07-01" max="2019-07-02"></td>
					</tr>
					<tr>
						<td>End Date Of journey</td>
						<td colspan="2"><input type="date" id="end" name="date2"
							value="2019-07-01" min="2019-07-01" max="2019-07-02"></td>
					</tr>
				</table>
				<br>
				<center>
					<input type="submit" value="Get Details">
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
			} else {
				var startD = document.getElementById("start").value;
				var endD = document.getElementById("end").value;
				var startdate = new Date(startD);
				var enddate = new Date(endD);
				if (startdate > enddate) {
					alert("select end date after start date");
					return false;
				}
			}
		}
	</script>
</body>
</html>