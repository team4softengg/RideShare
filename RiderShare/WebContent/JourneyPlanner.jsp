<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Journey Planner</title>
 <style>
    html, body, #map {
      margin: 0;
      padding: 0;
      height: 100%;
      margin-left:70px;
    }
  </style>
</head>
<link rel="stylesheet" type="text/css" href="NewFile.css">
<body>
	<div id="menu">
	
		<ul>
			<li class="first"><a href="#" id="menu1" accesskey="1" title="">Home</a></li>
			<li><a href="#" id="menu2" accesskey="2" title="">About The
					Project</a></li>
		</ul>
	</div>
	<div id="map" align="center" style="width:80%; height:70%">

  <script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
  <script src="geolocation/Script.js"></script>
  </div>
	<br>
	<br>
	<br>
	<br>
	<div id="content">
		<div id="colA">
			<div id="welcome" class="boxedA">
				<h2>Journey Details</h2>
				<form method="post"
					action="<%=response.encodeUrl(request.getContextPath()
					+ "/ControllerLevel2?action=journeyplan")%>">

					<table>
						<tr>
							<td align="left">Date:</td>
							<td align="left"><input type="text" name="dateofjourney"></td>
						</tr>
						<tr>
							<td align="left">Initial:</td>
							<td align="left"><input type="text"
								name="inidest"></td>
						</tr>
						<tr>
							<td align="left">Final:</td>
							<td align="left"><input type="text" name="findest"></td>
						</tr>

						<tr>
							<td align="left"></td>
							<td align="left"><input type="submit" value="Submit" /></td>
						</tr>
					</table>

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
					<li><a href="#">Post Travel</a></li>
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