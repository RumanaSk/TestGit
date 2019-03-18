<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
</head>
<body>
<form action="controller/add" method="post" enctype="multipart/form-data">

Product Category:
<select name="categoryName">

					<option value="Television">Television</option>
					<option value="Mobile">Mobile</option>
					<option value="Accessories">Accessories</option>
					<option value="Laptop">Laptop</option>
				</select>
				<br>
	Product Name : <input type="text" name="name" /> <br/>
		Product Quantity:<input type="number" name="quantity"><br>
			Product Price  : <input type="number" name="price" /> <br/>
				Product Content : <input type="text" name="content"><br>
	Product Image  : <input type="file" name="pro_images" /> <br/>
	 <br/>
	<input type="submit" value="Register" />
</form>
</body>
</html>