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

<spring:url value="/resources/css/teamCreateStyle.css" var="teamCreateStyle" />
<link href="${teamCreateStyle}" rel="styleSheet" />

<spring:url value="/resources/js/dropdown.js" var="dropdownJS" />
<script src="${dropdownJS}"></script>

</head>
<body>


	<a href="inbox">Inbox</a>
	<br />
	<br />
	<h3><%=session.getAttribute("teamName")%><br /></h3>
	
	Add Member
		<div class="dropdown">
		<button onclick="myFunction()" class="dropbtn">+</button>

		<div id="myDropdown" class="dropdown-content">

			<input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()">
		
			<c:forEach var="user" items="${userList}">
				<a href="savemember/${user.userId}">${user.userName}</a> <br />
			</c:forEach>

		</div>
	
	</div>
	<br/>
	
	<br/>	<font color="red">${errorMessage}</font>
	<br/>
	${teamCreatorName}(Team Creator)<br/>	
	<c:forEach var="member" items="${memberNameList}">
				${member.userName}<br />
	</c:forEach>

</body>
</html>