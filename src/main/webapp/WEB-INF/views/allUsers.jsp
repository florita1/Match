<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Profile List</title>
<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<div id="wrap">

		<div id="header">
			<h1>Roomies.com</h1>
		</div>

		<div id="right">
			<% if(request.getAttribute("Authenticated").equals("no")) { %>
				<h2>Page Inaccessible</h2>
				<p>${loginMessage}</p>
			<%} else {%>
			<h2>Profile List</h2>
			<form action="/match/profile" method="POST">
				<table>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>
								<dl>
									<dt>${user.first_name} ${user.last_name}</dt>
									<dd>Age: ${user.age}</dd>
									<dd>Gender: ${user.gender}</dd>
								</dl>
							</td>
							<td><input type="radio" name="userId" value="${user.id}" />Select
								<input type="submit" value="View Profile" />
							</td>
						</tr>
					</c:forEach>
				</table>
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
