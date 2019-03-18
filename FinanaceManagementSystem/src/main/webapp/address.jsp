<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/online-shopping/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delivery Address</title>
</head>
<body>
	<form action="controller/cart" method="post" id="transaction">

		<label for="address"><b>Enter Your Delivery Address:</b></label> <input type="text"
			placeholder="Address" name="address" required> <br />
<table>

<tr>
                    <td><b>Payment Mode</b></td>
                    <td><input type="radio" name="Cash on Delivery" value="Cod">
					    COD</td>
                    <td><input type="radio" name="Atlantic Bank" value="Bank">
					    Atlantic Bank</td>   
</tr>
</table>
		<button type="submit" id="submitBtn">Place Order</button>
		<a href="${pageContext.request.contextPath }/controller/cart/confirm">Continue
		Shopping</a> 
</form>


</body>
</html>