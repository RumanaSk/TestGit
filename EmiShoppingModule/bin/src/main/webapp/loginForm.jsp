<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Validation</title>
<style type="text/css">
input[type=text] {
	padding: 5px;
	border: 2px solid #ccc;
	webkit-border-radius: 5px;
	border-radius: 5px;
}

input[type=text]:focus {
	border-color: yellow;
}

input[type=password] {
	padding: 5px;
	border: 2px solid #ccc;
	webkit-border-radius: 5px;
	border-radius: 5px;
}

input[type=password]:focus {
	border-color: yellow;
}

input[type=submit] {
	padding: 5px 15px;
	background: #ccc;
	border: 0 none;
	cursor: pointer;
	webkit-border-radius: 5px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<center>
		<h1>Please enter user name and password</h1>
		<form method="POST" action="controller/admin">
			Username:<input type="text" name="username"><br />
			<br /> Password: <input type="password" name="password"><br />
			<br />
			<button type="submit">Submit</button>
		</form>
	</center>
</body>