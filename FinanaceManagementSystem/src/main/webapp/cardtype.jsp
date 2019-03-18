<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Card</title>
<style>
.details_emi {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	width: 100%;
	display: flex;
}

.field_emicard {
	line-height: 1.5;
	color: #495057;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #ced4da;
	border-radius: .25rem;
	font-size: 18px;
	padding: 12px;
	display: block;
	width: 30%;
	text-align: center;
}
</style>

</head>
<body>


	<h4>
		<span class="heading_emicard">${ username.username } Your EMI
			Card is Here</span>
	</h4>

	<!-- <jsp:include page="/gold.jsp"></jsp:include>  -->
	<h5><span class="heading_image">Card Details</span></h5>
	<br>

		<c:choose>
			<c:when test="${ username.type=='gold' }">
				<img src="../gold.jpg" width="400px" height="300px">
				<br />
			</c:when>
			<c:otherwise>
				<img src="../titanium.jpg">
				<br />
			</c:otherwise>
		</c:choose>

		<div class="details_emi">
			<span class="field_emicard">Card Number: ${sessionScope.username.id}</span><br>
			<span class="field_emicard">Card Holder: ${sessionScope.username.username }</span><br />
			<span class="field_emicard">Card Type: ${ sessionScope.username.type } </span><br>
			<span class="field_emicard"> Card Validity: ${ sessionScope.username.valid_upto }</span><br>
		</div>
	

</body>
</html>