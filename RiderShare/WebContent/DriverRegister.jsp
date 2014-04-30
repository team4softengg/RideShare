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
			<li><a href="<%= response.encodeUrl(request.getContextPath() + "/Controller?action=driverlogin") %>" id="menu3" accesskey="3" title="">Login (Driver)</a></li>
		</ul>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Driver Registration</h2>

				<p>Enter your details for Registration</p>
				<form method="post"
					action="<%=response.encodeUrl(request.getContextPath()
					+ "/Controller?action=createdriver")%>">

					<input type="hidden" name="action" value="createdriver" />
					<table>
						<tr>
							<td align="left">First Name:</td>
							<td align="left"><input type="text" name="FirstName" /></td>
						</tr>
						<tr>
							<td align="left">Last Name:</td>
							<td align="left"><input type="text" name="LastName" /></td>
						</tr>

						<tr>
							<td class="align-right">Email address:</td>
							<td><input type="text" name="email"
								value="<%=request.getAttribute("email")%>" />
						</tr>

						<tr>
							<td class="align-right">Password:</td>
							<td><input type="password" name="password" value="" /></td>
						</tr>

						<tr>
							<td class="align-right">Repeat password:</td>
							<td><input type="password" name="repeatpassword" value="" /></td>
						</tr>

						<tr>
							<td align="left">Address Line 1:</td>
							<td align="left"><input type="text" name="Add1" /></td>
						</tr>

						<tr>
							<td align="left">Address Line 2:</td>
							<td align="left"><input type="text" name="Add2" /></td>
						</tr>

						<tr>
							<td align="left">City:</td>
							<td align="left"><input type="text" name="City" /></td>
						</tr>
						<tr>
							<td align="left">DOB (MM/DD/YY):</td>
							<td align="left"><input type="text" name="Dob" /></td>
						</tr>
						<tr>
							<td align="left">State:</td>
							<td align="left"><input type="text" name="State" /></td>
						</tr>
					</table>
					<h3>License Details</h3>
					<br>
					<table>
						<tr>
							<td align="left">License Number:</td>
							<td align="left"><input type="text" name="Lnum" /></td>
						</tr>
						<tr>
							<td align="left">Date Of issue:</td>
							<td align="left"><input type="text" name="Doi" /></td>
						</tr>
						<tr>
							<td align="left">Date Of expiration:</td>
							<td align="left"><input type="text" name="Doe" /></td>
						</tr>
					</table>
					<h3>Car Details</h3>
					<br>
					<table>
						<tr>
							<td align="left">Car Model Name:</td>
							<td align="left"><input type="text" name="Cname" /></td>
						</tr>
						<tr>
							<td align="left">Car Type:</td>
							<td align="left"><input type="text" name="Ctype" /></td>
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
					<li><a href="#">Post Travel</a></li>
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