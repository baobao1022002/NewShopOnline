<%@ page import="vn.projectLTW.util.Language" %>
<%@ page import="java.util.Map" %>
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
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
<title>Tài khoản</title>
<script src="<c:url value="/template/districts.min.js"/>"></script>


<br />
<div class="container">
	<div class="row">
		<div class="col-md-3">
			<!--left col-->
			<input name="id" value="${sessionScope.account.userId}" hidden="">
			<div class="text-center">
				<c:url value="/uploads/users/${sessionScope.account.images}"
					   var="imgUrl"></c:url>
				<img src="${imgUrl }" width="60px" height="60px"
					 class="avatar img-circle img-thumbnail" alt="avatar">


				<p><%=showLanguage.get("username")%>:<span style="color: red"> ${sessionScope.account.userName}</span></p>

			</div>
			<hr>
			<div class="list-group">


				<a href="<c:url value='/ChangeProfile'/>"
				   class="list-group-item list-group-item-action"><%=showLanguage.get("account")%></a>
				<a href="<c:url value='/ChangePassword'/>"
				   class="list-group-item list-group-item-action"><%=showLanguage.get("change password")%></a>
				<a href="<c:url value='/member/orderbuy'/>"class="list-group-item list-group-item-action">
					<%=showLanguage.get("purchase order")%>
				</a>
			</div>
		</div>

		<div class="col-md-9">

			<c:if test="${not empty error}">
				<div class="alert alert-danger" role="alert">
						${error}
				</div>
			</c:if>
			<c:if test="${not empty success}">
				<div class="alert alert-success" role="alert">
						${success}
				</div>
			</c:if>

			<form action="ChangeProfile" method="POST">
				<input type="hidden" class="form-control" id="Id" name="Id"
					   value="${sessionScope.account.userId}">
				<div class="mb-3">
					<label><%=showLanguage.get("fullname")%></label> <input type="text" required
																			class="form-control" id="fullname" name="fullname" value="${sessionScope.account.fullName} "title="Nhập họ và tên mới" >
				</div>

				<div class="mb-3">
					<label>Email</label> <input type="email" required
												class="form-control" id="email" name="email" value="${sessionScope.account.email}" title="Nhập email mới">
				</div>

				<div class="mb-3">
					<label><%=showLanguage.get("phone")%></label> <input type="text" required
																		 class="form-control" id="phone" name="phone" value="${sessionScope.account.phone}" title="Nhập số điện thoại mới">
				</div>

				<br>
				<button  class="btn btn-primary" type="submit" style="margin-left: 47%" title="Thay đổi thông tin cá nhân>"><%=showLanguage.get("save changes")%></button>
			</form>
			<br>

		</div>
	</div>
</div>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
