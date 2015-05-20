<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Search</title>
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
				<h2>Search Profiles</h2>
			
				<p>Please choose your search criteria.</p>
				<form action="/match/searchUsers" method="POST">
					<p>Age range: <input type="radio" name="age" value="a1"/>20-23
									<input type="radio" name="age" value="a2"/>24-27
									<input type="radio" name="age" value="a3"/>28-31</p>
					<p>Gender: <input type="radio" name="gender" value="male"/>Male
									<input type="radio" name="gender" value="female"/>Female</p>
					<input type="submit"/>
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
