<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>


	<h3>login with email and password</h3>

	<br />
	<a href="register.jsp">Register</a>
	<br />


	<div>
		<form:form method="post" action="/loginUser" ModelAndView="user">
			<table>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form:form>
	</div>


</body>
</html>