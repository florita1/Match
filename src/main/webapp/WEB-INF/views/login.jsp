<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title> Match Central </title>
	<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<p>Please log in below: </p>

	<form class="user" action="/match/thankyou" method="POST">
		UserName: <input type="text" name="userName"> <br>
		Password: <input type="password" name="passWord"> <br>
		Don't have an account? Register <a href="/match/register"> here</a>. <br>
		<input type="submit">
	</form>
</body>
</html>
