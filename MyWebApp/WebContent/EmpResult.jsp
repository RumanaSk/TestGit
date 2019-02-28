<%@page import="com.lti.service.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
</head>
<body>
<h1>Employee details:</h1>

<h1>Details are:</h1>
 <%
Employee emp=(Employee)session.getAttribute("EmployeeData"); 
%>
Employee Id :<%=emp.getEmployeeId() %> <br>
First name :<%=emp.getFirstName() %> <br>
Last name :<%=emp.getLastName() %> <br>
Email :<%=emp.getEmail() %> <br>
Phone number :<%=emp.getPhonenumber() %> <br>
Hire date:<%=emp.getHireDate() %> <br>
salary :<%=emp.getSalary() %> <br>

</body>
</html>