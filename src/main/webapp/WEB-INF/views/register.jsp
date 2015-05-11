<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title> Match Central </title>
	<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<p> Please insert the information below to create a an account.<br>
	After you create an account, you will be prompted to log in. </p>

	<form class="user" action="/match/registered" method="POST">
		First Name: <input type="text" name="firstName"> <br>
		Last Name: <input type="text" name="lastName"> <br>
		User Name: <input type="text" name="userName"> <br>
		Password: <input type="password" name="passWord"> <br>
		Age: <input type="text" name="age"> <br>
		Email: <input type="text" name="email"> <br> 
		
		<input type="submit" value="Register">
	</form>
</body>
</html>
