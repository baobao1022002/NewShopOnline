<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/template/web/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico">

<!-- Web Fonts -->
<link rel='stylesheet' type='text/css'
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="/template/web/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/template/web/static/css/shop.style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="/template/web/static/css/headers/header-v5.css">
<link rel="stylesheet" href="/template/web/static/css/footers/footer-v4.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="/template/web/static/plugins/animate.css">
<link rel="stylesheet" href="/template/web/static/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="/template/web/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/template/web/static/plugins/scrollbar/css/jquery.mCustomScrollbar.css">

<!-- CSS Page Style -->
<link rel="stylesheet" href="/template/web/static/css/pages/log-reg-v3.css">

<!-- Style Switcher -->
<link rel="stylesheet" href="/template/web/static/css/plugins/style-switcher.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="/template/web/static/css/theme-colors/blue.css"
	id="style_color">

<!-- CSS Customization -->
<link rel="stylesheet" href="/template/web/static/css/custom.css">
</head>
<body>
	
<body class="header-fixed">
	<div class="wrapper">
		<!--=== Header v5 ===-->
			
			<%@ include file="/common/web/header.jsp"%>
		
		<!--=== End Header v5 ===-->

		<!-- body -->
				
				


				
				<!-- body -->

		<!--=== Footer v4 ===-->
	<%@ include file="/common/web/footer.jsp"%>	
	<!--=== End Footer v4 ===-->
	</div>
	<!--/wrapper-->

	<!-- JS Global Compulsory -->
	<script src="/template/web/static/plugins/jquery/jquery.min.js"></script>
	<script src="/template/web/static/plugins/jquery/jquery-migrate.min.js"></script>
	<script src="/template/web/static/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script src="/template/web/static/plugins/back-to-top.js"></script>
	<script src="/template/web/static/plugins/smoothScroll.js"></script>
	<script
		src="/template/web/static/plugins/scrollbar/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script
		src="/template/web/static/plugins/sky-forms-pro/skyforms/js/jquery.form.min.js"></script>
	<script
		src="/template/web/static/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>
	<!-- JS Customization -->
	<script src="/template/web/static/js/custom.js"></script>
	<!-- JS Page Level -->
	<script src="/template/web/static/js/shop.app.js"></script>
	<script src="/template/web/static/js/forms/page_login.js"></script>
	<script src="/template/web/static/js/forms/page_contact_form.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init();
			Login.initLogin();
			App.initScrollBar();
			PageContactForm.initPageContactForm();
		});
	</script>
	<!--[if lt IE 9]>
    <script src="/template/web/static/plugins/respond.js"></script>
    <script src="/template/web/static/plugins/html5shiv.js"></script>
    <script src="/template/web/static/js/plugins/placeholder-IE-fixes.js"></script>    
    <script src="/template/web/static/plugins/sky-forms-pro/skyforms/js/sky-forms-ie8.js"></script>
<![endif]-->
	<!--[if lt IE 10]>
    <script src="/template/web/static/plugins/sky-forms-pro/skyforms/js/jquery.placeholder.min.js"></script>
<![endif]-->



</body>
</html>