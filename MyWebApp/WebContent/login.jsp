<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>
<form method ="post" action="loginservlet">
    <h1>Log in </h1>
    User name:
    <input  type="text" name="userid" /> Password :
    <input type="text" name="pass" />

    <button type="submit" >Login </button>
       
<%

String message =(String)session.getAttribute("message");
if (message!=null)
out.println("<b>"+message+"</b>");
session.removeAttribute("message");
%>
       </form>
</body>
</html>