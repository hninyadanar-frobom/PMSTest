<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<spring:url value="/resources/css/loginStyle.css" var="loginStyle" />

<link href="${loginStyle}" rel="styleSheet" />



</head>
<body bgcolor="#f0f0f0">
	<center>
		<font face="Monotype Corsiva" size=+3 color="red">
			<h2>Project Management System</h2>
		</font>
	</center>
	<br />



	<!-- 	<button onclick="document.getElementById('id01').style.display='block'"
		style="width: auto;">Login</button> -->

	<div class="modal">


		<form:form class="modal-content animate" method="post"
			action="/loginUser" modelAttribute="User">


			<div class="container">
				<h4 align="center">Login Form</h4>
				<table>
					<tr>
						<td>Email :</td>
						<td><input type="text" placeholder="Enter Your Email"
							name="email" required /></td>
						<td><font color="red">***</font></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" placeholder="Enter Your Password"
							name="password" required /></td>
						<td><font color="red">***</font></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>
							<!-- <input type="submit" value="Login" /> -->
							<button type="submit">Login</button>
						</td>
					</tr>

				</table>
				<center>
					<font color="red">${loginError}</font>
				</center>
				<a href="register">Register</a>
			</div>

			<!--<div class="container" style="background-color: #f1f1f1">
			 <button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Cancel</button>  -->
			<!-- </div> -->
		</form:form>

	</div>

</body>
</html>