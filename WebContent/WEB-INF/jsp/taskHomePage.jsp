<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Task Home Page</title>
<spring:url value="/resources/css/homePage.css" var="task" />
<link href="${task}" rel="stylesheet" />
<spring:url value="/resources/css/linkstyle.css" var="task1" />
<link href="${task1}" rel="stylesheet" />
</head>
<body bgcolor="#f5f5f5">

	<center>
		<table>

			<tr>
				<td><select onChange="window.location.href=this.value"
					style="background-color: lightblue; color: blue">

						<option style="font-family: inherit;">List</option>
						<option value="remainingTask"
							style="font-family: inherit; color: blue; background-color: gray;">Remaining
							Task</option>
						<option value="completeTask"
							style="font-family: inherit; color: blue; background-color: gray">Complete
							Task</option>
						<option value="allTask"
							style="font-family: inherit; color: blue; background-color: gray">All
							Task</option>
				</select></td>
			</tr>
		</table>
		<br> <br>
		<div>
			<table>
				<tr>
					<td><a href="myTask"><font color="blue">My Task</font></a></td>
				</tr>
				<tr>
					<td><a href="deleteProjectList"><font color="blue">Delete
								Project</font></a></td>
				</tr>


			</table>
		</div>
	</center>

</body>
</html>
