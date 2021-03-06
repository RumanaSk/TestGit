<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
</head>
<body>

<form action="controller/list"method = "get">
	<h3>Products Page </h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Buy</th>
		</tr>
		<c:forEach var="product" items="${listOfProducts}">
			<tr>
				<td>${product.id }</td>
				<td>${product.categoryname }</td>
				<td>${product.name }</td>
				<td>${product.stocknumber}</td>
				<td><img src="../images/${product.photo }" width="50"></td> 
				
				<td>${product.price }</td>
				<td align="center">
			
				 					
				   <a  href="../cart/buy?pid=${product.id }">
						Buy Now
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>
