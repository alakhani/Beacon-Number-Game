<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Our Products</title>
</head>
<body>
	<h1>Products</h1>
	<select>
		<c:forEach var="item" items="${products}">
			<option>
				<c:out value="${item}" />
			</option>
		</c:forEach>
	</select>
</body>
</html>