<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
	<c:url value="/template/admin/static" var="url"></c:url>
<nav class="navbar-default navbar-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav" id="main-menu">
			<li class="text-center">
			<c:url value="/image?fname=${sessionScope.account.avatar }" var="imgUrl"></c:url>
			<img src="${imgUrl}"
				class="user-image img-responsive" />
				<c:if test="${sessionScope.account.roleid==1 }">
				
					<a href="${pageContext.request.contextPath }/member/myaccount">Bạn là Admin</a>
				 
				 </c:if>
				 <c:if test="${sessionScope.account.roleid==2 }">
				
					<a href="${pageContext.request.contextPath }/member/myaccount">Bạn là Manager</a>
				
				 </c:if>
				 <c:if test="${sessionScope.account.roleid==3 }">
				
					<a href="${pageContext.request.contextPath }/member/myaccount">Bạn là Seller</a>
				 
				 </c:if>
				 
				</li>


			<li><a class="active-menu" href="${pageContext.request.contextPath }/admin/home"><i
					class="fa fa-dashboard fa-3x"></i> Dashboard</a></li>
			<li><a
				href="${pageContext.request.contextPath }/admin/category/list"><i
					class="fa fa-folder-open-o fa-3x"></i> Quản lý Danh mục</a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath }/admin/category/add">Thêm danh mục mới</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/category/list">Danh sách danh mục</a></li>
				</ul></li>
				
				<li><a
				href="${pageContext.request.contextPath }/admin/product/list"><i
					class="fa fa-desktop fa-3x"></i> Quản lý sản phẩm</a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath }/admin/product/add">Thêm sản phẩm mới</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/product/list">Danh sách sản phẩm</a></li>
				</ul></li>
				
			<li><a
				href="${pageContext.request.contextPath }/admin/user/list"><i
					class="fa fa-qrcode fa-3x"></i> Quản lý tài khoản</a>
					<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath }/admin/user/add">Thêm tài khoản mới</a></li>
					<li><a href="${pageContext.request.contextPath }/admin/user/list">Danh sách người dùng</a></li>
				</ul>
					</li>
			<li><a
				href="${pageContext.request.contextPath }/admin/order/list"><i
					class="fa fa-bar-chart-o fa-3x"></i> Quản lý đơn hàng</a></li>
			
		</ul>

	</div>

</nav>