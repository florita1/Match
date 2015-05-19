<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Questionnaire</title>
<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<div id="wrap">

		<div id="header">
			<h1>Match</h1>
		</div>

		<div id="right">

			<h2>Listed below is the information we have for you. Make necessary changes and submit.</h2>
			<br>
			<form action="/match/submitEdit" method="POST">
				<table style="margin-left: 11px">
					<tr>
						<td>First Name: <input type="text" name="firstName" value="${userInfo.first_name}"></td>
					</tr>
					<tr>
						<td>Last Name: <input type="text" name="lastName" value="${userInfo.last_name}"></td>
					</tr>
					<%-- <tr>
						<td>User Name: <input type="text" name="userName" value="${userInfo.user_name}"></td>
					</tr>
					<tr>
						<td>Password: <input type="password" name="passWord" value="${userInfo.password}"></td>
					</tr> --%>
					<tr>
						<td>Age: <input type="text" name="age" value="${userInfo.age}"></td>
					</tr>
					<!-- <tr>
						<td>Gender: <input type="radio" name="gender" value="male">Male
									<input type="radio" name="gender" value="female">Female</td>
					</tr> -->
					<tr>
						<td>Email: <input type="text" name="email" value="${userInfo.email}">
						</td>
					</tr>
					<c:forEach items="${userAnswers}" var="answer">
					<tr>
						<td><strong>${answer.question.id}</strong>${answer.question.question}
						<input type="radio" name="${answer.question.id}" value="Yes">Yes
						<input type="radio" name="${answer.question.id}" value="No">No
						Your Answer: ${answer.answer}</td>
					</tr>
					</c:forEach>
				</table>
				<input type="submit" value="Edit Profile">
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
