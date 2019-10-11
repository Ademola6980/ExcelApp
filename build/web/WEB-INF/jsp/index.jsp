<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customers Form</title>
</head>
<body>
<h1>customers Form</h1>
<form action="guru_register" method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>Middle Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Email address</td>
					<td><input type="text" name="email" /></td>
				</tr>
                                <tr>
					<td>Date of birth</td>
					<td><input type="text" name="DOB" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Phone number</td>
					<td><input type="text" name="contact" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
</html>