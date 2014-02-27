<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post journey</title>
</head>
<body>
<h1> Journey Details</h1>

<form method="post">
<table>
<tr>
   <td align="left">Date Of journey:</td> 
   <td align="left"><input type ="text" name ="Doj"/></td>
  </tr>
<tr>
   <td align="left">Initial Destination</td>
   <td align="left"><input type ="text" name ="IniDes"/></td>
  </tr>
<tr>
   <td align="left">Stops:</td> 
   <td align="left"><input type ="text" name ="Stops"/></td>
  </tr>
<tr>
   <td align="left">Final Destination</td> 
   <td align="left"><input type ="text" name ="FinDes"/></td>
  </tr>
<tr>
   <td align="left">Seats</td> 
   <td align="left"><input type ="text" name ="seats"/></td>
  </tr>  
</table><br><br>

<button name="submit" type="submit" value="HTML">Post</button>



</form>



</body>
</html>