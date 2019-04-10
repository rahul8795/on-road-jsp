<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script src="script/geocode.js"></script>
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
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Login</a></li>
			<li class="nav-item"><a class="nav-link" href="#"
				data-toggle="modal" data-target="#signupModal">Signup</a></li>
			<li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
		</ul>
	</div>
	</nav>
	<!--mechanic form design-->

	<div class="container mt-5"
		style="border: 2px solid black; border-radius: 5px;">
		<h3>Fill all the information correctly :</h3>
		<form action="MechanicServlet" method="post">
			<div class="form-group">
				<label for="mid">Mechanic Id:</label> <input type="text"
					class="form-control" id="mid" placeholder="Enter mechanic id"
					name="mechanicId" required>
			</div>
			<div class="form-group">
				<label for="uname">Mechanic Name:</label> <input type="text"
					class="form-control" id="uname" placeholder="Enter mechanic name"
					name="mechanicName" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email id"
					name="mechanicEmail" required>
			</div>

			<div class="form-group">
				<label for="email">Choose gender:</label> <br /> <label
					class="radio-inline"> <input type="radio" name="gender" value="male">Male
				</label> <label class="radio-inline"> <input type="radio"
					name="gender" value="female">Female
				</label>
			</div>

			<div class="form-group">
				<label for="dob">Date Of Birth :</label> <input type="date"
					name="dob" max="3000-12-31" min="1000-01-01" class="form-control">

			</div>


			<div class="form-group">
				<label for="contact">Contact:</label> <input type="number"
					class="form-control" id="contact" placeholder="Enter contact"
					name="mechanicContact" required>

			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="password" required>
			</div>
			<div class="form-group">
				<label for="pwd">Confirm Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Confirm password"
					name="password" required>

			</div>
			<div class="form-group">
				<label for="lat">Latitude:</label> <input type="text"
					class="form-control" id="lat" placeholder="Latitude"
					name="latitude" readonly>
			</div>
			<div class="form-group">
				<label for="lng">Longitude:</label> <input type="text"
					class="form-control" id="lng" placeholder="Longitude"
					name="longitude" readonly>
			</div>
			<button type="button" class="btn btn-outline-dark"
				onclick="showPosition();" style="margin-bottom: 20px;">Get
				Your Geocode</button>

			<input type="submit" class="btn btn-outline-dark" value="Submit"
				style="margin-bottom: 20px;">
		</form>
	</div>
	</div>

	<!-- The Modal for choose sign up as mechanic or customer-->
	<div class="modal fade" id="signupModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Choose as Mechanic or Customer</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" style="padding-left: 120px;">
					<a href="mechanicRegister.jsp" class="btn btn-dark btn-lg">Mechanic</a>
					<a href="customerRegister.jsp" class="btn btn-dark btn-lg">Customer</a>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
</html>