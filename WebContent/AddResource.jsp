<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beacon Number between two nodes</title>
<style>
body {
	background-image: url("movie_theatre.jpg");
	background-size: 100% 585%;
	background-repeat: no-repeat;
}

h1 {
	color: white;
}

p.outMessage {
	color: red;
	position: absolute;
	left: 300px;
	top: 400px;
	font-family: 'Helvetica Neue', Arial, sans-serif;
	font-size: 20px;
	font-weight: 700;
}

p.topMessage {
	color: #5A749E;
	position: absolute;
	left: 300px;
	top: 120px;
	font-family: 'Helvetica Neue', Arial, sans-serif;
	font-size: 16px;
	font-weight: 700;
}

h2.firstActor {
	color: black;
	position: absolute;
	left: 300px;
	top: 170px;
	font-family: 'Helvetica Neue', Arial, sans-serif;
}

input.first {
	position: absolute;
	left: 400px;
	top: 195px;
}

h2.secondActor {
	color: black;
	position: absolute;
	left: 300px;
	top: 220px;
	font-family: 'Helvetica Neue', Arial, sans-serif;
}

input.second {
	position: absolute;
	left: 400px;
	top: 250px;
}

a {
	color: #333;
	position: absolute;
	left: 300px;
	top: 350px;
}

.styled-button-1 {
	-webkit-box-shadow: rgba(0, 0, 0, 0.2) 0 1px 0 0;
	-moz-box-shadow: rgba(0, 0, 0, 0.2) 0 1px 0 0;
	box-shadow: rgba(0, 0, 0, 0.2) 0 1px 0 0;
	color: #333;
	background-color: #FA2;
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border: none;
	font-family: 'Helvetica Neue', Arial, sans-serif;
	font-size: 16px;
	font-weight: 700;
	height: 32px;
	padding: 4px 16px;
	text-shadow: #FE6 0 1px 0;
	position: absolute;
	left: 400px;
	top: 300px;
}
</style>
</head>
<body>
	<form action="AddResourceServlet">
		<center>
			<h1>Welcome to the Beacon Number game</h1>
		</center>
		<center><p class="topMessage">Please enter two actors between which you want to create a link</p></center>
		</br>
		<h2 class="firstActor">Actor1</h2>
		<input type="text" name="actor1"size="20px" class="first">
		<h2 class="secondActor">Actor2</h2>
		<input type="text" name="actor2"size="20px" class="second">
		<input type="submit" value="Add Link" class="styled-button-1">
		<a href="LoadData">Go Back</a>
		<p class="outMessage">${sample}<p> 
	</form>

</body>
</html>