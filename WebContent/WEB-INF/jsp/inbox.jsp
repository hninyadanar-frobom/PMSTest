<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<spring:url value="/resources/js/inbox.js" var="inboxJS" />
<script src="${inboxJS}"></script>

<spring:url value="/resources/css/inboxStyle.css" var="inboxStyle" />
<link href="${inboxStyle}" rel="styleSheet" />

<spring:url value="/resources/image/noti.jpg" var="noti" />
<spring:url value="/resources/image/contact.jpg" var="contact" />
</head>
<body>

	<h2>Inbox</h2>
	<div id="container">
		<%
			int memberRole = Integer.parseInt(session.getAttribute("memberRole").toString());
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			if (memberRole==0) {
		%>

		<p>
			<c:forEach var="member" items="${inboxData}">
				<ul id="myUL">
					<li>
						Create Team <br /> <br /> 
						<img src="${noti}" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font color="blue"><%=session.getAttribute("teamCreatorName")%></font>
						invite you to enter <font color="green"> <%=session.getAttribute("teamName")%>Team</font> at <%=session.getAttribute("date") %>. <br />

						<p>
							<a href="access/${member.userId}/${teamId}"> 
								<input id="hide" type="button" value="Access" />
							</a>
							<a id="hide" href="deny/${member.userId}">
							 	 <input type="button" value="Deny" />
							</a>
						</p>
					</li>
				</ul>
			</c:forEach>
			
		<ul id="myUL">
			<li>
				<% String projectName=(String)session.getAttribute("ProjectName");
					if(projectName.isEmpty()){%>
					
					<img src="${contact}" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; No Project Assign by  <%=session.getAttribute("teamName")%>.

				<%} else{%> 
					Project Member <br /> <br /> <img src="${contact}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="blue"><%=session.getAttribute("ProjectCreatorName")%></font>
					assigned to you <font color="green"> <%=session.getAttribute("ProjectName")%>Project.</font>  <%} %>
			</li>
		</ul>
		</p>


		<% }else{ %>

		<ul id="myUL">
			<li>Team <%=session.getAttribute("teamName")%> has been created.</li>
		</ul>
		<% }%>
	</div>

</body>
</html>
