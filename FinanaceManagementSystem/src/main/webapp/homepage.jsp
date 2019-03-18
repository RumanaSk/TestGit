<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="madebyme.css">

<script type="text/javascript" src="../js/jquery-1.4.3.min.js"></script>
<style>
.join_{font-size: 20px;}
input[type="submit"]{      background: beige;
    padding: 17px;
    border-radius: 20px;
    font-size: 16px;
    color: #337ab7;}
.link_home a, .link_sub{    padding: 20px;
    background: beige;
    border-radius: 20px;
    font-size: 16px;}
    .join_ {
    font-size: 20px;
    text-align: center;
    padding: 5px;
    margin-left: 20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="/FinanaceManagementSystem/">
<title>Insert title here</title>
</head>
<body>


      
        <header class="top-header">
            <div class="container">
                <div class="row">
                    <div class="col-xs-5 header-logo">
                        <br>
                        <a href="index.html"><img src="uplift_logo.png" alt="" class="img-responsive logo"></a>
                    </div>
    
                    <div class="col-md-7">
                        <nav class="navbar navbar-default">
                          <div class="container-fluid nav-bar">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                              </button>
                            </div>
    
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                              
                              <ul class="nav navbar-nav navbar-right">
                                <li><a class="menu active" href="#home" >Home</a></li>
                                <li><a class="menu" href="/FinanaceManagementSystem/showproducts.jsp">Buy Products</a></li>
                                <li><a class="menu" href="/FinanaceManagementSystem/FAQ.jsp">FAQ </a></li>
                                <li><a class="menu" href="/FinanaceManagementSystem/Login.jsp">Login</a></li>
                                <li><a class="menu" href="/FinanaceManagementSystem/RegistrationForm.jsp"> contact us</a></li>
                              </ul>
                            </div><!-- /navbar-collapse -->
                          </div><!-- / .container-fluid -->
                        </nav>
                    </div>
                </div>
            </div>
        </header> <!-- end of header area -->
    

        <div class="container-login100">

<h1>Welcome to Rumana Finance, ${ sessionScope.user.username} </h1>
<span class="join_">As your card type is ${ sessionScope.user.cardtype}, Joining Fee is 

 
          <c:choose>
			<c:when test="${ user.cardtype=='gold' }">
                    <span class="join_am">	Rs 500/ </span>
				
			</c:when>
			<c:otherwise>
                    <span class="join_am"> Rs 1000/- <br></span>
				<br />
			</c:otherwise>
        </c:choose>
    </span>
	<span calss="link_sub">	<input type="submit" value="PAY NOW" onclick=pay()> </span>
<span class="link_home"> <a href="showcard.jsp">Card Details</a></span>
<span class="link_home"><a href="showproducts.jsp"> Buy Products</a></span>
</div>

	<!-- footer starts here -->
    <footer class="footer clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-xs-6 footer-para">
                        <p>&copy; <a href="https://www.freshdesignweb.com">Axis Finanace</a> &copy All right reserved</p>
                    </div>

                    <div class="col-xs-6 text-right">
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-skype"></i></a>
                    </div>
                </div>
            </div>
        </footer>


</body>
</html>
<script>
function pay(){
	document.write("Your Payment is successful");
}
</script>

