<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>
<h1>here is you emi plan</h1>


<td colspan="6" align="right">Total Amount - ${sessionScope.cartTotal}</td><br>
Choose EMi Plan<span class="err">*</span>:<br>
			
								<select id="numberOfMonths" name="value" >
								<option value="">Select number of months</option>
											<option value="3" name="emiplan" id="three">3</option>
											<option value="6" name="emiplan" id="six">6</option>
											<option value="12" name="emiplan" id="tweleve">12</option>
											<option value="18" name="emiplan" id="eighteen">18</option>
											<option value="24" name="emiplan" id="twentyfour">24</option>
											<option value="36" name="emiplan" id="thirtysix">36</option>
								</select>
                	
                	
	<td colspan="6" align="right">amount to pay :  <input type="text" id = "amountPay"  placeholder="MONTHLY EMI" readonly> </td><br>		
		<!--  <a href="paymentgateway.jsp" name="PAY NOW">PAY NOW</a>-->

                	<input type="submit" value="Calculate EMI" name="calEMI" onclick="calculate()">
                	<input type="submit" value="Pay Now" name="pay" onclick="emi()">
                	
                	<!-- <form action="controller/emi" method="POST">
						<input id="data" type="hidden" value="" />
						<input type="submit" />
					</form> -->
                	<%-- <input id="emi"type="hidden" name="emi" value="<%=request.getParameter
  ("emiPerMonth") %>" > --%>
 	
<script>
var total = ${sessionScope.cartTotal};

function calculate(){
	var Month = document.getElementById("numberOfMonths").value;
    var emiPerMonth = total / Month;
    document.getElementById("amountPay").value= emiPerMonth;
    console.log(emiPerMonth);
    session.setAttribute("emiPerMonth",emiPerMonth);
}
 

</script>
<script> 

function emi(){

	/* session.getAttribute("emiPerMonth",emiPerMonth)
	document.location.href = "controller/emi?sum=${sessionScope.emiPerMonth }"; */
	var Month = document.getElementById("numberOfMonths").value;
    var emiPerMonth = total / Month;
    document.getElementById("amountPay").value= emiPerMonth;
    console.log(emiPerMonth);
	document.location.href="controller/checkout/payemi?sum="+emiPerMonth;
	//document.location.href="payment.jsp";
	}
</script>
       <%--  <%
        int emiPerMonth=Integer.parseInt(document.getElementById("amountPay").value);
        %>   --%> 
	
</body>
</html>