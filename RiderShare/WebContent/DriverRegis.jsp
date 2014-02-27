<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<h1>Registration For Driver</h1>
<body>
<form>
<br><br>
<table>
  <tr>
   <td align="right">First Name:</td> 
   <td align="left"><input type ="text" name ="FirstName"/></td>
  </tr>
  <tr>
   <td align="right">Last Name:</td> 
   <td align="left"> <input type ="text" name ="LastName"/></td>
  </tr>

  <tr>
   <td align="right">Address Line 1:</td> 
   <td align="left"><input type ="text" name ="Add1:"/></td>
  </tr>

  <tr>
   <td align="right">Address Line 2:</td> 
   <td align="left"><input type ="text" name ="Add2"/></td>
  </tr>

  <tr>
   <td align="right">City:</td> 
   <td align="left"><input type ="text" name ="City"/></td>
  </tr>
  <tr>
   <td align="right">DOB:</td> 
   <td align="left"><input type ="text" name ="Dob"/></td>
  </tr>
  <tr>
   <td align="right">State:</td> 
   <td align="left"><input type ="text" name ="State"/></td>
  </tr>
    
</table>

<h3>License Details</h3>

<table>
<tr>
   <td align="right">License Number:</td> 
   <td align="left"><input type ="text" name ="Lnum"/></td>
  </tr>
  <tr>
   <td align="right">Date Of issue:</td> 
   <td align="left"><input type ="text" name ="Doi"/></td>
  </tr>
  <tr>
   <td align="right">Date Of expiration:</td> 
   <td align="left"><input type ="text" name ="Doe"/></td>
  </tr>
</table>

<h3>Car Details</h3>

<table>
  <tr>
   <td align="right">Car Model Name:</td> 
   <td align="left"><input type ="text" name ="Cname"/></td>
  </tr>
  <tr>
   <td align="right">Car Type:</td> 
   <td align="left"><input type ="text" name ="Ctype"/></td>
  </tr>
   </table>
</form>
<input type="submit" Value ="Submit" onClick="javascript:window.location='PostJourney.jsp'">
</body>
</html>