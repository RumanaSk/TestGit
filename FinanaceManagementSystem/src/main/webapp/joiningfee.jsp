<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your card type:${ sessionScope.user.cardtype} </h1>



		<c:choose>
			<c:when test="${ card.cardtype=='gold' }">
				Rs1, 60,000/-<br>
				<br />
			</c:when>
			<c:otherwise>
				Rs 60,000/- <br>
				<br />
			</c:otherwise>
		</c:choose>

</body>
</html>