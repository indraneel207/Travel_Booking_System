<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	int count = (int) session.getAttribute("count");
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
	<a href="index.jsp">Login Page</a> >> Admin >> <a href="buscountpage1.jsp">Bus Count Details</a> >> Final Details
	<h2>Bus Count Details</h2>
	<fieldset>
		<legend>
			<h3>Total Count:</h3>
		</legend>
		<h2>
			Total buses are:<%=count%></h2>
	</fieldset>
</body>
</html>