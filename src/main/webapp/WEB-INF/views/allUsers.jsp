<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Questionnaire</title>
<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<div id="wrap">

		<div id="header">
			<h1>Match</h1>
		</div>

		<div id="right">
			<% if(request.getAttribute("Authenticated").equals("no")) { %>
				<h2>Page Inaccessible</h2>
				<p>${loginMessage}</p>
			<%} else {%>
				<h2>User List</h2>
				<br>
				<form action="/match/profile" method="POST">
					<c:forEach items="${userList}" var="user">
						<p>Name: ${user.first_name} ${user.last_name} Age: ${user.age}
							<input type="radio" name="userId" value="${user.id}"/>Select
							<input type="submit" value="View Profile"/>
						<br>
					</c:forEach>
				</form>
			<%} %>
		</div>
		<div id="left">
			<h2>Navigation</h2>
			<ul>
				<li><a href="/match">Home</a></li>
				<li><a href="/match/login">Login</a></li>
				<li><a href="/match/profile">Profile</a></li>
				<li><a href="/match/search">Search</a></li>
			</ul>
		</div>

		<div id="footer">
			<p> Copyright &copy; 2015 <a href="/match">Match.com</a> - All Rights Reserved</p>
		</div>
	</div>
</body>
</html>
