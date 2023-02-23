<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/template/web/static" var="url"></c:url>

<div class="col-md-3 filter-by-block md-margin-bottom-60">
	<h1>Lọc theo</h1>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"> Tên sản phẩm <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">


						<form action="${pageContext.request.contextPath }/product/seach" method="get">
							<input type="text" name="name" /> <input type="submit"
								value="Tìm kiếm">

						</form>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne"> Cửa hàng <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">
						<c:forEach var="item" items="${sellerlist}">
							<c:url var="editURL" value="/product/seller">
								<c:param name="id" value="${item.sell_id}" />
							</c:url>
							
							<li class="${tagsell == item.sell_id ? "active":""}">
							<c:forEach var="item1" items="${countsel}">
							  <c:if test="${item1.catid == item.sell_id && item1.total >=0}">
							   <label class="checkbox"> 
								<input type="checkbox" name="checkbox" checked /> <i></i> 
									<a href="${editURL}">${item.sell_name} 
										<small>(${item1.total})</small>
									</a>
							  </label>
							 </c:if>
							</c:forEach>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->

	<div class="panel-group" id="accordion-v2">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v2"
						href="#collapseTwo"> Danh mục <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">
						<c:forEach var="item" items="${catelist}">
							<c:url var="editURL" value="/product/list">
								<c:param name="CategoryID" value="${item.id}" />
							</c:url>
							<li class="${tag == item.id ? "active":""}">
							<c:forEach var="item1" items="${countcate}">
								<c:if test="${item1.catid == item.id&& item1.total !=0}">
							  <label class="checkbox"> 
								<input type="checkbox" name="checkbox" checked /> <i></i> 
								<a href="${editURL}&index=1&index1=-2">${item.name} 
									<small>
										 (${item1.total})
									</small>	 
								</a>
							</label>
							</c:if>
							</c:forEach>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->

	<div class="panel-group" id="accordion-v3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v3"
						href="#collapseThree"> Size <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseThree" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-unstyled checkbox-list">
						<li><label class="checkbox"> <input type="checkbox"
								name="checkbox" /> <i></i> S <small><a href="#">(23)</a></small>
						</label></li>
						<li><label class="checkbox"> <input type="checkbox"
								name="checkbox" checked /> <i></i> M <small><a href="#">(4)</a></small>
						</label></li>
						<li><label class="checkbox"> <input type="checkbox"
								name="checkbox" /> <i></i> L <small><a href="#">(11)</a></small>
						</label></li>
						<li><label class="checkbox"> <input type="checkbox"
								name="checkbox" /> <i></i> XL <small><a href="#">(3)</a></small>
						</label></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->

	<div class="panel-group" id="accordion-v4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v4"
						href="#collapseFour"> Price <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseFour" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="slider-snap"></div>
					<p class="slider-snap-text">
						<span class="slider-snap-value-lower"></span> <span
							class="slider-snap-value-upper"></span>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->

	<div class="panel-group" id="accordion-v5">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v5"
						href="#collapseFive"> Color <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseFive" class="panel-collapse collapse in">
				<div class="panel-body">
					<ul class="list-inline product-color-list">
						<li><a href="#"><img src="${url}/img/colors/01.jpg"
								alt=""></a></li>
						<li><a href="#"><img src="${url}/img/colors/02.jpg"
								alt=""></a></li>
						<li><a href="#"><img src="${url}/img/colors/03.jpg"
								alt=""></a></li>
						<li><a href="#"><img src="${url}/img/colors/04.jpg"
								alt=""></a></li>
						<li><a href="#"><img src="${url}/img/colors/05.jpg"
								alt=""></a></li>
						<li><a href="#"><img src="${url}/img/colors/06.jpg"
								alt=""></a></li>
						<li><a href="#"><img src="${url}/img/colors/07.jpg"
								alt=""></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->

	<div class="panel-group margin-bottom-30" id="accordion-v6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion-v6"
						href="#collapseSix"> Rating <i class="fa fa-angle-down"></i>
					</a>
				</h2>
			</div>
			<div id="collapseSix" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="stars-ratings stars-ratings-label">
						<input type="radio" name="stars-rating" id="stars-rating-5">
						<label for="stars-rating-5"><i class="fa fa-star"></i></label> <input
							type="radio" name="stars-rating" id="stars-rating-4"> <label
							for="stars-rating-4"><i class="fa fa-star"></i></label> <input
							type="radio" name="stars-rating" id="stars-rating-3"> <label
							for="stars-rating-3"><i class="fa fa-star"></i></label> <input
							type="radio" name="stars-rating" id="stars-rating-2"> <label
							for="stars-rating-2"><i class="fa fa-star"></i></label> <input
							type="radio" name="stars-rating" id="stars-rating-1"> <label
							for="stars-rating-1"><i class="fa fa-star"></i></label>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/end panel group-->
	<button type="button"
		class="btn-u btn-brd btn-brd-hover btn-u-lg btn-u-sea-shop btn-block">Reset</button>
</div>