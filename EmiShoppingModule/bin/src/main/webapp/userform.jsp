<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Status</title>
<base href="/SpringMvcFormValidation/">
</head>
<body>
	<h1>Edit User Status</h1>
	 <form action="controller/singleuser" method="GET" >
		<table border="2" width="70%" cellpadding="2">
			<tr><th>Id</th><th>Name</th>	<th>Phone</th><th>Email</th><th>User name</th><th>Status</th><th>Doc_status</th><th>Fee_status</th><th>Password</th><th>Address</th><th>Card Type</th><th>Bank</th><th>securityanswer</th><th>securityquestion</th><th>Account no.</th><th>IFSC code<br /></tr>
    
   <tr>
     
   
   <td><c:out value="${UserStatus.userId}" /></td>
   <td><c:out value="${UserStatus.name}" /></td> 
   <td><c:out value="${UserStatus.phone}" /></td> 
   <td><c:out value="${UserStatus.email}" /></td>
   <td><c:out value="${UserStatus.username}" /></td>
   <td><c:out value="${UserStatus.status}" /></td> 
   <td><c:out value="${UserStatus.document_status}" /></td>
   <td><c:out value="${UserStatus.fee_status}" /></td>
   <td><c:out value="${UserStatus.password}" /></td>
   <td><c:out value="${UserStatus.address}" /></td>
   <td><c:out value="${UserStatus.cardtype}" /></td>
   <td><c:out value="${UserStatus.bank}" /></td>
   <td><c:out value="${userStatus.securityanswer}"/></td>
    <td><c:out value="${userStatus.securityquestion}"/></td>
   <td><c:out value="${UserStatus.accountno}" /></td>
   <td><c:out value="${UserStatus.ifsc}" /></td>
   </tr>  
   
   <form action="controller/status" method="GET" >
	<tr>
			<td>Activate User:</td>
			<td>Yes<input type="radio" name="status" value="true" onclick="statusupdatetrue()"/></td>
			
			<td>No<input type="radio" name="status" value="false"  onclick="statusupdatefalse()"/></td>
	</tr>
			<tr>
			</tr><input type=button  onclick=f1()  value="Save">
			
			<script>
			var currentStatus= false;
			
			function  statusupdatefalse(){
				 currrentStatus=false;
			}
			
			function  statusupdatetrue(){
				 currrentStatus= true;
			}
			function f1(){
				document.location.href="controller/status?userId=${UserStatus.userId}&status="+currrentStatus;
			}
			</script>
			
		</table>
</form>
</body>
</html>