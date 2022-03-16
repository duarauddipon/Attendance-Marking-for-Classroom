<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="trainerregprocess" method="post">
		<table>
			<tr>
				<td>TrainerId</td>
				<td><input type="number" name="trainerId"> </td>
			</tr>
			<tr>
				<td>TrainerName</td>
				<td><input type="text" name="trainerName"> </td>
			</tr>
			<tr>
				<td>ContactNumber</td>
				<td><input type="text" name="contactNumber"> </td>
			</tr>
			<tr><td>Email Id</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>SkillSet</td>
				<td><input type="text" name="skillSet"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>