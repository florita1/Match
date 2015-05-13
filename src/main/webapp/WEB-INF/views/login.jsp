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

			<h2>Login</h2>
			<br>

			<form class="user" action="/match/thankyou" method="POST">
				<table style="margin-left: 11px">
					<tr>
						<td>User Name:</td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="passWord"></td>
					</tr>
					<tr>
						<td>Don't have an account? Register <a href="/match/register">
								here</a>.
						</td>
					</tr>
				</table>
				<input type="submit">
			</form>
			<br>
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
