<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>payment page</title>
</head>
<body>
<form action="controller/emipayment">
<h1>Payment confirmation</h1>
<big>Enter your card Number:</big><input type = "text" name="card_id"><br>

<big>Enter your three digit CVV:</big><input type = "text" name="cvv"><br>
<big>Enter Exp-Date</big><input type = "text" name="valid_upto"><br>
<input type=submit  value= "payNow">
</form>

</body>
</html>