<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<h1>Registration For Customer</h1>
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
   <td align="right">Your Email:</td> 
   <td align="left"><input type ="text" name ="Your Email"/></td>
  </tr>
  <tr>
   <td align="right">Desired User name:</td> 
   <td align="left"><input type ="text" name ="Desired User name"/></td>
  </tr>
  <tr>
   <td align="right">Password:</td> 
   <td align="left"><input type ="text" name ="password"/></td>
  </tr>
  <tr>
   <td align="right">Re enter password:</td> 
   <td align="left"><input type ="text" name ="Re enter password"/></td>
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
   <td align="right">State:</td> 
   <td align="left"><input type ="text" name ="State"/></td>
  </tr>
  <tr>
   <td align="right">Zip:</td> 
   <td align="left"><input type ="text" name ="Zip"/></td>
  </tr>
  <tr>
   <td align="right">Contact Number:</td> 
   <td align="left"><input type ="text" name ="Contact Number"/></td>
  </tr>

</table>


</form>
<input type="submit" value="Submit" onClick="javascript:window.location='SecondOne.jsp'">
</body>
</html>