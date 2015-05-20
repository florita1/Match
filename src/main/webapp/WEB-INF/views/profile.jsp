<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Profile</title>
<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<div id="wrap">

		<div id="header">
			<h1>Match.com</h1>
		</div>

		<div id="right">
			<% if(request.getAttribute("Authenticated").equals("no")) { %>
				<h2>Page Inaccessible</h2>
				<p>${loginMessage}</p>
			<%} else {%>
				<h2>Profile</h2>
				<h2>Information for ${userInfo.first_name}.</h2>
				<% if(request.getAttribute("method").equals("get")) { %>
				<p>Click <a href="/match/allUsers">here</a> to take a quick look at all potential roommates.</p>
				<p>Or click <a href="/match/search">here</a> to get paired up with your future roommate.</p>
				<p> Click <a href="/match/edit">here</a> to edit your profile</p>
				<%} %>
				<ul>
				<c:forEach items="${answerList}" var="currentAnswer">
					<li>
						${currentAnswer.question.question}: <strong>${currentAnswer.answer}</strong>
					</li>
				</c:forEach>
				</ul>
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
