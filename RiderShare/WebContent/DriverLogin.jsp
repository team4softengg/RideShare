<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<link rel="stylesheet" type="text/css" href="NewFile.css">
<body>
<div id="menu">
	<ul>
		<li class="first"><a href="HomePage.jsp" id="menu1" accesskey="1" title="">Home</a></li>
		<li><a href="#" id="menu2" accesskey="2" title="">About The Project</a></li>
		<li><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=createdriver") %>" id="menu3" accesskey="3" title="">Register (Driver)</a></li>
	</ul>
</div>
<br><br><br><br>
<div id="content">
	<div id="colA">
		<div id="welcome" class="boxedA">
			<h2>Login (Driver)</h2>
			
			<p>Login with the your UserName and password</p>
			
			<form method="post" action="<%=response.encodeUrl(request.getContextPath()
					+ "/Controller?action=driverlogin")%>">
			<table>
				  <tr>
				   <td align="right">UserName (Email):</td> 
				   <td align="left"><input type ="text" name ="email"/></td>
				  </tr>
				  <tr>
				   <td align="right">Password:</td> 
				   <td align="left"> <input type ="password" name ="password"/></td>
				  </tr>
				  <tr>
				   <td align="right"></td> 
				   <td align="left"><input type ="submit" value ="Login"/></td>
				  </tr>
			</table>
			<p class="message"><%=request.getAttribute("message")%></p>
			</form>			    
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
				<li><a href="#">Post Travel</a></li>
				<li><a href="DriverRegister.jsp">Register as a Driver</a></li>
				<li><a href="#">Edit Profile</a></li>
				<li><a href="#">View Live Blog</a></li>
				<li><a href="#">View Journey Details</a></li>
				<li><a href="#">Contact Us</a></li>
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