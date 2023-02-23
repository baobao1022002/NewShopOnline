<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/template/assets" var="url"></c:url>

< <div class="main">
	<div class="container-fluid">
		<!-- BEGIN SIDEBAR -->
		<div class="sidebar col-md-3 col-sm-5">
			<ul class="list-group margin-bottom-25 sidebar-menu">
				<c:forEach items="${categoryList}" var="cateList">
					<li class="list-group-item clearfix">
						<a href="<c:url value="/product/list?categoryId=${cateList.categoryId}&sellerId=0"></c:url>"><img style="width:22px; margin-right:10px" src="<c:url value="/image?fname=category/${cateList.images }" ></c:url>"><i class="fa fa-angle-right width="22px"></i>${cateList.categoryName}</a>
					</li>
				</c:forEach>			
			
			</ul>
			
			<ul class="list-group margin-bottom-25 sidebar-menu">
				<c:forEach items="${sellerList}" var="sellerList">
					<li class="list-group-item clearfix">
						<a href="<c:url value="/product/list?sellerId=${sellerList.sellerId}&categoryId=0"></c:url>"><img style="width:22px" alt="" src="<c:url value="/image?fname=seller/${sellerList.images }"></c:url>"> <i class="fa fa-angle-right width="22px""></i>${sellerList.sellerName}</a>
					</li>
				</c:forEach>			
			
			</ul>

			<div class="sidebar-filter margin-bottom-25">
				<h2>Filter</h2>
				<h3>Availability</h3>
				<div class="checkbox-list">
					<label><input type="checkbox"> Not Available (3)</label> <label><input
						type="checkbox"> In Stock (26)</label>
				</div>

				<h3>Price</h3>
				<p>
					<label for="amount">Range:</label> <input type="text" id="amount"
						style="border: 0; color: #f6931f; font-weight: bold;">
				</p>
				<div id="slider-range"></div>
			</div>

			<div class="sidebar-products clearfix">
				<h2>Bestsellers</h2>
				<div class="item">
					<a href="shop-item.html"><img
						src="../../assets/frontend/pages/img/products/k1.jpg"
						alt="Some Shoes in Animal with Cut Out"></a>
					<h3>
						<a href="shop-item.html">Some Shoes in Animal with Cut Out</a>
					</h3>
					<div class="price">$31.00</div>
				</div>
				<div class="item">
					<a href="shop-item.html"><img
						src="../../assets/frontend/pages/img/products/k4.jpg"
						alt="Some Shoes in Animal with Cut Out"></a>
					<h3>
						<a href="shop-item.html">Some Shoes in Animal with Cut Out</a>
					</h3>
					<div class="price">$23.00</div>
				</div>
				<div class="item">
					<a href="shop-item.html"><img
						src="../../assets/frontend/pages/img/products/k3.jpg"
						alt="Some Shoes in Animal with Cut Out"></a>
					<h3>
						<a href="shop-item.html">Some Shoes in Animal with Cut Out</a>
					</h3>
					<div class="price">$86.00</div>
				</div>
			</div>
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="col-md-9 col-sm-7">
			<div class="row list-view-sorting clearfix">
				<div class="col-md-2 col-sm-2 list-view">
					<a href="#"><i class="fa fa-th-large"></i></a> 
					<a href="#"><i class="fa fa-th-list"></i></a>
				</div>
				<div class="col-md-10 col-sm-10">
					<h2>&nbsp;</h2>
					<small class="shop-bg-red badge-results">${countproductAll} Sản phẩm</small>
					<div class="pull-right">
						<label class="control-label">Show:</label> <select
							class="form-control input-sm">
							<option value="#?limit=24" selected="selected">24</option>
							<option value="#?limit=25">25</option>
							<option value="#?limit=50">50</option>
							<option value="#?limit=75">75</option>
							<option value="#?limit=100">100</option>
						</select>
					</div>
					<div class="pull-right">
						<label class="control-label">Sort&nbsp;By:</label> <select
							class="form-control input-sm">
							<option value="#?sort=p.sort_order&amp;order=ASC"
								selected="selected">Default</option>
							<option value="#?sort=pd.name&amp;order=ASC">Name (A -
								Z)</option>
							<option value="#?sort=pd.name&amp;order=DESC">Name (Z -
								A)</option>
							<option value="#?sort=p.price&amp;order=ASC">Price (Low
								&gt; High)</option>
							<option value="#?sort=p.price&amp;order=DESC">Price
								(High &gt; Low)</option>
							<option value="#?sort=rating&amp;order=DESC">Rating
								(Highest)</option>
							<option value="#?sort=rating&amp;order=ASC">Rating
								(Lowest)</option>
							<option value="#?sort=p.model&amp;order=ASC">Model (A -
								Z)</option>
							<option value="#?sort=p.model&amp;order=DESC">Model (Z -
								A)</option>
						</select>
					</div>
				</div>
			</div>
			<!-- BEGIN PRODUCT LIST -->
			<div id="content" class="row product-list">
			<c:forEach items="${productListNew}" var="proList">
				<!-- PRODUCT ITEM START -->
				 <div class="product col-md-4 col-sm-6 col-xs-12">
					<div class="product-item">
						<div class="pi-img-wrapper">
							<img src="<c:url value="/image?fname=products/${proList.images}"></c:url>"
								class="img-responsive" alt="${proList.productName}">
							<div>
								<a href="<c:url value="/image?fname=products/${proList.images}"></c:url>"
									class="btn btn-default fancybox-button">Zoom</a> 
								<a href="#product-pop-up${proList.productId}" class="btn btn-default fancybox-fast-view">View</a>
							</div>
						</div>
						<h3>
							<a href="<c:url value="/product/detail?productId=${proList.productId}"></c:url>">${proList.productName}"</a>
						</h3>
						<div class="pi-price">$ ${proList.price}"</div>
						<a href="#" class="btn btn-default add2cart">Add to cart</a>
					</div>
				</div> 
				<!-- PRODUCT ITEM END -->
				
				   	<!-- BEGIN fast view of a product -->
						<div id="product-pop-up${proList.productId}" style="display: none; width: 700px;">
							<div class="product-page product-pop-up${proList.productId}">
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-3">
										<div class="product-main-image">
											<img src="<c:url value="/image?fname=products/${proList.images }"></c:url>"
												alt="Cool green dress with red bell 45" class="img-responsive">
										</div>
										<div class="product-other-images">
											<a href="<c:url value="/image?fname=products/${proList.images }"></c:url>" class="active"><img alt="Berry Lace Dress"
												src="<c:url value="/image?fname=products/${proList.images }"></c:url>"></a>
											<a href="<c:url value="/image?fname=products/${proList.images }"></c:url>"
												src="<c:url value="/image?fname=products/${proList.images }"></c:url>"></a>
											<a href="<c:url value="/image?fname=products/${proList.images }"></c:url>"><img alt="Berry Lace Dress"
												src="<c:url value="/image?fname=products/${proList.images }"></c:url>"></a>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-9">
										<h2>${proList.productName}</h2>
										<div class="price-availability-block clearfix">
											<div class="price">
												<strong><span>$</span>${proList.price }</strong> <em>$<span>${proList.price/0.8 }</span></em>
											</div>
												<div class="availability">
												Số lượng tồn: <strong>${proList.stoke}</strong>
											</div>
										</div>
										<div class="description">
											<p>${proList.description }</p>
										</div>
										<div class="product-page-options">
											<div class="pull-left">
												<label class="control-label">Size:</label> <select
													class="form-control input-sm">
													<option>L</option>
													<option>M</option>
													<option>XL</option>
												</select>
											</div>
											<div class="pull-left">
												<label class="control-label">Color:</label> <select
													class="form-control input-sm">
													<option>Red</option>
													<option>Blue</option>
													<option>Black</option>
												</select>
											</div>
										</div>
										<div class="product-page-cart">
											<div class="product-quantity">
												<input id="product-quantity" type="text" value="1" readonly
													name="product-quantity" class="form-control input-sm">
											</div>
											<button class="btn btn-primary" type="submit">Cho vào giỏ hàng</button>
											<a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>" class="btn btn-default">Xem chi tiết</a>
										</div>
									</div>

									<div class="sticker sticker-sale"></div>
								</div>
							</div>
						</div>
						<!-- END fast view of a product -->
			</c:forEach>
			</div>
	
			<!-- END PRODUCT LIST -->
	
		
		</div>
		<!-- END CONTENT -->

	</div>
</div>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(window).scroll (function(){
			if($(window).scrollTop() + $(window).height() >= $(document).height()){ 
				loadAjax();
			}
		});
	
	
		function loadAjax(){
			var amount = document.getElementsByClassName("product").length;
			$.ajax({
				url: "/ShopOnline/product/loadAjax",
				type: "get",
				data: {
					exits: amount
				},
				success :function(data) {
					$("#content").append(data);
				},
					error: function(xhr){
						
					}
		});
		};
	</script> -->






