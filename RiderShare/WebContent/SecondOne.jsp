<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="right"><b>Hello John Kepler</b></p>
<center><h1>Enter your trip details</h1></center>
<center><img src="<%=request.getServletContext().getContextPath() %>/map.jpg"/></center>
 <form action="address" method="post">
 <table align="center">


<tr><td>Initial:</td><td><input type="text" name="Initial Destination"></td></tr>
<tr><td>Final:</td><td><input type="text" name="Final Destination"></td></tr>
<tr><td>Date:</td><td><input type="text" name="Date of journey"></td></tr>
</table>

</form>
<center><input type ="submit" value="Submit" onClick="javascript:window.location='ThirdOne.jsp'"></center>
</body>
</html>