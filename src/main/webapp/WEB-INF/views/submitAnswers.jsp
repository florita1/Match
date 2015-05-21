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
			<h1>Roomies.com</h1>
		</div>

		<div id="right">

			<h2>Answers received!</h2>
			<br>
			<p>
				Thank you answering our questions, please login <a
					href="/match/login">here</a>.
			</p>
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
			<p>
				Copyright &copy; 2015 <a href="/match">Match.com</a> - All Rights Reserved
			</p>
		</div>
	</div>
</body>
</html>
