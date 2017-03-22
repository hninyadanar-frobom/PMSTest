<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/themes/sunny/jquery-ui.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<spring:url value="/resources/js/dialog.js" var="dialogJS" />
<script src="${dialogJS}"></script>

<spring:url value="/resources/css/dialog.css" var="dialogCss" />
<link href="${dialogCss}" rel="styleSheet" />

<spring:url value="/resources/css/teamCreateStyle.css" var="teamCreateStyle" />
<link href="${teamCreateStyle}" rel="styleSheet" />
</head>

<body>
	<div id="dialog" title="Team Create">

		<center>
			<font color="blue" face="MonotypeCorsiva">
				<h3>New Organization</h3>
			</font> 

			<table width="30%">
			<form:form method="post" action="/team/Create" modelAttribute="team">
				<font face="TimesNewRoman">
					
						<tr>
							<td>Name:</td>
							<td><%-- <form:input path="teamName" /> --%>
							<input type="text" name="teamName" required size="20%" /></td>
							<td><font color="red">***</font></td>
						</tr>
						
						<tr>
							<td colspan=3 align=center>
							<p>
							<input type="submit" value="Create Team" />
							</p>
							</td>
						</tr>
				
				</font>
			</form:form>
		</table>


		</center>
	</div>


	Create Team <input id="button" type="button" value="+"><br/>
	<font color="red"> ${teamNameDuplicate} </font>
	


	




</body>
</html>