<%@ page import="vn.projectLTW.util.Language" %>
<%@ page import="java.util.Map" %>
<%@include file="/common/taglib.jsp" %>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>

<br/>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<!--left col-->
			<input name="id" value="${sessionScope.account.userId}" hidden="">
			<div class="text-center">
				<c:url value="${sessionScope.account.images }"
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
			<ul class="nav nav-tabs flex-column font-weight-bold">
				<li class="nav-item"><a class="nav-link active btn-primary"
										href="#all" data-toggle="tab"><%=showLanguage.get("all")%></a></li>
				<li class="nav-item"><a class="nav-link" href="#choxacnhan"
										data-toggle="tab"><%=showLanguage.get("wait for confirmation")%>
					<c:if test="${choxacnhan!=0}">
						<span class="badge badge-danger badge-pill">${choxacnhan}</span>
					</c:if>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#cholayhang"
										data-toggle="tab"><%=showLanguage.get("waiting for the goods")%>
					<c:if test="${cholayhang!=0}">
						<span class="badge badge-danger badge-pill">${cholayhang}</span>
					</c:if>
				</a></li>


				<li class="nav-item"><a class="nav-link" href="#danggiao"
										data-toggle="tab"><%=showLanguage.get("delivery")%>
					<c:if test="${danggiao!=0}">
						<span class="badge badge-danger badge-pill">${danggiao}</span>
					</c:if>
					<span
							class="badge badge-danger badge-pill">14</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#dagiao"
										data-toggle="tab"><%=showLanguage.get("delivered")%></a></li>
				<li class="nav-item"><a class="nav-link" href="#dahuy"
										data-toggle="tab"><%=showLanguage.get("cancelled")%></a></li>
			</ul>
			<br/>
			<div class="tab-content">
				<%--                <div class="search-open" style="display: block;">--%>

				<%--                    <input type="text" class="form-control" autocomplete="off"--%>
				<%--                           placeholder="Tìm kiếm theo Tên Shop, ID đơn hàng hoặc Tên Sản phẩm">--%>
				<%--					--%>
				<%--                </div>--%>
				<br/>
				<div role="tabpanel" class="tab-pane active" id="all">
					<br/>
					<div class="row">
						<div class="col-md-12">
							<span class="badge badge-danger badge-pill pull-right"><%=showLanguage.get("Total order")%>: ${all}</span>
						</div>
					</div>

					<c:forEach items="${listCartItem}" var="list">
						<div class="list-product-description product-description-brd margin-bottom-30">
							<div class="row">
								<div class="col-sm-12">
									<c:url value="/image?fname=seller/${list.product.seller.images }"
										   var="imgURL"></c:url>
									<img width="50px" class="img-circle img-thumbnail" src="${imgURL}" alt="">
										${list.product.seller.sellerName } - <%=showLanguage.get("Code orders")%>: ${list.cartId}
									<hr>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<c:url value="/image?fname=products/${list.product.images}" var="imgURL"></c:url>
									<a href="${pageContext.request.contextPath}/product/detail?productId=${list.product.productId}"></a>
									<img class="img-thumbnail" style="width: 100px" src="${imgURL}" alt="">
								</div>
								<div class="col-sm-8 product-description">
									<div class="overflow-h margin-bottom-5">
										<ul class="list-inline overflow-h">
											<li>
												<h4 class="titled-price">
													<a href="${pageContext.request.contextPath}/product/detail?productid=${list.product.productId}">${list.product.productName}</a>
												</h4>
											</li>
											<li><span class="gender text-uppercase"></span></li>
											<li class="pull-right">
												<c:if test="${list.cart.status==0}">
													<button type="button" class="btn btn-warning"><%=showLanguage.get("wait for confirmation")%></button>
												</c:if>
												<c:if test="${list.cart.status==1}">
													<button type="button" class="btn-u btn-u-sea-shop"><%=showLanguage.get("waiting for the goods")%>
													</button>
												</c:if>
												<c:if test="${list.cart.status==2}">
													<button type="button" class="btn btn-warning"><%=showLanguage.get("delivery")%></button>
												</c:if>
												<c:if test="${list.cart.status==3}">
													<button type="button" class="btn btn-success"><%=showLanguage.get("delivered")%></button>
												</c:if>
												<c:if test="${list.cart.status==4}">
													<button type="button" class="btn btn-success"><%=showLanguage.get("cancelled")%></button>
												</c:if>
												<c:if test="${list.cart.status==5}">
													<button type="button" class="btn-u btn-u-sea-shop">Chờ người bán xác
														nhận hủy
													</button>
												</c:if>
											</li>
										</ul>
										<div class="margin-bottom-10">
											<span class="compare-in"><%=showLanguage.get("unitprice")%>:  ${list.product.price}</span>
										</div>
										<ul class="list-inline add-to-wishlist margin-bottom-20">
											<li class="compare-in"><%=showLanguage.get("quantity")%>: ${list.quantity}</li>
										</ul>
										<br>
										<span class="pull-right title-price"><%=showLanguage.get("subtotal")%>:
												<span class="badge badge-success badge-pill">${list.quantity * list.product.price}</span>
											</span>
									</div>
								</div>
							</div>
							<c:if test="${list.cart.status==0}">
								<a href="<c:url value="/member/orderbuy/cancel?id=${list.cart.cartId}&st=4"/>"
								   class="center">
									<button type="button" class="btn btn-danger"><%=showLanguage.get("cancel order")%></button>
								</a>
							</c:if>
							<c:if test="${list.cart.status==1}">
							<a href="<c:url value="/member/orderbuy/recancel?id=${list.cart.cartId}&st=5"/>"
							   class="center">
								<button type="button" class="btn btn-danger"><%=showLanguage.get("cancelled")%></button>
								</c:if>
						</div>
					</c:forEach>

					<div class="text-center">
						<ul class="pagination pagination-v2">
							<c:if test="${tag>1}">
								<li><a href="${pageContext.request.contextPath}/member/orderbuy?index=${tag-1}"><i
										class="fa fa-angle-left"></i></a></li>
							</c:if>
							<c:forEach begin="1" end="${endP}" var="i">
								<li class="${tag==i?"active":""}"><a
										href="${pageContext.request.contextPath}/member/orderbuy?index=${i}">${i}</a>
								</li>
							</c:forEach>

							<c:if test="${tag<endP}">
								<li><a href="${pageContext.request.contextPath}/member/orderbuy?index=${tag+1}"><i
										class="fa fa-angle-right"></i></a></li>
							</c:if>
						</ul>
					</div>
					<br/>
				</div>

				<div role="tabpanel" class="tab-pane fade" id="choxacnhan">
					<br/>
					<c:forEach items="${listCartItem1}" var="list">
						<c:if test="${list.cart.status==0}">
							<div class="list-product-description product-description-brd margin-bottom-30">
								<div class="row">
									<div class="col-sm-12">
										<c:url value="/image?fname=seller/${list.product.seller.images}"
											   var="imgURL"></c:url>
										<img width="50px" class="img-circle img-thumbnail" src="${imgURL}" alt="">
											${list.product.seller.sellerName } - <%=showLanguage.get("Code orders")%>: ${list.cartId}
										<hr>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<c:url value="/image?fname=products/${list.product.images}" var="imgURL"></c:url>
										<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}"></a>
										<img class="img-thumbnail" style="width: 100px" src="${imgURL}" alt="">
									</div>
									<div class="col-sm-8 product-description">
										<div class="overflow-h margin-bottom-5">
											<ul class="list-inline overflow-h">
												<li>
													<h4 class="titled-price">
														<a href="${pageContext.request.contextPath}/product/detail?productId=${list.product.productId}">${list.product.productName}</a>
													</h4>
												</li>
												<li><span class="gender text-uppercase"></span></li>
												<li class="pull-right">
													<c:if test="${list.cart.status==0}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("wait for confirmation")%></button>
													</c:if>
													<c:if test="${list.cart.status==1}">
														<button type="button" class="btn-u btn-u-sea-shop"><%=showLanguage.get("waiting for the goods")%>
														</button>
													</c:if>
													<c:if test="${list.cart.status==2}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("delivery")%></button>
													</c:if>
													<c:if test="${list.cart.status==3}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("delivered")%></button>
													</c:if>
													<c:if test="${list.cart.status==4}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("cancelled")%></button>
													</c:if>

												</li>
											</ul>
											<div class="margin-bottom-10">
												<span class="compare-in"><%=showLanguage.get("unitprice")%>: ${list.product.price}</span>
											</div>
											<ul class="list-inline add-to-wishlist margin-bottom-20">
												<li class="compare-in"><%=showLanguage.get("quantity")%>: ${list.quantity}</li>
											</ul>
											<br>
											<span class="pull-right title-price"><%=showLanguage.get("subtotal")%>:
													<span class="badge badge-success badge-pill">$ ${list.quantity * list.product.price}</span>
												</span>
										</div>
									</div>
								</div>
								<c:if test="${list.cart.status==0}">
									<a href="<c:url value="/member/orderbuy/cancel?id=${list.cart.cartId}&st=4"/>"
									   class="center">
										<button type="button" class="btn btn-danger"><%=showLanguage.get("request cancellation")%></button>
									</a>
								</c:if>
								<c:if test="${list.cart.status==1}">
								<a href="<c:url value="/member/orderbuy/recancel?id=${list.cart.cartId}&st=5"/>"
								   class="center">
									<button type="button" class="btn btn-danger"><%=showLanguage.get("cancel order")%></button>
									</c:if>
							</div>
						</c:if>
					</c:forEach>

					<%-- 		end pagination			--%>
					<br/>
				</div>

				<div role="tabpanel" class="tab-pane fade" id="cholayhang">
					<br/>
					<c:forEach items="${listCartItem1}" var="list">
						<c:if test="${list.cart.status==1}">
							<div class="list-product-description product-description-brd margin-bottom-30">
								<div class="row">
									<div class="col-sm-12">
										<c:url value="/image?fname=seller/${list.product.seller.images}"
											   var="imgURL"></c:url>
										<img width="50px" class="img-circle img-thumbnail" src="${imgURL}" alt="">
											${list.product.seller.sellerName } -  <%=showLanguage.get("Code orders")%>: ${list.cartId}
										<hr>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<c:url value="/image?fname=products/${list.product.images}" var="imgURL"></c:url>
										<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}"></a>
										<img class="img-thumbnail" style="width: 100px" src="${imgURL}" alt="">
									</div>
									<div class="col-sm-8 product-description">
										<div class="overflow-h margin-bottom-5">
											<ul class="list-inline overflow-h">
												<li>
													<h4 class="titled-price">
														<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}">${list.product.productName}</a>
													</h4>
												</li>
												<li><span class="gender text-uppercase"></span></li>
												<li class="pull-right">
													<c:if test="${list.cart.status==0}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("wait for confirmation")%></button>
													</c:if>
													<c:if test="${list.cart.status==1}">
														<button type="button" class="btn-u btn-u-sea-shop"><%=showLanguage.get("waiting for the goods")%>
														</button>
													</c:if>
													<c:if test="${list.cart.status==2}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("delivery")%></button>
													</c:if>
													<c:if test="${list.cart.status==3}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("delivered")%></button>
													</c:if>
													<c:if test="${list.cart.status==4}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("cancelled")%></button>
													</c:if>

												</li>
											</ul>
											<div class="margin-bottom-10">
												<span class="compare-in"><%=showLanguage.get("unitprice")%>: ${list.product.price}</span>
											</div>
											<ul class="list-inline add-to-wishlist margin-bottom-20">
												<li class="compare-in"><%=showLanguage.get("quantity")%>: ${list.quantity}</li>
											</ul>
											<br>
											<span class="pull-right title-price"><%=showLanguage.get("subtotal")%>:
													<span class="badge badge-success badge-pill"> ${list.quantity * list.product.price}</span>
												</span>
										</div>
									</div>
								</div>
								<c:if test="${list.cart.status==0}">
									<a href="<c:url value="/member/orderbuy/cancel?id=${list.cart.cartId}&st=4"/>"
									   class="center">
										<button type="button" class="btn btn-danger"><%=showLanguage.get("request cancellation")%></button>
									</a>
								</c:if>
								<c:if test="${list.cart.status==1}">
								<a href="<c:url value="/member/orderbuy/recancel?id=${list.cart.cartId}&st=5"/>"
								   class="center">
									<button type="button" class="btn btn-danger"><%=showLanguage.get("cancel order")%></button>
									</c:if>
							</div>
						</c:if>
					</c:forEach>

					<%-- 		end pagination			--%>
					<br/>
				</div>

				<div role="tabpanel" class="tab-pane fade" id="danggiao">
					<br/>
					<c:forEach items="${listCartItem1}" var="list">
						<c:if test="${list.cart.status==2}">
							<div class="list-product-description product-description-brd margin-bottom-30">
								<div class="row">
									<div class="col-sm-12">
										<c:url value="/image?fname=seller/${list.product.seller.images}"
											   var="imgURL"></c:url>
										<img width="50px" class="img-circle img-thumbnail" src="${imgURL}" alt="">
											${list.product.seller.sellerName } -  <%=showLanguage.get("Code orders")%>: ${list.cartId}
										<hr>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<c:url value="/image?fname=products/${list.product.images}" var="imgURL"></c:url>
										<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}"></a>
										<img class="img-thumbnail" style="width: 100px" src="${imgURL}" alt="">
									</div>
									<div class="col-sm-8 product-description">
										<div class="overflow-h margin-bottom-5">
											<ul class="list-inline overflow-h">
												<li>
													<h4 class="titled-price">
														<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}">${list.product.productName}</a>
													</h4>
												</li>
												<li><span class="gender text-uppercase"></span></li>
												<li class="pull-right">
													<c:if test="${list.cart.status==0}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("wait for confirmation")%></button>
													</c:if>
													<c:if test="${list.cart.status==1}">
														<button type="button" class="btn-u btn-u-sea-shop"><%=showLanguage.get("waiting for the goods")%>
														</button>
													</c:if>
													<c:if test="${list.cart.status==2}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("delivery")%></button>
													</c:if>
													<c:if test="${list.cart.status==3}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("delivered")%></button>
													</c:if>
													<c:if test="${list.cart.status==4}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("cancelled")%></button>
													</c:if>

												</li>
											</ul>
											<div class="margin-bottom-10">
												<span class="compare-in"><%=showLanguage.get("unitprice")%>:  ${list.product.price}</span>
											</div>
											<ul class="list-inline add-to-wishlist margin-bottom-20">
												<li class="compare-in"><%=showLanguage.get("quantity")%>: ${list.quantity}</li>
											</ul>
											<br>
											<span class="pull-right title-price"><%=showLanguage.get("subtotal")%>:
													<span class="badge badge-success badge-pill"> ${list.quantity * list.product.price}</span>
												</span>
										</div>
									</div>
								</div>
								<c:if test="${list.cart.status==0}">
									<a href="<c:url value="/member/orderbuy/cancel?id=${list.cart.cartId}&st=4"/>"
									   class="center">
										<button type="button" class="btn btn-danger"><%=showLanguage.get("request cancellation")%></button>
									</a>
								</c:if>
								<c:if test="${list.cart.status==1}">
								<a href="<c:url value="/member/orderbuy/recancel?id=${list.cart.cartId}&st=5"/>"
								   class="center">
									<button type="button" class="btn btn-danger"><%=showLanguage.get("cancel order")%></button>
									</c:if>
							</div>
						</c:if>
					</c:forEach>

					<%-- 		end pagination			--%>
					<br/>
				</div>

				<div role="tabpanel" class="tab-pane fade" id="dagiao">
					<br/>
					<c:forEach items="${listCartItem1}" var="list">
						<c:if test="${list.cart.status==3}">
							<div class="list-product-description product-description-brd margin-bottom-30">
								<div class="row">
									<div class="col-sm-12">
										<c:url value="/image?fname=seller/${list.product.seller.images}"
											   var="imgURL"></c:url>
										<img width="50px" class="img-circle img-thumbnail" src="${imgURL}" alt="">
											${list.product.seller.sellerName } -  <%=showLanguage.get("Code orders")%>: ${list.cartId}
										<hr>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<c:url value="/image?fname=products/${list.product.images}" var="imgURL"></c:url>
										<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}"></a>
										<img class="img-thumbnail" style="width: 100px" src="${imgURL}" alt="">
									</div>
									<div class="col-sm-8 product-description">
										<div class="overflow-h margin-bottom-5">
											<ul class="list-inline overflow-h">
												<li>
													<h4 class="titled-price">
														<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}">${list.product.productName}</a>
													</h4>
												</li>
												<li><span class="gender text-uppercase"></span></li>
												<li class="pull-right">
													<c:if test="${list.cart.status==0}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("wait for confirmation")%></button>
													</c:if>
													<c:if test="${list.cart.status==1}">
														<button type="button" class="btn-u btn-u-sea-shop"><%=showLanguage.get("waiting for the goods")%>
														</button>
													</c:if>
													<c:if test="${list.cart.status==2}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("delivery")%></button>
													</c:if>
													<c:if test="${list.cart.status==3}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("delivered")%></button>
													</c:if>
													<c:if test="${list.cart.status==4}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("cancelled")%></button>
													</c:if>

												</li>
											</ul>
											<div class="margin-bottom-10">
												<span class="compare-in"><%=showLanguage.get("unitprice")%>:  ${list.product.price}</span>
											</div>
											<ul class="list-inline add-to-wishlist margin-bottom-20">
												<li class="compare-in"><%=showLanguage.get("quantity")%>: ${list.quantity}</li>
											</ul>
											<br>
											<span class="pull-right title-price"><%=showLanguage.get("subtotal")%>:
													<span class="badge badge-success badge-pill"> ${list.quantity * list.product.price}</span>
												</span>
										</div>
									</div>
								</div>
								<c:if test="${list.cart.status==0}">
									<a href="<c:url value="/member/orderbuy/cancel?id=${list.cart.cartId}&st=4"/>"
									   class="center">
										<button type="button" class="btn btn-danger"><%=showLanguage.get("request cancellation")%></button>
									</a>
								</c:if>
								<c:if test="list.cart.status==1">
								<a href="<c:url value="/member/orderbuy/recancel?id=${list.cart.cartId}&st=5"/>"
								   class="center">
									<button type="button" class="btn btn-danger"><%=showLanguage.get("cancel order")%></button>
									</c:if>
							</div>
						</c:if>
					</c:forEach>

					<%-- 		end pagination			--%>
					<br/>
				</div>

				<div role="tabpanel" class="tab-pane fade" id="dahuy">
					<br/>
					<div class="row">
						<div class="col-md-12">
							<c:if test="${huy!=0}">
								<span class="badge badge-danger badge-pill pull-right"><%=showLanguage.get("Total order")%>: ${huy}</span>
							</c:if>
						</div>
					</div>

					<c:forEach items="${listCartItem1}" var="list">
						<c:if test="${list.cart.status==4}">
							<div class="list-product-description product-description-brd margin-bottom-30">
								<div class="row">
									<div class="col-sm-12">
										<c:url value="/image?fname=seller/${list.product.seller.images}"
											   var="imgURL"></c:url>
										<img width="50px" class="img-circle img-thumbnail" src="${imgURL}" alt="">
											${list.product.seller.sellerName } -  <%=showLanguage.get("Code orders")%>: ${list.cartId}
										<hr>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-4">
										<c:url value="/image?fname=products/${list.product.images}" var="imgURL"></c:url>
										<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}"></a>
										<img class="img-thumbnail" style="width: 100px" src="${imgURL}" alt="">
									</div>
									<div class="col-sm-8 product-description">
										<div class="overflow-h margin-bottom-5">
											<ul class="list-inline overflow-h">
												<li>
													<h4 class="titled-price">
														<a href="${pageContext.request.contextPath}/product/detail?productId=${list.productId}">${list.product.productName}</a>
													</h4>
												</li>
												<li><span class="gender text-uppercase"></span></li>
												<li class="pull-right">
													<c:if test="${list.cart.status==0}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("wait for confirmation")%></button>
													</c:if>
													<c:if test="${list.cart.status==1}">
														<button type="button" class="btn-u btn-u-sea-shop"><%=showLanguage.get("waiting for the goods")%>
														</button>
													</c:if>
													<c:if test="${list.cart.status==2}">
														<button type="button" class="btn btn-warning"><%=showLanguage.get("delivery")%></button>
													</c:if>
													<c:if test="${list.cart.status==3}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("delivered")%></button>
													</c:if>
													<c:if test="${list.cart.status==4}">
														<button type="button" class="btn btn-success"><%=showLanguage.get("cancelled")%></button>
													</c:if>

												</li>
											</ul>
											<div class="margin-bottom-10">
												<span class="compare-in"><%=showLanguage.get("unitprice")%>:  ${list.product.price}</span>
											</div>
											<ul class="list-inline add-to-wishlist margin-bottom-20">
												<li class="compare-in"><%=showLanguage.get("quantity")%>: ${list.quantity}</li>
											</ul>
											<br>
											<span class="pull-right title-price"><%=showLanguage.get("subtotal")%>:
													<span class="badge badge-success badge-pill"> ${list.quantity * list.product.price}</span>
												</span>
										</div>
									</div>
								</div>
								<c:if test="${list.cart.status==0}">
									<a href="<c:url value="/member/orderbuy/cancel?id=${list.cart.cartId}&st=4"/>"
									   class="center">
										<button type="button" class="btn btn-danger"><%=showLanguage.get("request cancellation")%></button>
									</a>
								</c:if>
								<c:if test="${list.cart.status==1}">
								<a href="<c:url value="/member/orderbuy/recancel?id=${list.cart.cartId}&st=5"/>"
								   class="center">
									<button type="button" class="btn btn-danger"><%=showLanguage.get("cancel order")%></button>
									</c:if>
							</div>
						</c:if>
					</c:forEach>

					<%-- 		end pagination			--%>
					<br/>
				</div>




				<%--                <div role="tabpanel" class="tab-pane fade" id="choxacnhan">--%>
				<%--                    Danh sách đơn hàng chờ xác nhận <br/>--%>
				<%--                </div>--%>
				<%--                <div role="tabpanel" class="tab-pane fade" id="cholayhang">--%>
				<%--                    Danh sách đơn hàng chờ shipper lấy hàng <br/>--%>
				<%--                </div>--%>
				<%--                <div role="tabpanel" class="tab-pane fade" id="danggiao">--%>
				<%--                    Danh sách đơn hàng đang giao <br/>--%>
				<%--                </div>--%>
				<%--                <div role="tabpanel" class="tab-pane fade" id="dagiao">--%>
				<%--                    Danh sách đơn hàng đã giao thành công <br/>--%>
				<%--                </div>--%>
				<%--                <div role="tabpanel" class="tab-pane fade" id="dahuy">--%>
				<%--                    Danh sách đơn hàng hủy <br/>--%>
				<%--                </div>--%>
			</div>

		</div>
	</div>
</div>

