<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<link rel="stylesheet" type="text/css" href="NewFile.css">
<body>
<div id="menu">
	<ul>
		<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
		<li><a href="#" id="menu2" accesskey="2" title="">About The Project</a></li>
		<li><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=customerlogin") %>" id="menu3" accesskey="3" title="">Login (Customer)</a></li>
	</ul>
</div>
<br><br><br><br>
<div id="content">
	<div id="colA">
		<div id="welcome" class="boxedA">
			<p><b>Account successfully created with CustomerID:</b></p>

			<p><b><%= request.getAttribute("email") %></b></p>
			<p><b>Please Login into your account</b></p>					    
		</div>
		<div id="news" class="boxedA">
			<h2>Live Blog &amp; Updates</h2>
			<ul>
				<li>
					<h3>31st March 2014</h3>
					<p>Traveling To Boston.</p>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
				<li>
					<h3>2nd April 2014</h3>
					<p>Traveling To New York.</p>
					<p class="more"><a href="#">View Journey</a></p>
				</li>
			</ul>
		</div>
	</div>
	<div id="colB">
		<div class="boxedB">
			<h2>How to</h2>
			<ul>
				<li><a href="#">Edit Profile</a></li>
				<li><a href="#">View Live Blog</a></li>
				<li><a href="#">View Journey Details</a></li>
				<li><a href="#">Contact Us</a></li>
				<li><a href="#">Report Bad Experience</a></li>
				<li><a href="#">Give Feedback</a></li>
			</ul>
		</div>
		
	</div>
</div>
<div id="footer">
	<p>Join Us.</p>
</div>
</body>
</html>