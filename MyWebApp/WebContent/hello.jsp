<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello Page</title>
</head>
<body>
<% // server side eleement-scriptlet 
String str= "Hello Everyone";
%>
<h1> <%= str  %></h1> <!-- expression tag --> 
<center> <!-- its a depricated tag now  -->
<%
for(int i=1; i<=9;i++)
{
%>
<font size="<%=i %>"> Hello Rumana and Neha!</font><br>
<%
}
%>
</center>
</body>
</html>