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

			<h2>Register</h2>
			<br>

			<p>
				Please insert the information below to create a an account.<br>
				After you create an account, you will be prompted to log in.
			</p>

			<form class="user" action="/match/registered" method="POST">
				<table style="margin-left: 11px">
					<tr>
						<td>First Name: <input type="text" name="firstName">
						</td>
					</tr>
					<tr>
						<td>Last Name: <input type="text" name="lastName">
						</td>
					</tr>
					<tr>
						<td>User Name: <input type="text" name="userName">
						</td>
					</tr>
					<tr>
						<td>Password: <input type="password" name="passWord">
						</td>
					</tr>
					<tr>
						<td>Age: <input type="text" name="age">
						</td>
					</tr>
					<tr>
						<td>Email: <input type="text" name="email">
						</td>
					</tr>
				</table>

				<input type="submit" value="Register">
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
