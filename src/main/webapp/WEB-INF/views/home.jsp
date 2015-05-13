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

			<h2>Find Your Next Roomate</h2>
			If you're on the lookout for housing in Saint Louis, Missouri, then,
			take a chance of it. What else would make roommating fun? Besides,
			three types of housing, its interesting to know that they ve got
			voting system to elect their representatives. Residence halls,
			private room apartments and shared room apartments come along with
			dining points too whoa! If someone is interested in saving their
			shekels, just because they're lousy cooks, er, well, this would do!
			Well, I felt that it's absobloodylootely unfair to keep it what are
			you waiting for? Get to work with fun. Party to find who s going to
			be your next roommate! <br> <br>
			<!--Ok i kinda took a shortcut here to center the image. Will fix in final-->
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <img
				src="/resources/gray.jpg" alt="Example pic" style="border: 2px solid #ccc;"
				height="250" width="450" /> <br>
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
