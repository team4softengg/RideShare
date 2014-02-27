<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RiderShare</title>
<style type="text/css">
.r_c {  
    display: block;
    float: left;
    width: 33%; 
}  

</style>
</head>
<body>

<center><h1><u>Ride Confirmation</u></h1></center>
<%
	String name= "John kepler";
	long no= 518434334;
	//String lang= "English, Spanish";
	//String license= "DEW123FEWEF";
	//double Ratings= 4.1;
	String car_n= "Toyota camry";
	String car_no = "ABC 1234";
	//String type = "4 doors";
%>
<h2>Your reservation summary for order ABC123</h2>
<div id = "container">  
<div class="r_c">
<h2>Driver Details</h2> 
<p align ="left"><b>Name:</b> <%=name %><br/><br/>
<b>Phone:</b> <%=no %><br/><br/>
</div>
  
<div class="r_c">
<h2>Car Details</h2>
<p align ="left"><b>Name:</b> <%=car_n %><br/><br/>
<b>Number:</b> <%=car_no %><br/><br/>
</div>      

<div class="r_c">
<h2></h2>
<p align ="left"><b>Details have been sent to you  via sms and email</b><br/><br/>
<b>Thank you for making a reservation with RideShare</b><br/><br/>
<b>This confirms your reservation</b><br/><br/>
</div>
</div>
<input align="middle" type="submit" name="userID" value= "GO TO HOME PAGE">

</body>
</html>