<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Project</title>

<spring:url value="/resources/css/linkstyle.css" var="task" />
<link href="${task}" rel="stylesheet" />
<spring:url value="/resources/css/design.css" var="task1" />
<link href="${task1}" rel="stylesheet" />

</head>
<body bgcolor="#f5f5f5">

	<table border=1>
		<tr>
			<th>Project Name</th>
			<th>Project Start Date</th>
			<th>Project End Date</th>
			<td></td>
		</tr>

		<c:forEach var="p" items="${projectList}">
			<tr>
				<td>${p.projectname}</td>
				<td>${p.projectstartdate}</td>
				<td>${p.projectenddate}</td>
				<td><a href="delete/${p.projectid}"><font color="blue">Delete</font></a></td>
			</tr>


		</c:forEach>

	</table>
	<font color=red> ${error} </font>

</body>
</html>