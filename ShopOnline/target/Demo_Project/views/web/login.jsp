<%@ page import="vn.projectLTW.util.Language" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Map<String,String> showLanguage = new Language().vietnameseLanguage();
	String lang = (String) session.getAttribute("lang");
	if(lang!=null){
		if(lang.equals("Vietnamese")){
			showLanguage = new Language().vietnameseLanguage();
		} else if (lang.equals("English")) {
			showLanguage = new Language().englishLanguage();

		}
	}%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">

<title>login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<c:if test="${not empty message }">
					<div class="alert alert-success">${message}</div>
				</c:if>

				<c:if test="${not empty error }">
					<div class="alert alert-danger">${error}</div>
				</c:if>

			</div>

		</div>

		<div class="row">
			<div class="col-sm-12">
				<form action="login" method="post">
					<div class="mb-3">
						<label for="userName"><%=showLanguage.get("username")%></label> <input type="text"
							class="form-control" id="userName" name="userName">
					</div>

					<div class="mb-3">
						<label for="passWord"><%=showLanguage.get("password")%></label> <input type="password"
							class="form-control" id="passWord" name="passWord">
					</div>
					
					<div class="col-xs-6">
						<label class="checkbox">
							<input type="checkbox" name="remember"/><i></i><%=showLanguage.get("remember")%>
						</label>
					</div>
					<div class="col-xs-6 text-right">
						<a href="${pageContext.request.contextPath}/forgotPass"><%=showLanguage.get("forgotpassword")%>?</a>
					</div>
					<div class="col-xs-6 text-right">
						<a href="${pageContext.request.contextPath}/register"><%=showLanguage.get("register")%></a>
					</div>

					

					<button type="submit" class="btn btn-primary"><%=showLanguage.get("login")%></button>
				</form>

			</div>
			
		</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>


</body>
</html>