<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beacon Number between two nodes</title>
</head>
<body>
	<form action="ProcessInputServlet">
		<h1>Welcome to the Beacon Number game</h1>
		</br>
		</br>
		<p>Please select two actors between which you want to find Beacon Number</p>
		</br>
		<h1>Actor1</h1>
		<select name="actor1">
			<c:forEach var="item" items="${products}">
			<option>
				<c:out value="${item}" />
			</option>
		</c:forEach>
		</select>
		</br>
		<h1>Actor2</h1>
		<select name="actor2">
			<c:forEach var="item" items="${products}">
			<option>
				<c:out value="${item}" />
			</option>
		</c:forEach>
		</select>
		<input type="submit" value="submit">
	</form>

</body>
</html>