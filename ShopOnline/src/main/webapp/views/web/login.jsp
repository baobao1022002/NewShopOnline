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
							class="form-control" id="userName" name="userName" title="Nhập tên đăng nhập" required>
					</div>

					<div class="mb-3">
						<label for="passWord"><%=showLanguage.get("password")%></label> <input type="password"
							class="form-control" id="passWord" name="passWord" title="Nhập mật khẩu" required>
					</div>
					<div>
						<label for="captcha">Captcha:</label>
						<input type="text" id="captcha" name="captcha" required>
						<img src="captchaImage" alt="Captcha Image"><br><br>
					</div>
					<div class="col-xs-6">
						<label class="checkbox">
							<input type="checkbox" name="remember"/><i></i><%=showLanguage.get("remember")%>
						</label>

					</div>
					<div class="col-xs-6 text-right">
						<a href="${pageContext.request.contextPath}/forgotPass" title="<%=showLanguage.get("forgotpassword")%>"><%=showLanguage.get("forgotpassword")%>?</a>
					</div>
					<div class="col-xs-6 text-right">
						<a href="${pageContext.request.contextPath}/register" title="<%=showLanguage.get("register")%>"><%=showLanguage.get("register")%></a>
					</div>


					<button type="submit" class="btn btn-primary" title="<%=showLanguage.get("login")%>"><%=showLanguage.get("login")%></button>
					<a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Gradle___vn_projectltw___ShopOnline_1_0_war/login-google&response_type=code
    &client_id=40797728958-hb54ffp98q2v5brfbduqv6togf6h2kf7.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>



				</form>

			</div>
			
		</div>

	</div>
	<center>
	<script>
		function statusChangeCallback(response) {
			console.log('statusChangeCallback');
			console.log(response);

			if (response.status === 'connected') {

				testAPI();
			} else if (response.status === 'not_authorized') {

				document.getElementById('status').innerHTML = ' ';
			} else {

				document.getElementById('status').innerHTML = ' ';
			}
		}

		function checkLoginState() {
			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		}
		window.fbAsyncInit = function() {
			FB.init({
				appId : 164307959739299,
				cookie : true, // enable cookies to allow the server to access
				// the session
				xfbml : true, // parse social plugins on this page
				version : 'v2.2' // use version 2.2
			});


			FB.getLoginStatus(function(response) {
				statusChangeCallback(response);
			});
		};
		// Load the SDK asynchronously
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) return;
			js = d.createElement(s); js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		function testAPI() {
			console.log('Welcome! Fetching your information.... ');
			FB.api('/me?fields=name,email', function(response) {
				console.log('Successful login for: ' + response.name);

				document.getElementById("status").innerHTML = '<p>Welcome '+response.name+'! <a href='+ response.name.replace(" ", "_") +''+ response.email +'/admin/fblogincontroller.jsp?user_name=&user_email=>Continue with facebook login</a></p>'
			});
		}
	</script>
	<!--
     Below we include the Login Button social plugin. This button uses
     the JavaScript SDK to present a graphical Login button that triggers
     the FB.login() function when clicked.
    -->
	<br><br>
<%--	<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">--%>
<%--	</fb:login-button>--%>
	<div id="status">
	</div>
	<script type="text/javascript">
	</script>
	</center>


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