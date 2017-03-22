<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.pms.form.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en" dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Content-Style-Type" content="text/css; charset=utf-8">
<meta http-equiv="Content-Script-Type"
	content="text/javascript; charset=utf-8">
<title>All Task</title>

<spring:url value="/resources/css/linkstyle.css" var="task" />
<link href="${task}" rel="stylesheet" />
<spring:url value="/resources/css/design.css" var="task1" />
<link href="${task1}" rel="stylesheet" />

</head>

<body bgcolor="#f5f5f5">
	<h1>All Tasks</h1>
	<table class="ieh-fl"
		style="display: inline-block; border: 1px solid; float: left;">

		<tr>
			<td></td>
			<td class="heading">Task Name</td>
			<td class="heading">Section Name</td>
			<td class="heading">Start Date</td>
			<td class="heading">End Date</td>


		</tr>

		<c:forEach var="t" items="${taskList}">
			<tr>
				<td><a href="checktaskstatus/${t.taskid}"><font
						color="blue">Finish</font></a></td>
				<td>${t.taskname}</td>
				<td>${t.sectionname}</td>
				<td>${t.taskstartdate}</td>
				<td>${t.taskenddate}</td>
			</tr>
		</c:forEach>
	</table>

	<table style="display: inline-block; border: 1px solid;">
		<tr>
			<td class="heading">Member Name</td>
		</tr>
		<c:forEach var="u" items="${userList}">

			<tr>
				<td>${u.username}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="taskView" target="_self"><font color="blue">Task
			Home Page</font></a>
</body>
</html>
