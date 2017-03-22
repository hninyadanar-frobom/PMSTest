<%@page import="java.awt.Color"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<spring:url value="/resources/css/registerStyle.css" var="registerStyle" />
<link href="${registerStyle}" rel="styleSheet" />

<spring:url value="/resources/js/registerValidation.js"
	var="registerValidation" />
<script src="${registerValidation}"></script>

<title>Register Page</title>
</head>
<body>

	<%-- <center> --%>

	<div class="container">

		<form:form name="myform" action="/insert" method="post"
			modelAttribute="user" class="modal-content animate"
			onsubmit="return validate();">

			<a href="login"><button>x</button></a>

			<table align="center" cellspacing="11">

				<tr align=center>
					<td colspan=3>
						<h1>
							<font size=+3 color="green" face="Monotype Corsiva">Registration
								Form </font>
						</h1>
						
						<font color="red"> ${DuplicateEmail} </font>
						
					</td>
				</tr>

				<tr>
					<td>Name</td>
					<td><input type="text" placeholder="Enter Your Name"
						name="userName" id="nameloc" required /></td>
					<td><font color="red">***</font></td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="text" placeholder="example@gmail.com"
						name="userEmail" required /></td>
					<td><font color="red">***</font></td>
				</tr>

	

				<tr>
					<td>Password</td>
					<td><input type="password" name="userPassword" required /></td>
					<td><font color="red">***</font></td>
				</tr>

				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="conPassword" required /></td>
					<td><font color="red">***</font></td>
				</tr>

				<tr>
					<td>PhoneNo</td>
					<td><input type="text" name="userPhoneno" required
						placeholder="0xxxxxxxxxx" /></td>
					<td><font color="red">***</font></td>
				</tr>

				<tr>
					<td>Gender</td>
					<td><input type="radio" name="userGender" value="Male" />Male
						<input type="radio" name="userGender" value="Female" />Female</td>
					<td></td>

				</tr>

				<tr>
					<td>Address</td>
					<td><textarea name="userAddress" rows="4" cols="22" required></textarea>
					</td>
					<td><font color="red">***</font></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Register" /></td>
					<td></td>
				</tr>



				<!-- <div class="container" style="background-color: #f1f1f1">
			<button type="button"
				onclick="document.getElementById('id01').style.display='none'"
				class="cancelbtn">Cancel</button>
		</div> -->

			</table>
			
		</form:form>
	</div>
	<%-- </center> --%>
</body>
</html>