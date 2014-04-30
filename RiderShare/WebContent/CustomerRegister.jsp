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
			<li><a href="#" id="menu2" accesskey="2" title="">About The
					Project</a></li>
			<li><a href="#" id="menu3" accesskey="3" title="">Get A Ride</a></li>
			<li><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=customerlogin") %>" id="menu4" accesskey="4" title="">Login
					(Customer)</a></li>
		</ul>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Customer Registration</h2>

				<p>Enter your details for Registration</p>
				<form method="post"
					action="<%=response.encodeUrl(request.getContextPath()
					+ "/Controller?action=createcustomer")%>">

					<input type="hidden" name="action" value="createcustomer" />
					<table>
						<tr>
							<td align="right">First Name:</td>
							<td align="left"><input type="text" name="FirstName" value="<%=request.getAttribute("name")%>"/></td>
						</tr>
						<tr>
							<td align="right">Last Name:</td>
							<td align="left"><input type="text" name="LastName" value="<%=request.getAttribute("lname")%>"/></td>
						</tr>
						<tr>
							<td align="right">Your Email:</td>
							<td align="left"><input type="text" name="Email" value="<%=request.getAttribute("email")%>" /></td>
						</tr>
						
						<tr>
							<td align="right">Password:</td>
							<td align="left"><input type="password" name="password" /></td>
						</tr>
						<tr>
							<td align="right">Re enter password:</td>
							<td align="left"><input type="password" name="repeatpassword" /></td>
						</tr>
						
						<tr>
							<td align="right">DOB (MM/DD/YYYY):</td>
							<td align="left"><input type="text" name="dob" /></td>
						</tr>

						<tr>
							<td align="right">Address Line 1:</td>
							<td align="left"><input type="text" name="add1" /></td>
						</tr>

						<tr>
							<td align="right">Address Line 2:</td>
							<td align="left"><input type="text" name="add2" /></td>
						</tr>

						<tr>
							<td align="right">City:</td>
							<td align="left"><input type="text" name="city" /></td>
						</tr>
						<tr>
							<td align="right">State:</td>
							<td align="left"><input type="text" name="state" /></td>
						</tr>
						<tr>
							<td align="right">Zip:</td>
							<td align="left"><input type="text" name="zip" /></td>
						</tr>
						<tr>
							<td align="right">Contact Number:</td>
							<td align="left"><input type="text" name="cnumber" /></td>
						</tr>
						<tr>
							<td align="left"></td>
							<td align="left"><input type="submit" value="Submit" /></td>
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
						<p class="more">
							<a href="#">View Journey</a>
						</p>
					</li>
					<li>
						<h3>2nd April 2014</h3>
						<p>Traveling To New York.</p>
						<p class="more">
							<a href="#">View Journey</a>
						</p>
					</li>
				</ul>
			</div>
		</div>
		<div id="colB">
			<div class="boxedB">
				<h2>How to</h2>
				<ul>
					<li><a href="#">Get A ride</a></li>
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