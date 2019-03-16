<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload products</title>
</head>
<body>
	<h1>Product Detail Form</h1>
	<form action="controller/product/uploadproducts">
		<table style="width: 60%">
			<tr>
				<td>Category Name</td>
				
				<td><select name="categoryname">
						<option value="Select Product">Select Product</option>
						<option value="Mobile">Mobile</option>
						<option value="TV">TV</option>
						<option value="Laptop">Laptop</option>
				</select></td>

			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="name" /></td>
			</tr>


			<tr>
				<td>Stock Number</td>
				<td><input type="number" name="stocknumber" /></td>
			</tr>


			<tr>
				<td>Price</td>
				<td><input type="number" name="price" /></td>
			</tr>
		</table>

		<!-- ================================================ -->
		<form:form action="controller/upload" modelAttribute="fileUpload"
			enctype="multipart/form-data">
         Please select a file to upload : 
        <tr>
				<td>Image</td>
				<td><input type="file" name="photo" size="50" /></td>
			</tr>
			<!--  <input type = "submit" value = "upload" /> -->
		</form:form>

	<!-- ================================================ -->
		<br> <input type="submit" value="Submit"></input>
	</form>
</body>
</html>