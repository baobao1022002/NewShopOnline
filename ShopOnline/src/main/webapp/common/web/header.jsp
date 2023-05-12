<%@ page import="java.util.Map" %>
<%@ page import="vn.projectLTW.util.Language" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/template/assets" var="url"></c:url>
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


           <!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i>0987 654 321</li>
                        <!-- BEGIN CURRENCIES -->
                        <li class="shop-currencies">
                            <a href="javascript:void(0);">€</a>
                            <a href="javascript:void(0);">$</a>
                            <a href="javascript:void(0);" class="current">VND</a>
                        </li>
                        <!-- END CURRENCIES -->
                        <!-- BEGIN LANGS -->
                        <li class="langs-block">
                            <a href="LanguageServlet?lang=English" class="current"><%=showLanguage.get("english")%></a>
                        </li>
                        <li>
                            <a href="LanguageServlet?lang=Vietnamese"><%=showLanguage.get("vietnamese")%></a>

                        </li>
                        <!-- END LANGS -->
                    </ul>
                </div>
                <!-- END TOP BAR LEFT PART -->
                <!-- BEGIN TOP BAR MENU -->
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                    	<c:choose>
                    		<c:when test="${sessionScope.account!=null}">

		                        <li><a href="shop-account.html"><%=showLanguage.get("account")%></a></li>
<%--		                        <li><a href="shop-checkout.html"><%=showLanguage.get("Change password")%></a></li>--%>
                                <li><a href="<c:url value="/ChangePassword"></c:url>">Đổi mật khẩu</a></li>
<%--                                <li><a href="<c:url value="/member/orderbuy"></c:url>"><%=showLanguage.get("Order management")%></a></li>--%>
                            <li><a href="<c:url value="/member/orderbuy"></c:url>">Đơn mua</a></li>
		                        <li><a href="<c:url value="/logout"></c:url>"><%=showLanguage.get("logout")%></a></li>





<%--		                        <li>--%>
<%--		                        	 <img alt="" width="26px" class="img-circle" src="<c:url value="/image?fname=users/${sessionScope.account.images}"/>"/>--%>
<%--		                        	 ${sessionScope.account.fullName}--%>
<%--		                        </li>--%>
	                        </c:when>
	                        <c:otherwise>
	                        		<li><a href="<c:url value="/login"></c:url>"><%=showLanguage.get("login")%></a></li>
                                <li><a href="<c:url value="/register"></c:url>"><%=showLanguage.get("register")%></a></li>
	                        </c:otherwise>


	                    </c:choose>
                    </ul>
                </div>
                <!-- END TOP BAR MENU -->
            </div>
        </div>        
    </div>
    <!-- END TOP BAR -->


    <div class="header">
      <div class="container">
        <a class="site-logo" href="<c:url value="/home"></c:url>"><img src="${url}/frontend/layout/img/logos/logo-shop-red.png" alt="Metronic Shop UI"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN CART -->
        <div class="top-cart-block">
          <div class="top-cart-info">
          	<c:set var="count" 	value="${0}"></c:set>
          	<c:set var="totals" value="${0}"></c:set>
          	<c:forEach items="${sessionScope.cart}" var="map">
          		<c:set var="count" 	value="${count+map.value.quantity}"></c:set>
          		<c:set var="totals" value="${totals+map.value.quantity*map.value.product.price}"></c:set>
          	</c:forEach>
            <a href="javascript:void(0);" class="top-cart-info-count">${count} <%=showLanguage.get("items")%></a>
            <a href="javascript:void(0);" class="top-cart-info-value">${totals }VND</a>
          </div>
          <i class="fa fa-shopping-cart"></i>
                        
          <div class="top-cart-content-wrapper">
            <div class="top-cart-content">
              <ul class="scroller" style="height: 250px;">
              	<c:forEach items="${sessionScope.cart}" var="map">
              		 <li>
		                  <a href="<c:url value="/product/detail?productId=${map.value.product.productId}"></c:url>"><img src="<c:url value="/image?fname=products/${map.value.product.images}"></c:url>" alt="${map.value.product.productName}" width="37" height="34"></a>
		                  <span class="cart-content-count">x ${map.value.quantity}</span>
		                  <strong><a href="shop-item.html">${map.value.quantity}</a></strong>
		                  <em>${map.value.product.price * map.value.quantity}VND</em>
		                  <a href="${pageContext.request.contextPath}/member/cart/remove?pId=${map.value.product.productId}" class="del-goods">&nbsp;</a>
                	</li>
              	</c:forEach>
               
               </ul>
              <div class="text-right">
                <a href="${pageContext.request.contextPath}/member/cart" class="btn btn-default"><%=showLanguage.get("viewcart")%></a>
                <a href="${pageContext.request.contextPath}/member/order" class="btn btn-primary"><%=showLanguage.get("checkout")%></a>
              </div>
            </div>
          </div>            
        </div>
        <!--END CART -->

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
          <ul>
          	 <li><a href="<c:url value="/home"></c:url>"><%=showLanguage.get("home")%></a><li>
             <li><a href="<c:url value="/product/list?categoryId=0&sellerId	=0"></c:url>"><%=showLanguage.get("products")%></a><li>
	         <!-- BEGIN TOP SEARCH -->
	            <li class="menu-search">
	              <span class="sep"></span>
	              <i class="fa fa-search search-btn" title="<%=showLanguage.get("search")%>"></i>
	              <div class="search-box">
                      <form method="post" action="SearchServlet">
                          <div class="input-group">
                              <input type="text" name="txtSearch" placeholder="<%=showLanguage.get("search")%>" class="form-control">
                              <span class="input-group-btn">
	                      <button class="btn btn-primary" type="submit"><%=showLanguage.get("search")%></button>
	                    </span>
                          </div>
                      </form>
	              </div> 
	            </li>
	            <!-- END TOP SEARCH -->
          </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>
   