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
			<h1>Search</h1>
		</div>

		<div id="right">
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
		</div>


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

</body>
</html>
