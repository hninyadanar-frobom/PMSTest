<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>

<%@page import="com.pms.form.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Task</title>

<spring:url value="/resources/css/linkstyle.css" var="task" />
<link href="${task}" rel="stylesheet" />
<spring:url value="/resources/css/design1.css" var="task1" />
<link href="${task1}" rel="stylesheet" />
<spring:url value="/resources/css/design.css" var="task1" />
<link href="${task1}" rel="stylesheet" />


</head>
<body bgcolor="#f5f5f5">
	<center>
		<div>

            <c:forEach var="t" items="${taskresult1}">

                <font size="8"> ${t.taskname}</font>

            </c:forEach>

            <font color=red> ${error} </font>

        </div>
	</center>
	<br>
	<br>
	<a href="taskView" target="_self"><font color="blue">Task
			Home Page</font></a>
</body>
</html>