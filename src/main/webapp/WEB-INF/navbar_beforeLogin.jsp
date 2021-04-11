<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Auth Server</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
<%-- 				<li class="nav-item disabled"><a class="nav-link disabled" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#">Something </a></li>
				<li class="nav-item disabled"><a class="nav-link disabled" href="#">Something</a></li>
				<c:choose>
					<c:when test="${param.currentpage == 'login'}">
						<li class="nav-item"><a class="nav-link" href="http://localhost:4200/register">Register</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="Login">Login</a></li>
					</c:otherwise>
				</c:choose> --%>
			</ul>
		</div>
	</nav>
</body>
</html>