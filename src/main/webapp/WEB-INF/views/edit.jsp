<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Edit Profile</title>
<link href="<c:url value="/resources/Match.css" />" rel="stylesheet">
</head>
<body>
	<div id="wrap">

		<div id="header">
			<h1>Roomies.com</h1>
		</div>

		<div id="right">
			<% if(request.getAttribute("Authenticated").equals("no")) { %>
				<h2>Page Inaccessible</h2>
				<p>${loginMessage}</p>
			<%} else {%>
				<h2>Edit your Profile</h2>
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
						<tr>
							<td>
								<ul>
								<c:forEach items="${userAnswers}" var="answer">
									<li>${answer.question.id}) ${answer.question.question}</li>
									<ul>
										<li>Your Answer: ${answer.answer}</li>
										<li> Change Answer: <input type="radio" name="${answer.question.id}" value="Yes">Yes
															<input type="radio" name="${answer.question.id}" value="No">No </li>
									</ul>
								</c:forEach>
								</ul>
							</td>
						</tr>
					</table>
					<input type="submit" value="Edit Profile">
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
