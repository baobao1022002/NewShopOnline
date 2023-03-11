<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<title>Register</title>
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
						<label for="userName">User Name:</label> <input type="text"
							class="form-control" id="userName" name="userName">
					</div>

					<div class="mb-3">
						<label for="passWord">Password:</label> <input type="password"
							class="form-control" id="passWord" name="passWord">
					</div>
					
					<div class="col-xs-6">
						<label class="checkbox">
							<input type="checkbox" name="remember"/><i></i>Remember me
						</label>
					</div>
					<div class="col-xs-6 text-right">
						<a href="${pageContext.request.contextPath}/forgotPass">Forgot password?</a>
					</div>
					<div class="col-xs-6 text-right">
						<a href="${pageContext.request.contextPath}/forgotPass">Register</a>
					</div>


					

					<button type="submit" class="btn btn-primary">Login</button>




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
	<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
	</fb:login-button>
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