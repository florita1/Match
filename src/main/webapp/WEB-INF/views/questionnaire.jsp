<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title> Questionnaire </title>
	<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<p>Please answer this questionnaire.</p>
	<form action="/match/profile" method="POST">
		<c:forEach items="${questionList}" var="QuestionnaireTable">
				<strong>${QuestionnaireTable.id}</strong>${QuestionnaireTable.question}
				<input type="radio" name="${QuestionnaireTable.id}" value="y">Yes
				<input type="radio" name="${QuestionnaireTable.id}" value="n">No
				<br>
		</c:forEach>
		<input type="submit">
	</form>
</body>
</html>
