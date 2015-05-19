<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Match Central</title>
<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<div id="wrap">

		<div id="header">
			<h1>Profile</h1>
		</div>

		<div id="right">

			<h2>Information for ${userInfo.first_name}.</h2>
			<br>
			<% if(request.getAttribute("method").equals("get")) { %>
			<p>Click <a href="/match/allUsers">here</a> to take a quick look at all potential roomates.</p> <br>
			<p>Or click <a href="/match/search">here</a> to get paired up with your future roomate.</p> <br>
			<p> Click <a href="/match/edit">here</a> to edit your profile</p>
			<br>
			<%} %>

			<c:forEach items="${answerList}" var="currentAnswer">
				<p>${currentAnswer.question.question}: <strong>${currentAnswer.answer}</strong></p>
			</c:forEach>
			<div id="left">
				<h2>Navigation</h2>
				<ul>
					<li><a href="/match">Home</a></li>
					<li><a href="/match/login">Login</a></li>
					<li><a href="/match/profile">Profile</a></li>
					<li><a href="#">Matches</a></li>
					<li><a href="#">Search</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>

			<div style="clear: both;"></div>
			<div id="footer">
				<a> footer</a>
			</div>
		</div>
	</div>
</body>
</html>
