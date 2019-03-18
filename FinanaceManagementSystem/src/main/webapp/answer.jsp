<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="/FinanaceManagementSystem/">





</head>
<body>
<body>


	<h3>
		Security Question is: <b>${ userDetails.securityQuestion }</b>
	</h3>
	<form action="controller/getanswer" method="post">
		<c:if test="${error!=null}">
			<p>${error}</p>
		</c:if>
		Enter Answer: <input type="text" name="securityAnswer"> <input
			type="submit" value="Submit">
</form>

</body>
</html>

