<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style><%@ include file="/WEB-INF/css/styles.css"%></style>
<title>Login Page</title>
</head>
<body>
	<jsp:include page="navbar_beforeLogin.jsp">
		<jsp:param name="currentpage" value="login" />
	</jsp:include>
	<c:if test="${error!=null}">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert"> ${error} <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<div class="container mt-2">
		<div class="loginform">
			<form action="login?redirect=${param.redirect}" method="POST">
				<div class="form-row">
					<div class="form-group col-md-3"></div>
					<div class="form-group col">
						<label for="UsernameBox">Username</label> <input type="text"
							class="form-control" id="UsernameBox" name="username"
							placeholder="username">
					</div>
					<div class="form-group col-md-3"></div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-3"></div>
					<div class="form-group col">
						<label for="PasswordBox">Password</label> <input type="password"
							class="form-control" id="PasswordBox" name="password"
							placeholder="password">
					</div>
					<div class="form-group col-md-3"></div>
				</div>
				<button type="submit" class="btn btn-info">Login</button>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>