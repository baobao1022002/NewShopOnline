<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/template/assets" var="url"></c:url>
 <!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
			<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
				<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
				<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
				<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
				<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
				<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
				<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
					<li class="start ${tag=='adminhome'?'active open':''}">
						<a href="<c:url value="/admin/home"></c:url>">
						<i class="icon-home"></i>
						<span class="title">Dashboard</span>
						<span class="${tag=='adminhome'?'selected':''}"></span>
						<span class="arrow ${tag=='adminhome'?'open':''}"></span>
						</a>
					</li>
					<li class="${tag=='cate'?'active open':''}">
						<a href="<c:url value="/admin/category"></c:url>">
						<i class="icon-basket"></i>
						<span class="title">Category</span>
						<span class="${tag=='cate'?'selected':''}"></span>
						<span class="arrow ${tag=='cate'?'open':''}"></span>
						</a>
					</li>
					<li class="${tag=='use'?'active open':''}">
						<a href="<c:url value="/admin/user"></c:url>">
						<i class="icon-basket"></i>
						<span class="title">User</span>
						<span class="${tag=='use'?'selected':''}"></span>
						<span class="arrow ${tag=='use'?'open':''}"></span>
						</a>
					</li>
					<li class="${tag=='pro'?'active open':''}">
						<a href="<c:url value="/admin/product"></c:url>">
						<i class="icon-basket"></i>
						<span class="title">Product</span>
						<span class="${tag=='pro'?'selected':''}"></span>
						<span class="arrow ${tag=='pro'?'open':''}"></span>
						</a>
					</li>		
					<li class="${tag=='rol'?'active open':''}">
						<a href="<c:url value="/admin/userRole"></c:url>">
						<i class="icon-basket"></i>
						<span class="title">User Role</span>
						<span class="${tag=='rol'?'selected':''}"></span>
						<span class="arrow ${tag=='rol'?'open':''}"></span>
						</a>
					</li>		
					<li class="${tag=='sell'?'active open':''}">
						<a href="<c:url value="/admin/seller"></c:url>">
						<i class="icon-basket"></i>
						<span class="title">Seller</span>
						<span class="${tag=='sell'?'selected':''}"></span>
						<span class="arrow ${tag=='sell'?'open':''}"></span>
						</a>
					</li>	
						
					
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
<!-- END SIDEBAR -->