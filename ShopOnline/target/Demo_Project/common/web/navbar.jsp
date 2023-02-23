<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <c:url value="/template/web/static" var="url"></c:url>
      
 <div class="navbar navbar-default mega-menu" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath }">
                        <img id="logo-header" src="${url}/img/logo.png" alt="Logo" height="50">
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-responsive-collapse">
                    <!-- Shopping Cart -->
                   <jsp:include page="/views/web/cart.jsp"></jsp:include>
                    <!-- End Shopping Cart -->

                    <!-- Nav Menu -->
                    <ul class="nav navbar-nav">
                        <!-- Pages -->
                        <li class="dropdown active">
                            <a href="${pageContext.request.contextPath }">
                                Trang chủ
                            </a>
                            
                        </li>
                        <!-- End Pages -->

                        <!-- Promotion -->
                        <%-- <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">
                                Danh mục
                            </a>
                            <ul class="dropdown-menu">
								<c:forEach var="item" items="${catelist}">
							<c:url var="editURL" value="/product/list">
								<c:param name="CategoryID" value="${item.id}" />
							</c:url>
							<li class="${tag == item.id ? "active":""}">
							<c:forEach var="item1" items="${countcate}">
								<c:if test="${item1.catid == item.id}">
							   <i></i> 
								<a href="${editURL}&index1=-2">${item.name} 
									<small>
										 (${item1.total})
									</small>	 
								</a>
							
							</c:if>
							</c:forEach>
							</li>
						</c:forEach>
				</ul> --%>
                            
                            
                           
                        <!-- End Promotion -->

                        <!-- Gifts -->
                        <li class="dropdown mega-menu-fullwidth">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-hover="dropdown" data-toggle="dropdown">
                                Danh mục
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <div class="mega-menu-content">
                                        <div class="container">
                                            <div class="row">
                                                <c:forEach var="item" items="${catelist}">
							<c:url var="editURL" value="/product/list">
								<c:param name="CategoryID" value="${item.id}" />
							</c:url>
							<c:url value="/image?fname=${item.icon }" var="imgUrl"></c:url>
						
                                                <div class="col-md-3 col-sm-4 col-xs-4 md-margin-bottom-30">
                                                    <c:forEach var="item1" items="${countcate}">
								<c:if test="${item1.catid == item.id}">
								
								<a href="${editURL}&index1=-2">
								<img class="product-offers img-responsive" width="80px" src="${imgUrl}" alt="${item.name}"></a>
								<h5><span class="gender text-uppercase">${item.name} </span></h5>
								 <h6><span class="gender text-uppercase">${item1.total} sản phẩm </span></h6>
							
								
								
								
							</c:if>
							</c:forEach>
                                                    
                                                </div>
                                                </c:forEach>
                                            </div><!--/end row-->
                                        </div><!--/end container-->
                                    </div><!--/end mega menu content-->  
                                </li>
                            </ul><!--/end dropdown-menu-->
                        </li>
                        <!-- End Gifts -->

                        <!-- Sản phẩm -->
                        <li class="dropdown mega-menu-fullwidth">
                            <a href="${pageContext.request.contextPath }/product/list?index=1&index1=-1">
                                Sản phẩm
                            </a>
                         </li>
                        <!-- End Sản Phẩm -->
 <!-- Đơn đã mua -->
                       <c:if test="${sessionScope.account.roleid==3}">
							<li class="dropdown mega-menu-fullwidth">
                            <a href="${pageContext.request.contextPath }/member/orderbuylist">
                                Đơn đã mua
                            </a>
                         </li>
                         <li>
						<a href="http://localhost:8080/BanHang/">
							Kênh Người Bán
						</a>
					</li>
						</c:if>
						 <c:if test="${sessionScope.account.roleid==5}">
							<li class="dropdown mega-menu-fullwidth">
                            <a href="${pageContext.request.contextPath }/member-orderbuylist">
                                Đơn đã mua
                            </a>
                         </li>
						</c:if>
                        <!-- End Đơn đã mua -->
                           </ul>
                    <!-- End Nav Menu -->                    
                </div>
            </div>    
        </div>            