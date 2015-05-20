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
			<h1>Match.com</h1>
		</div>

		<div id="right">

			<h2>Find Your Next Roommate</h2>
			Welcome to Match.com where you can find your next roommate.
			We encourage you to create a profile and to start your search
			TODAY! When you have created a profile, you are free to look at
			the profiles of other people who are looking for their future
			roommate, just like you! 
			
			Are you looking for a closer match? If so,
			check out our advanced search were we have compared your profile
			with that of our other clients.
			
			Have fun and explore!
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
