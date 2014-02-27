<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Driver Distance</title>
<style type="text/css">
.driver{
display: block;
float:left;
width = 33%;
}
</style>

</head>
<body>
<%String[] name = {"John Kepler", "Kim lohan","Ankit Jain","Kathy Nolan"} ;
String[] dist = {"1.2 miles","1.3 miles","3.5 miles","4.7 miles"};
%>
<center><h1> Driver Distance </h1></center>
<table align="center">
<tr><td><h2>Name</h2></td><td></td><td></td><td></td><td><h2>Distance</h2></td></tr>

<%for(int i=0;i<name.length;i++) { %>
<tr></tr><tr></tr><tr><td><a href="Driverdet.jsp"><%=name[i]%></a></td><td></td><td></td><td></td><td><font size="5"><%=dist[i]%></font></td></tr>
<% } %>
</table>
    

</body>
</html>