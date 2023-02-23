<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/template/web/static" var="url"></c:url>


		<!--=== Breadcrumbs v4 ===-->
		<div class="breadcrumbs-v4">
			<div class="container">
				<span class="page-name">Product  Page</span>
				<h1>
					Maecenas <span class="shop-green">enim</span> sapien
				</h1>
				<ul class="breadcrumb-v4-in">
					<li><a href="${pageContext.request.contextPath }">Home</a></li>
					<li><a href="${pageContext.request.contextPath }/product/list">Product</a></li>
					<li class="active">List Product</li>
				</ul>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Breadcrumbs v4 ===-->

		<!--=== Content Part ===-->
		<div class="content container">
			<div class="row">
		<jsp:include page="/common/web/left.jsp"></jsp:include>
					<div class="col-md-9">
					<div class="row margin-bottom-5">
						<div class="col-sm-4 result-category">

						</div>
						<div class="col-sm-8">
							<ul class="list-inline clear-both">
								<li class="grid-list-icons"><a
									href="${pageContext.request.contextPath }/product/list"><i class="fa fa-th-list"></i></a>
									<a href="${pageContext.request.contextPath }/product/grid"><i class="fa fa-th"></i></a>
								</li>
								<li class="sort-list-btn">
									<h3>Sort By :</h3>
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											Popularity <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">All</a></li>
											<li><a href="#">Best Sales</a></li>
											<li><a href="#">Top Last Week Sales</a></li>
											<li><a href="#">New Arrived</a></li>
										</ul>
									</div>
								</li>
								<li class="sort-list-btn">
									<h3>Show :</h3>
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											20 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">All</a></li>
											<li><a href="#">10</a></li>
											<li><a href="#">5</a></li>
											<li><a href="#">3</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<!--/end result category-->
					<c:forEach items="${productSeachByName }" var="p" >

					<div class="filter-results">
					
						<div
							class="list-product-description product-description-brd margin-bottom-30">
							<div class="row">
							
								<div class="col-sm-4">
								<c:url value="/image?fname=${p.image }" var="imgUrl"></c:url>
									<a href="${pageContext.request.contextPath }/product/detail?id=${p.id}"><img
										class="img-responsive sm-margin-bottom-20"
										src="${imgUrl}" alt=""></a>
								</div>
								<div class="col-sm-8 product-description">
									
									
									<div class="overflow-h margin-bottom-5">
										<ul class="list-inline overflow-h">
											<li><h4 class="title-price">
													<a href="${pageContext.request.contextPath }/product/detail?id=${p.id}">${p.name }</a>
													
												</h4></li>
											<li><span class="gender text-uppercase">${p.category.name }</span></li>
											<li class="pull-right">
												<ul class="list-inline product-ratings">
													<li><i class="rating-selected fa fa-star"></i></li>
													<li><i class="rating-selected fa fa-star"></i></li>
													<li><i class="rating-selected fa fa-star"></i></li>
													<li><i class="rating fa fa-star"></i></li>
													<li><i class="rating fa fa-star"></i></li>
												</ul>
											</li>
										</ul>
										<div class="margin-bottom-10">
											<span class="title-price margin-right-10">$ ${p.price }.0</span> <span
												class="title-price line-through">$ ${p.price *1.25 }</span>
											
										</div>
										<p class="margin-bottom-20">${p.des }</p>
										
										<ul class="list-inline add-to-wishlist margin-bottom-20">
											<li class="wishlist-in"><i class="fa fa-heart"></i> <a
												href="${pageContext.request.contextPath }/product/detail?id=${p.id}">Add to Wishlist</a></li>
											<li class="compare-in"><i class="fa fa-exchange"></i> <a
												href="${pageContext.request.contextPath }/product/detail?id=${p.id}">Add to Compare</a></li>
										</ul>
										<a href="${pageContext.request.contextPath }/product/detail?id=${p.id}" ><button type="button" class="btn-u btn-u-sea-shop">Add
											to Cart</button></a>
									</div>
									
									
									
								</div>								
							</div>
							
						</div>

					</div>
					</c:forEach>
					<!--/end filter resilts-->

					<div class="text-center">
						<ul class="pagination pagination-v2">
							<li><a href="#"><i class="fa fa-angle-left"></i></a></li>
							<li><a href="#">1</a></li>
							<li class="active"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
						</ul>
					</div>
					<!--/end pagination-->
				</div>
			</div>
			<!--/end row-->
		</div>
		<!--/end container-->
		<!--=== End Content Part ===-->
