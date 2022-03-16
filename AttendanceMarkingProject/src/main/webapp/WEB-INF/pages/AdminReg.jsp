<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="adminregprocess" method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td><input  type="text" name="firstname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input  type="text" name="lastname"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="number"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>