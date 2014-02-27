<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RiderShare</title>
<link rel="shortcut icon" href="C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\Ridershare\icon.ico"/>
</head>
<body>
<center><h1><u>Driver Information</u></h1></center>
<%
	/*String name= request.getParameter("DriverName");
	String no= request.getParameter("PhoneNo");
	String lang= request.getParameter("Language");
	String license= request.getParameter("LicenseNo");
	String Ratings= request.getParameter("Rating");
	*/
	String name= "John Kepler";
	long no= 518434334;
	String lang= "English, Spanish";
	String license= "DEW123FEWEF";
	String car="Ford Fusion";
	int seats=3;
	String ETA="17 min";
%>

 
<p align ="left"><h5><b>Name:</b> <%=name %></h5><br/>
<h5><b>Phone:</b> <%=no %></h5>
<h5><b>Languages:</b> <%=lang %></h5>
<h5><b>License:</b> <%=license %></h5>
<h5><b>Car:</b> <%=car %></h5>
<h5><b>Seats:</b><%=seats %></h5>
<h5><b>ETA:</b><%=ETA %></h5>
<h5><INPUT TYPE="SUBMIT" NAME="submit" VALUE="Select Driver"onClick="javascript:window.location='Confirmation.jsp'"></h5>
<p align="right"><img src = "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\Ridershare\car.jpg" />

</body>
</html>