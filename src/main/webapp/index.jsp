<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
</head>
<body>
	<form action="login" method="get">
		First name: <input type="text" name="fname"><br> 
		Last name: <input type="text" name="lname"><br><br> 
		 <input	type="submit" value="Submit"><br><br>
	</form>

	<form action="Register" method="get">
		First name: <input type="text" name="fname"><br> 
		Last name: <input type="text" name="lastName" size="20"> <br><br>
		<br> <input type="submit" value="Register"><br><br>
	</form>
	<form action="Delete" method="get">
	First name: <input type="text" name="fname"><br>
	Last name: <input type="text" name="lastName" size="20"> <br><br>
		<input type="submit" value="Delete"><br><br>
	</form>
</body>
</html>