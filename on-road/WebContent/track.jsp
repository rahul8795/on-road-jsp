<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<title>On Road Assistant</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style/carousel.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
	<!--Creating navbar for all pages-->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark"> <a
		class="navbar-brand" href="#"> <img src="images/logo.jpg"
		alt="logo" style="width: 40px;">
	</a> <a class="navbar-brand" href="#">On Road Assistant</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="request.jsp">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">About
					Customer</a></li>
		</ul>
		<div class="mx-auto order-0">
			<a class="navbar-brand mx-auto" href="#">Welcome <span><c:out
						value='${customer.customerName}' /></a>
		</div>
		<ul class="navbar-nav navbar-right">
			<li><a href="LogoutServlet" class="nav-link">Logout</a></li>
		</ul>
	</div>
	</nav>



	<!--navigation of customer and mechanic -->
	<div class="container"></div>



</body>

</html>