<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Register</title>
<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<div id="wrap">

		<div id="header">
			<h1>Match.com</h1>
		</div>

		<div id="right">

			<h2>Register</h2>
			<br>

			<p>
				Please insert the information below to create a an account.<br>
				After you create an account, you will be prompted to log in.
			</p>

			<form class="user" action="/match/registered" method="POST">
				<table>
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
						<td>Gender: <input type="radio" name="gender" value="male">Male
							<input type="radio" name="gender" value="female">Female
						</td>
					</tr>
					<tr>
						<td>Email: <input type="text" name="email">
						</td>
					</tr>
				</table>

				<input type="submit" value="Register">
			</form>
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
			<p>
				Copyright &copy; 2015 <a href="/match">Match.com</a> - All Rights Reserved
			</p>
		</div>
	</div>
</body>
</html>
