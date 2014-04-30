<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>

<link rel="stylesheet" type="text/css" href="NewFile.css">
<body>
<div class ="background-image">
<div id="menu">
	<ul>
		<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
		<li><a href="#" id="menu2" accesskey="2" title="">About The Project</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=createcustomer") %>" id="menu3" accesskey="3" title="">Register (Customer)</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=createdriver") %>" id="menu4" accesskey="4" title="">Register (Driver)</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=customerlogin") %>" id="menu5" accesskey="5" title="">Login (Customer)</a></li>
		<li><a href="<%=response.encodeUrl(request.getContextPath() + "/Controller?action=driverlogin") %>" id="menu6" accesskey="6" title="">Login (Driver)</a></li>
	</ul>
</div>
<br><br><br><br>
	<div id="colB">
		<div class="boxedB">
			<h2>How to</h2>
			<ul>
				<li><a href="#">Get A ride</a></li>
				<li><a href="#">Post Travel</a></li>
				<li><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=createdriver") %>">Register as a Driver</a></li>
				<li><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=createcustomer") %>">Register as a Customer</a></li>
				<li><a href="#">Edit Profile</a></li>
				<li><a href="#">View Live Blog</a></li>
				<li><a href="#">View Journey Details</a></li>
				<li><a href="#">Contact Us</a></li>
				<li><a href="#">Give Feedback</a></li>
			</ul>
		</div>
		</div>
<div id="content">
	<div id="colA">
		<div id="welcome" class="boxedA">
			<h2>Welcome to RideShare!</h2>
			<hr>
			<!-- <img src="images/carmain.jpg" alt="" width="130" height="150" style="float: right; margin: 0.5em 0 0 1.5em;" />-->
			<p align = "justify"><strong>RideShare</strong> is a a web application that would make traveling for a user more efficient and simple.It is mainly targeted towards students and people who do not have the convenience of a private vehicle.</p>
			</br>
		    <hr>
		</div>
		<div id="news" class="boxedA">
			<h2>Live Blog &amp; Updates</h2>
			<ul>
				<li>
					<h3>31st March 2014</h3>
					<h4>Traveling To Boston.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
				<li>
					<h3>2nd April 2014</h3>
					<h4>Traveling To New York.</h4>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
			</ul>
		</div>
	</div>
	</div>	
	
<div id="footer">
	<center><h3>Join Us.</h3></center>
</div>
</div>
</body>
</html>