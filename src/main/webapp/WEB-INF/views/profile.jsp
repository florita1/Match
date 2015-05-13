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
			<h1>Match</h1>
		</div>

		<div id="right">

			<h2>Information for ${userInfo}.</h2>
			<br>

			<c:forEach items="${answerList}" var="Questions">
				<p>${Questions.q1}</p>
				<p>${Questions.q2}</p>
				<p>${Questions.q3}</p>
				<p>${Questions.q4}</p>
				<p>${Questions.q5}</p>
				<p>${Questions.q6}</p>
				<p>${Questions.q7}</p>
				<p>${Questions.q8}</p>
				<p>${Questions.q9}</p>
				<p>${Questions.q10}</p>
				<p>${Questions.q11}</p>
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
