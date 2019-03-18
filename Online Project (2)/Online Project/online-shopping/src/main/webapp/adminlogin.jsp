<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Page</title>
<script src="resources/jquery-1.12.4.js"></script>
<script src="resources/jquery.validate.min.js"></script>
<script>
	$(document).ready(function() {
		$("#loginForm").validate({
			rules : {
				userName : "required",
				password : {
					required : (true) 
				}
			},
			messages : {
				userName : "Please enter a username",
				password : {
					required : "Please provide a password",
				/* minlength: "Password should have at least 6 digits" */
				}
			}
		});

		$('#submitBtn').click(function() {
			$("#loginForm").valid();
		});
	});
</script>
</head>

<style>
input[type=text], input[type=password], input[type=number], input[type=email],
	input[type=date] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid grey;
	border-radius: 4px;
}

form {
	margin: 0 auto;
	width: 300px
}

input {
	margin-bottom: 3px;
	padding: 10px;
	width: 100%;
	border: 1px solid #CCC
}

button {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid grey;
	border-radius: 4px;
}

label {
	cursor: pointer
}

.submitBtn {
	background-color: #4CAF50;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid grey;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.submitBtn:hover {
	opacity: 1;
}

.error {
	color: red;
}
</style>

<body>
	<form action="controller/adminlogin" method="post" id="loginForm">

		<label for="email"><b>Username:</b></label> <input type="text"
			placeholder="Enter user name" name="username" required> <br />

		<label for="password"><b>Password:</b></label> <input type="password"
			placeholder="Enter Password" name="password" required>

		<button type="submit" id="submitBtn">Login</button>


		<div class="container">
			<c:if test="${error!=null}">
				<p>${error}</p>
			</c:if>
			<!-- style="background-color: #f1f1f1"> -->
			<button type="button" class="cancelbtn">Cancel</button>
			<!-- <span class="psw">Forgot <a href="#">password?</a></span> -->
		</div>
</form>
</body>
</html>