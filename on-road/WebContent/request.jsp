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
			<li class="nav-item"><a class="nav-link" href="track.jsp">Track
					Mechanic</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				data-toggle="modal" data-target="#feedback">Give Feedback</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About
					Customer</a></li>
		</ul>
		<div class="mx-auto order-0">
			<a class="navbar-brand mx-auto" href="#">Welcome : <span><c:out
						value='${customer.customerName}' /> </span></a>
		</div>
		<ul class="navbar-nav navbar-right">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="http://example.com"
				id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> See Notification </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="#">Mechanic 1 accepted</a> <a
						class="dropdown-item" href="#">Mechanic 1 accepted</a>
				</div></li>
			<li><a href="LogoutServlet" class="nav-link">Logout</a></li>
		</ul>
	</div>
	</nav>

	<!-- carousel images for starting page-->
	<div id="demo" class="carousel slide" data-ride="carousel">

		<!-- Indicators -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>

		<!-- The slideshow -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images/carousal1.jpg" alt="Los Angeles" width="1100"
					height="400">
			</div>
			<div class="carousel-item">
				<img src="images/carousal2.jpg" alt="Chicago" width="1100"
					height="400">
			</div>
			<div class="carousel-item">
				<img src="images/carousal3.png" alt="New York" width="1100"
					height="400">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>

	<!--display the all mechanic list based on rating -->
	<div class="container">
		<h2>Available Mechanic :</h2>

		<div class="table-responsive">
			<table class="table table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>Mechanic Id</th>
						<th>Name</th>
						<th>Contact</th>
						<th>Rating</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mechanicList }" var="mech">
						<tr>
							<td><c:out value="${mech.mechanicId }" /></td>
							<td><c:out value="${mech.mechanicName }" /></td>
							<td><c:out value="${mech.contact }" /></td>
							<td><c:out value="Rating" /></td>
							<td><a href="MechIdServlet?mechid=${mech.mechanicId }">Request</a></td>
							<td><a href="#" data-toggle="modal"
								data-target="#viewDetail">View Detail</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!--  Modal - view the mechanic details  -->
	<div class="modal" id="viewDetail">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">About Mechanic</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="container">
						<h2>Available 24/7</h2>
						<div class="card" style="width: 400px">
							<img class="card-img-top" src="images/mechanic.png"
								alt="Card image" style="width: 80%">
							<div class="card-body">
								<h4 class="card-title">John Doe</h4>
								<p class="card-text">Email :</p>
								<p class="card-text">Contact:</p>
								<p class="card-text">Date Of Birth :</p>
								<p class="card-text">Location :</p>
							</div>
						</div>
					</div>

				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


	<!-- Feedack Modal   -->
	<div class="modal" id="feedback">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Give Your Feedback to Mechanic</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="container">
						<form action="RatingServlet" method="post">
							<div class="form-group">
								<label for="sel1">Select Mechanic Id :</label> <select
									class="form-control" id="mechanicid" name="mechanicId">
									<option>--Select Mechanic Id--</option>
									<c:forEach items="${mechanicIdList }" var="mech">
										<option value="${mech }">${mech }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="sel2">Select Ratig :</label> <select
									class="form-control" id="sel3" name="rate">
									<option>--Select Ratig--</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
							<input type="submit" class="btn btn-dark" value="Feedack"
								style="margin-bottom: 10px;">
						</form>
					</div>

				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</body>

</html>