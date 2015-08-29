<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	background-size: 100% 445%;
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

select.first {
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

select.second {
	position: absolute;
	left: 400px;
	top: 250px;
}

a.addlink {
	color: #333;
	position: absolute;
	left: 300px;
	top: 350px;
}

a.downloadXML {
	color: #333;
	position: absolute;
	left: 300px;
	top: 380px;
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
	<form action="ProcessInputServlet">
		<center>
			<h1>Welcome to the Beacon Number game</h1>
		</center>
		<center>
			<b><p class="topMessage">Please select two actors between which you want to find Beacon
				Number</p></b>
		</center>
		</br>
		<h2 class="firstActor">Actor1</h2>
		<select name="actor1" class="first"}>
			<c:forEach var="item" items="${products}">
				<option>
					<c:out value="${item}" />
				</option>
			</c:forEach>
		</select> </br>
		<h2 class="secondActor">Actor2</h2>
		<select name="actor2" class="second">
			<c:forEach var="item" items="${products}">
				<option>
					<c:out value="${item}" />
				</option>
			</c:forEach>
		</select> <input type="submit" class="styled-button-1" value="Calculate">
		<br> <a class="addlink" href="AddResource.jsp">Add a linkage</a>
		<a class="downloadXML" href="DownloadXMLFile">Download Actor XML</a>
		<p class="outMessage">${sample}<p>
	</form>

</body>
</html>