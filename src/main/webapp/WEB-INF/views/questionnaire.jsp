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

			<h2>Please answer this questionnaire.</h2>
			<br>
			<form action="/match/submitAnswers" method="POST">
				<c:forEach items="${questionList}" var="QuestionnaireTable">
					<strong>${QuestionnaireTable.id}</strong>${QuestionnaireTable.question}
				<input type="radio" name="${QuestionnaireTable.id}" value="y">Yes
				<input type="radio" name="${QuestionnaireTable.id}" value="n">No
				<br>
				</c:forEach>
				<input type="submit">
			</form>
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
