<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy Finance</title>
</head>
<body>
<h1>USER List</h1>  
<form action="controller/list" method="get">
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th>	<th>Phone</th><th>Email</th><th>User name</th><th>Status</th><th>Doc_status</th><th>Fee_status</th><th>Password</th><th>Address</th><th>Card Type</th><th>Bank</th><th>Account no.</th><th>security answer</th><th>security question</th><th>IFSC code</th><th>Edit</th><br /></tr>  
   <c:forEach var="fue" items="${Users}">   
   <tr>  
   <td>${fue.userId}</td>  
   <td>${fue.name}</td>  
   <td>${fue.phone}</td>  
   <td>${fue.email}</td>
   <td>${fue.username}</td> 
   <td>${fue.status}</td> 
   <td>${fue.document_status}</td>
   <td>${fue.fee_status}</td>
   <td>${fue.password}</td> 
   <td>${fue.address}</td> 
   <td>${fue.cardtype}</td> 
   <td>${fue.bank}</td> 
   <td>${fue.accountno}</td>
   <td>${fue.securityanswer}</td>
   <td>${fue.securityquestion}</td>
   <td>${fue.ifsc}</td>      
   <td><a href="/SpringMvcFormValidation/controller/singleuser?userId=${fue.userId}">Edit</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   </form>
   <br/>    
</body>
</html>