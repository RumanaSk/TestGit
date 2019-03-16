<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>
<form action="controller/cart" method="get">
	<h3>Cart Page</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }">
			<c:set var="total" 
				value="${total + item.product.price * item.quantity }"></c:set>
		<tr>
				<td align="center"><a
					href="controller/cart/remove?pid=${item.product.id }"
					onclick="return confirm('Are you sure?')">Remove</a></td>
				<td>${item.product.id }</td>
				<td>${item.product.name }</td>
				<td><img src="../images/${item.product.photo }"
					width="50"></td>
				<td>${item.product.price }</td>
				<td>${item.quantity }</td>
				<td>${item.product.price * item.quantity }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Sum</td>
			<td>${total }</td>
		<c:set var="cartTotal"  value="${ total}" scope="session"></c:set>
		</tr>
	</table>
	<br>
	<a href="${pageContext.request.contextPath }/controller/product/list">Continue
		Shopping</a> 
	<a href="${pageContext.request.contextPath }/controller/checkout/emi?sum=${total }">Checkout</a>
	<!-- 	<a href="checkout.jsp">Checkout</a> -->
</form>
</body>
</html>