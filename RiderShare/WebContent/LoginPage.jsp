<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<h1 align="center"> Welcome to Rideshare</h1>
<body>

<br><br><br>
<div align="left">
<h3>Login as a Driver</h3><br><br>
User Name <input name ="username" type ="text" size=20/><br><br>
Password  <input name ="password" type ="password" size=20/><br><br>
<div align ="left">
<input type="submit" Value ="Submit" onClick="javascript:window.location='PostJourney.jsp'">
</div>
<h3>Login as a Customer</h3><br><br>
User Name <input name ="username" type ="text"/><br><br>
Password  <input name ="password" type ="password"/>
</div>
<br/>
<div align ="left">
<input type="submit" Value ="Submit" onClick="javascript:window.location='SecondOne.jsp'">
</div>
<br><br>
<a href="DriverRegis.jsp">Driver Registration</a> 
<a href="CustomerRegis.jsp"> Customer Registration</a>

</body>
</html>