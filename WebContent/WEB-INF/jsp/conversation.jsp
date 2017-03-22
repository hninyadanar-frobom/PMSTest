<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team Conversation Page</title>
<style>
.conv {
	width: 800px;
	height: 100px;
	color: gray;
	border: 2px solid green;
	padding: 5px;
	font-size: 26px;
	border-radius: 20px;
}

.btnExample {
	color: #8E0;
	background: green;
	font-weight: bold;
	font-size: 20px;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
}

.btnExample:hover {
	color: green;
	background: #9DF;
}

.conversation {
	border: 2px solid #edd;
	font-size: 26px;
	border-radius: 20px;
	width: 750px;
	height: 90px;
	position: relative;
	color: black;
	background: #eff;
	text-align: left;
}

table {
	width: 810px;
	height: 240px;
	color: gray;
	border: 2px solid green;
	padding: 5px;
	font-size: 26px;
	border-radius: 36px;
}

/* td.msg {
	height: 50px;
	color: black;
	font-size: 30px;

} */
td.memName {
	font-size: 18px;
}

a.delete {
	background-color: red;
	border-radius: 8px;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	width: 22px;
	height: 22px;
	position: relative;
	top: 0px;
	left: 750px;
	font-family: Arial, sans-serif;
	font-size: 20px;
	color: black;
	text-align: center;
}

input.inner {
	border: 0px;
}
</style>
</head>
<body>

	<br />
	<center>
		<form:form method="post" action="/postConv">

			<br />
			<br />
			<textarea class="conv" name="msg" rows="5" cols="10"
				placeholder="Start a Conversation"></textarea>
			<br />
			<br />

			<button class="btnExample" type="submit" value="Submit"
				style="height: 50px; width: 150px">POST</button>

		</form:form>
		<br />

		<c:forEach var="convs" items="${convList}">

			<table bgcolor="#eff">


				<tr>
					<td><a
						href="deleteProjConversation/${convs.conversationid}/${convs.teamid}"
						class="delete">&nbsp;X&nbsp;</a></td>
				</tr>
				<tr>
					<td>posted by <input type="text" class="inner"
						style="font-size: 24px; color: green; background: #eff;"
						readonly="readonly" value="${convs.postBy}" /> <font
						color="green" size="3px"><c:out
								value="${convs.convPostDate}" /></font></td>


				</tr>
				<tr>
					<td colspan="2"> <textarea rows="2" cols="200" class="conversation"
							readonly="readonly"><c:out value="${convs.message}"></c:out>
					</textarea></td>

				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
			<br />

		</c:forEach>
	</center>
</body>
</html>