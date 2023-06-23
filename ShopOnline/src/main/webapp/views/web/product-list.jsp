<%@ page import="java.util.Map" %>
<%@ page import="vn.projectLTW.util.Language" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
<c:url value="/template/assets" var="url"></c:url>


<div class="main">
    <div class="container-fluid">
        <!-- BEGIN SIDEBAR -->
        <div class="sidebar col-md-3 col-sm-5">
            <ul class="list-group margin-bottom-25 sidebar-menu">
                <c:forEach items="${categoryList}" var="cateList">
                    <li class="list-group-item clearfix">
                        <a href="<c:url value="/product/list?categoryId=${cateList.categoryId}&sellerId=0"></c:url>">
                            <img style="width:22px; margin-right:10px"
                                 src="<c:url value="/uploads/category/${cateList.images }"></c:url>">
                            <i class="fa fa-angle-right" style="width:22px"></i>${cateList.categoryName}</a>
                    </li>
                </c:forEach>
            </ul>

            <ul class="list-group margin-bottom-25 sidebar-menu">
                <c:forEach items="${sellerList}" var="sellerList">
                    <li class="list-group-item clearfix">
                        <a href="<c:url value="/product/list?sellerId=${sellerList.sellerId}&categoryId=0"></c:url>"><img
                                style="width:22px" alt=""
                                src="<c:url value="/uploads/seller/${sellerList.images }"></c:url>"> <i
                                class="fa fa-angle-right" style="width:22px"></i>${sellerList.sellerName}</a>
                    </li>
                </c:forEach>

            </ul>

            <%--            <div class="sidebar-filter margin-bottom-25">--%>
            <%--                <h2>Filter</h2>--%>
            <%--                <h3>Availability</h3>--%>
            <%--                <div class="checkbox-list">--%>
            <%--                    <label><input type="checkbox"> Not Available (3)</label> <label><input--%>
            <%--                        type="checkbox"> In Stock (26)</label>--%>
            <%--                </div>--%>

            <%--                <h3>Price</h3>--%>
            <%--                <p>--%>
            <%--                    <label for="amount">Range:</label> <input type="text" id="amount"--%>
            <%--                                                              style="border: 0; color: #f6931f; font-weight: bold;">--%>
            <%--                </p>--%>
            <%--                <div id="slider-range"></div>--%>
            <%--            </div>--%>


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
                    <small class="shop-bg-red badge-results">${countproductAll} <%=showLanguage.get("products")%></small>
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
                                selected="selected">Default
                        </option>
                        <option value="#?sort=pd.name&amp;order=ASC">Name (A -
                            Z)
                        </option>
                        <option value="#?sort=pd.name&amp;order=DESC">Name (Z -
                            A)
                        </option>
                        <option value="#?sort=p.price&amp;order=ASC">Price (Low
                            &gt; High)
                        </option>
                        <option value="#?sort=p.price&amp;order=DESC">Price
                            (High &gt; Low)
                        </option>
                        <option value="#?sort=rating&amp;order=DESC">Rating
                            (Highest)
                        </option>
                        <option value="#?sort=rating&amp;order=ASC">Rating
                            (Lowest)
                        </option>
                        <option value="#?sort=p.model&amp;order=ASC">Model (A -
                            Z)
                        </option>
                        <option value="#?sort=p.model&amp;order=DESC">Model (Z -
                            A)
                        </option>
                    </select>
                    </div>
                </div>
            </div>
            <!-- BEGIN PRODUCT LIST -->
            <c:if test="${empty productList }">
                <div class="alert alert-success">không tìm thấy sản phẩm nào</div>
            </c:if>
            <div class="row product-list">
                <c:forEach items="${productList}" var="proList">
                    <!-- PRODUCT ITEM START -->
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value="/uploads/products/${proList.images}"></c:url>"
                                     class="img-responsive" alt="${proList.productName}">
                                <div>
                                    <a href="<c:url value="/uploads/products/${proList.images}"></c:url>"
                                       class="btn btn-default fancybox-button"><i class="fa fa-search" style="color: white;font-size: 20px" title="<%=showLanguage.get("zoom")%> "></i></a>
                                    <a href="#product-pop-up${proList.productId}"
                                       class="btn btn-default fancybox-fast-view"><i class="fa fa-eye" style="color: white;font-size: 20px" title="<%=showLanguage.get("view")%> "></i></a>
                                </div>
                            </div>
                            <h3>
                                <a href="<c:url value="/product/detail?productId=${proList.productId}"></c:url>">${proList.productName}</a>
                            </h3>
                            <div class="pi-price">${proList.price}</div>
                            <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"
                               class="btn btn-default add2cart" class="btn btn-default add2cart">

                                <i class="fa fa-shopping-cart" title="  <%=showLanguage.get("addtocart")%>" style="font-size: 20px"></i>
                            </a>
                        </div>
                    </div>
                    <!-- PRODUCT ITEM END -->

                    <!-- BEGIN fast view of a product -->
                    <div id="product-pop-up${proList.productId}" style="display: none; width: 700px;">
                        <div class="product-page product-pop-up${proList.productId}">
                            <div class="row">
                                <div class="col-md-6 col-sm-6 col-xs-3">
                                    <div class="product-main-image">
                                        <img src="<c:url value="/uploads/products/${proList.images }"></c:url>"
                                             alt="Cool green dress with red bell 45" class="img-responsive">
                                    </div>
                                    <div class="product-other-images">
                                        <a href="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"
                                           src="<c:url value="/uploads/products/${proList.image2 }"></c:url>"></a>
                                        <a href="<c:url value="/image?fname=products/${proList.image3 }"></c:url>"
                                           src="<c:url value="/uploads/products/${proList.image3 }"></c:url>"></a>
                                        <a href="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"
                                           src="<c:url value="/uploads/products/${proList.image4 }"></c:url>"></a>
                                        <a href="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"
                                           src="<c:url value="/uploads/products/${proList.image5 }"></c:url>"></a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-9">
                                    <h2>${proList.productName}</h2>
                                    <div class="price-availability-block clearfix">
                                        <div class="price">
                                            <strong>${proList.price }</strong>
                                            <em><span>${proList.price/0.8 }</span></em>
                                        </div>
                                        <div class="availability">
                                            <%=showLanguage.get("inventory")%> <strong>${proList.stoke}</strong>
                                        </div>
                                    </div>
                                    <div class="description">
                                        <p>${proList.description }</p>
                                    </div>
                                    <div class="product-page-options">
                                        <div class="pull-left">
                                            <label class="control-label"><%=showLanguage.get("size")%></label> <select
                                                class="form-control input-sm">
                                            <option>L</option>
                                            <option>M</option>
                                            <option>XL</option>
                                        </select>
                                        </div>
                                        <div class="pull-left">
                                            <label class="control-label"><%=showLanguage.get("color")%></label> <select
                                                class="form-control input-sm">
                                            <option>Red</option>
                                            <option>Blue</option>
                                            <option>Black</option>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="product-page-cart">
                                        <form name="f1" method="get"
                                              action="<c:url value="/member/cart/updateQuantity"></c:url>">


                                            <input type="text" name="pId" id="pid"
                                                   value="${proList.productId}" hidden="">

                                            <input type="text" id="stock${proList.productId}" value="${proList.stoke}"
                                                   hidden="">

                                            <button type="button" class="quantity-button"
                                                    name='subtract${proListproductId}'
                                                    onclick='javascript: subtractQty0(${proList.productId});'
                                                    value="-" title="Giảm số lượng">-
                                            </button>

                                            <input readonly type="text" name="quantity"
                                                   value="${1}"
                                                   id="product-quantity${proList.productId}"
                                                   style="width: 40px"/>


                                            <button type="button" class="quantity-button"
                                                    name='add${proList.productId}'
                                                    onclick='javascript: subtractQty9(${proList.productId});'
                                                    value="+" title="Tăng số lượng">+
                                            </button>
                                            &nbsp;&nbsp


                                        </form>
                                        </td>
                                        <br>
                                        <button class="btn btn-primary" type="submit" title="<%=showLanguage.get("addtocart")%>"><%=showLanguage.get("addtocart")%></button>
                                        <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>"
                                           class="btn btn-default" title="<%=showLanguage.get("seedetails")%>"><%=showLanguage.get("seedetails")%></a>
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

            <!-- BEGIN PAGINATOR -->
            <c:if test="${categoryId==0&&sellerId==0 }">
                <div class="row">
                        <%--                    <div class="col-md-4 col-sm-4 items-info">Items 1 to 9 of 10--%>
                        <%--                        total--%>
                        <%--                    </div>--%>
                    <div class="col-md-8 col-sm-8">
                        <ul class="pagination pull-right">
                            <c:if test="${tag>1 }">
                                <li><a
                                        href="${pageContext.request.contextPath}/product/list?index=${tag-1}&categoryId=0&sellerId=0">&laquo;</a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${endP}" var="i">
                                <li class='${tag==i?"active":""}'><a
                                        href="${pageContext.request.contextPath}/product/list?index=${i}&categoryId=0&sellerId=0">${i}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${tag<endP}">
                                <li><a
                                        href="${pageContext.request.contextPath}/product/list?index=${tag+1}&categoryId=0&sellerId=0">&laquo;</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </c:if>

            <c:if test="${categoryId!=0&&sellerId==0 }">
                <div class="row">
                        <%--                    <div class="col-md-4 col-sm-4 items-info">Items 1 to 9 of 10--%>
                        <%--                        total--%>
                        <%--                    </div>--%>
                    <div class="col-md-8 col-sm-8">
                        <ul class="pagination pull-right">
                            <c:if test="${tag>1 }">
                                <li><a
                                        href="${pageContext.request.contextPath}/product/list?index=${tag-1}&categoryId=${categoryId}&sellerId=0">&laquo;</a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${endP}" var="i">
                                <li class='${tag==i?"active":""}'><a
                                        href="${pageContext.request.contextPath}/product/list?index=${i}&categoryId=${categoryId}&sellerId=0">${i}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${tag<endP}">
                                <li><a
                                        href="${pageContext.request.contextPath}/product/list?index=${tag+1}&${categoryId}&sellerId=0">&laquo;</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </c:if>

            <c:if test="${categoryId==0&&sellerId!=0 }">
                <div class="row">
                        <%--                    <div class="col-md-4 col-sm-4 items-info">Items 1 to 9 of 10--%>
                        <%--                        total--%>
                        <%--                    </div>--%>
                    <div class="col-md-8 col-sm-8">
                        <ul class="pagination pull-right">
                            <c:if test="${tag>1 }">
                                <li><a
                                        href="${pageContext.request.contextPath}/product/list?index=${tag-1}&categoryId=0&sellerId=${sellerId}">&laquo;</a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${endP}" var="i">
                                <li class='${tag==i?"active":""}'><a
                                        href="${pageContext.request.contextPath}/product/list?index=${i}&categoryId=0&sellerId=${sellerId}">${i}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${tag<endP}">
                                <li><a
                                        href="${pageContext.request.contextPath}/product/list?index=${tag+1}&categoryId=0&sellerId=${sellerId}">&laquo;</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </c:if>
            <!-- END PAGINATOR -->
        </div>
        <!-- END CONTENT -->

    </div>
</div>
 