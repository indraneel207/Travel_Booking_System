<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("function", "journeydetails");
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
	<a href="index.jsp">Login Page</a> >> Admin >> Passengerdetails
	<h2>Passenger Details</h2>
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
						<td>Destination: <select name="destination" id="d">
								<option value="A">A</option>
								<option value="B">B</option>
								<option value="C">C</option>
								<option value="D">D</option>
						</select>
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
			}
		}
	</script>
</body>
</html>