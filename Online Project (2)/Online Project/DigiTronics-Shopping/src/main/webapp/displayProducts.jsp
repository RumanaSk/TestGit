<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/DigiTronics-Shopping/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>

</head>
<body>

	<!-- <input type="radio" name="time" value="before12"
		onclick="resetFilters()">Reset All Filters
	<br> -->

	<br>
	<h3>Select by Category</h3>
	<br>
	<input type="radio" name="time" value="Mobile" onclick="mobile()">Mobile
	<br>
	<br>
	<input type="radio" name="time" value="MobileAccessories"
		onclick="mobileAccessories()">Mobile Accessories
	<br>
	<br>
	<input type="radio" name="service" value="Laptop" onclick="laptop()">Laptop
	<br>
	<br>
	<input type="radio" name="service" value="Television"
		onclick="television()">Television
	<br>
	<br>

	<h3>Select by Price</h3>
	<br>
	<input type="radio" name="price" value="Between2000to15000" onclick="lowPrice()">
	Between500 to 15000
	<br>
	<br>
	<br>
	<input type="radio" name="price" value="Between15000to40000"
		onclick="mediumPrice()"> Between 15000 to 40000
	<br>
	<br>
	<br>
	<input type="radio" name="price" value="Between40000to90000"
		onclick="highPrice()"> Between 40000 to 90000
	<br>
	<br>
	
	<form action="contoller/list" , method="post">
		<table align="center" border="1">
			<tr>
				<th>Product Image</th>
				<th>Product Name</th>
				<th>Product Content</th>
				<th>Product Quantity</th>
				<th>Product Price</th>
				<th>Add</th>
			</tr>

			<c:forEach items="${ listOfProducts }" var="product">
				<tr>
					<td align="center"><img
						src="uploads/${ product.profilePicFileName }"
						style="width: 250px; height: 250px;" /></td>
					<td align="center">${ product.name }</td>
					<td align="center">${ product.content }</td>
					<td align="center">${ product.quantity}</td>
					<td align="center">${product.price }</td>
					<td><input type="button" value="Add"></td>
				<tr>
			</c:forEach>
		</table>
	</form>
	<script>
		function mobile() {
			document.location.href = "controller/listByCategory?categoryname=Mobile";
		}

		function mobileAccessories() {
			document.location.href = "controller/listByCategory?categoryname=MobileAccessories";
		}

		function laptop() {
			document.location.href = "controller/listByCategory?categoryname=Laptop";
		}

		function television() {
			document.location.href = "controller/listByCategory?categoryname=Television";
		}
		
		function lowPrice(){
			document.location.href = "controller/listByPrice?start=500&end=15000";
		}
		
		function mediumPrice(){
			document.location.href = "controller/listByPrice?start=15000&end=40000";
		}
		
		function highPrice(){
			document.location.href = "controller/listByPrice?start=40000&end=90000";
		}
		
	</script>
</body>
</html>