<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglib.jsp"%>
<c:url value="/template/web/static" var="url"></c:url>


		<!--=== Breadcrumbs v4 ===-->
		<div class="breadcrumbs-v4">
			<div class="container">
				<span class="page-name">Trang sản phẩm</span>
				<h1>
					Sản phẩm <span class="shop-green">đỉnh cao</span> đang đợi bạn
				</h1>
				<ul class="breadcrumb-v4-in">
					<li><a href="${pageContext.request.contextPath }">Trang chủ</a></li>
					<li><a href="${pageContext.request.contextPath }/product/grid">Sản phẩm</a></li>
					<li class="active">Danh sách sản phẩm</li>
				</ul>
			</div>
			<!--/end container-->
		</div>
		<!--=== End Breadcrumbs v4 ===-->

		
		<!--=== Content Part ===-->
		<div class="content container-fluid">
			<div class="row">
							<jsp:include page="/common/web/left.jsp"></jsp:include>
			
				

				<div class="col-md-9">
					<div class="row margin-bottom-5">
						<div class="col-sm-4 result-category">
							<h2>&nbsp;</h2>
							<small class="shop-bg-red badge-results">${countproductAll} Sản phẩm</small>
						</div>
						<div class="col-sm-8">
							<ul class="list-inline clear-both">
								<li class="grid-list-icons"><a
									href="${pageContext.request.contextPath }/product/list?index=1&index1=-1"><i class="fa fa-th-list"></i></a>
									<a href="${pageContext.request.contextPath }/product/grid?index=1&index1=-1"><i class="fa fa-th"></i></a>
								</li>
								<li class="sort-list-btn">
									<h3>Sắp xếp :</h3>
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											Điều kiện <span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="#">Tất cả</a></li>
											<li><a href="#">Bán chạy nhất</a></li>
											<li><a href="#">Bán chạy nhất theo tuần</a></li>
											<li><a href="#">Sản phẩm mới</a></li>
										</ul>
									</div>
								</li>
								<li class="sort-list-btn">
									<h3>Hiển thị :</h3>
									<div class="btn-group">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											<c:if test="${tag1==-1}">
												Tất cả
											</c:if>
											<c:if test="${tag1!=-1}">
											${tag1+2} 
											</c:if>
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu">
											<li><a href="${pageContext.request.contextPath }/product/grid?index=${tag}&index1=-1">Tất cả</a></li>
											<li><a href="${pageContext.request.contextPath }/product/grid?index=${tag}&index1=8">10</a></li>
											<li><a href="${pageContext.request.contextPath }/product/grid?index=${tag}&index1=3">5</a></li>
											<li><a href="${pageContext.request.contextPath }/product/grid?index=${tag}&index1=1">3</a></li>
										</ul>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<!--/end result category-->

					<div class="filter-results">
						<div class="row illustration-v2 margin-bottom-30">
						
						<c:forEach items="${productList }" var="p" >						
							<c:url value="/image?fname=${p.image }" var="imgUrl"></c:url>
							
							<div class="col-md-4">
								<div class="product-img product-img-brd">
									<a href="${pageContext.request.contextPath }/product/detail?id=${p.id}"><img class="full-width img-responsive"
										src="${imgUrl}" alt=""></a> <a
										class="product-review" href="${pageContext.request.contextPath }/product/detail?id=${p.id}">Xem trước</a> <a class="add-to-cart" href="${pageContext.request.contextPath }/product/detail?id=${p.id}"><i
										class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
									<div class="shop-rgba-dark-green rgba-banner">Mới</div>
								</div>
								<div
									class="product-description product-description-brd margin-bottom-30">
									<div class="overflow-h margin-bottom-5">
										<div class="pull-left">
											<h4 class="title-price">
												<a href="${pageContext.request.contextPath }/product/detail?id=${p.id}">${p.name}</a>
											</h4>
											
														
											<span class="gender text-uppercase">${p.category.name } - ${p.isseller.sell_name}</span> 
													<span class="title-price">$${p.price }.0</span> <span
												class="line-through"><small>$${p.price *1.25 }</small></span>

										</div>
										
									</div>
									<ul class="list-inline product-ratings">
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating-selected fa fa-star"></i></li>
										<li><i class="rating fa fa-star"></i></li>
										<li><i class="rating fa fa-star"></i></li>
										<li class="like-icon">
										Đã bán:${p.amount} | 
										<a
											data-original-title="Add to wishlist" data-toggle="tooltip"
											data-placement="left" class="tooltips" href="#"><i
												class="fa fa-heart"></i> ${p.wish}</a></li>
									</ul>
								</div>
							</div>
							</c:forEach>
					</div>
					<!--/end filter resilts-->
<c:if test="${indexP2!=-1}">
					<div class="text-center">
						<ul class="pagination pagination-v2">
								<c:if test="${tag>1}">
							<li><a href="${pageContext.request.contextPath }/product/grid?index=${tag-1}&index1=${tag1}"><i class="fa fa-angle-left"></i></a></li>
							</c:if>
							<c:forEach begin="1" end="${endP}" var="i">
							<li class='${tag==i?"active":"" }'><a href="${pageContext.request.contextPath }/product/grid?index=${i}&index1=${tag1}">${i}</a></li>
							</c:forEach>
						
							
								<c:if test="${tag<endP}">
							<li><a href="${pageContext.request.contextPath }/product/grid?index=${tag+1}&index1=${tag1}"><i class="fa fa-angle-right"></i></a></li>
							</c:if>
						</ul>
					</div>
					<!--/end pagination-->
	</c:if>
				</div>
			</div>
			<!--/end row-->
		</div>
		</div>
		<!--/end container-->
		<!--=== End Content Part ===-->
