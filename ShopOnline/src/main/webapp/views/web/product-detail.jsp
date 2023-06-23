<%@ page import="vn.projectLTW.util.Language" %>
<%@ page import="java.util.Map" %>
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
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
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
            </div>
            <!-- END SIDEBAR -->

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-7" style="margin: -200px 0 0 290px">
                <div class="product-page">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <div class="product-main-image">
                                <img src="<c:url value="/uploads/products/${product.images}"></c:url>"
                                     alt="Cool green dress with red bell" class="img-responsive"
                                     data-BigImgsrc="<c:url value="/uploads/products/${product.images}"></c:url>">
                            </div>
                            <div class="product-other-images">
                                <a href="<c:url value="/image?fname=products/${product.image2}"></c:url>"
                                   rel="photos-lib"><img alt="Berry Lace Dress"
                                                         src="<c:url value="/uploads/products/${product.image2}"></c:url>"></a>
                                <a href="<c:url value="/image?fname=products/${product.image3}"></c:url>"
                                   class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress"
                                                                                 src="<c:url value="/uploads/products/${product.image3}"></c:url>"></a>
                                <a href="<c:url value="/image?fname=products/${product.image4}"></c:url>"
                                   class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress"
                                                                                 src="<c:url value="/uploads/products/${product.image4}"></c:url>"></a>
                                <a href="<c:url value="/image?fname=products/${product.image5}"></c:url>"
                                   class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress"
                                                                                 src="<c:url value="/uploads/products/${product.image5}"></c:url>"></a>

                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <h1>${product.productName}</h1>
                            <div class="price-availability-block clearfix">
                                <div class="price">
                                    <strong>${product.price}</strong>
                                    <em><span>${product.price/0.25}</span></em>
                                </div>
                                <div class="availability">
                                    <%=showLanguage.get("inventory")%>: <strong>${product.stoke}</strong>
                                </div>
                            </div>
                            <div class="description">
                                <p>${product.description}</p>
                            </div>
                            <div class="product-page-options">
                                <div class="pull-left">
                                    <label class="control-label"><%=showLanguage.get("size")%>:</label>
                                    <select class="form-control input-sm">
                                        <option>L</option>
                                        <option>M</option>
                                        <option>XL</option>
                                    </select>
                                </div>
                                <div class="pull-left">
                                    <label class="control-label"><%=showLanguage.get("color")%>:</label>
                                    <select class="form-control input-sm">
                                        <option>Red</option>
                                        <option>Blue</option>
                                        <option>Black</option>
                                    </select>
                                </div>
                            </div>
                            <div class="product-page-cart" >
                                <form name="f1" method="get"
                                      action="<c:url value="/member/cart/updateQuantity"></c:url>">


                                    <input type="text" name="pId" id="pid"
                                           value="${product.productId}" hidden="">

                                    <input type="text" id="stock${product.productId}" value="${product.stoke}" hidden="">

                                    <button type="button" class="quantity-button"
                                            name='subtract${product.productId}'
                                            onclick='javascript: subtractQty0(${product.productId});'
                                            value="-">-
                                    </button>

                                    <input readonly type="text" name="quantity"
                                           value="${1}"
                                           id="product-quantity${product.productId}"
                                           style="width: 40px"/>




                                    <button type="button" class="quantity-button"
                                            name='add${product.productId}'
                                            onclick='javascript: subtractQty9(${product.productId});'
                                            value="+">+
                                    </button>
<%--                                    <button type="submit" class="btn btn-danger">Cập nhật</button>--%>
                                    <nbsp></nbsp>
                                    <%--    <button type="submit" class="btn btn-danger">Thêm vào giỏ hàng</button>--%>
                                </form>
                                </td>
                                </br>
                                </br>
                                <a href="<c:url value="/member/cart/add?pId=${product.productId}&quantity=1"/>"
                                   class="btn btn-primary add2cart"><%=showLanguage.get("addtocart")%></a>
                            </div>
                            <div class="review">
                                <input type="range" value="4" step="0.25" id="backing4">
                                <div class="rateit" data-rateit-backingfld="#backing4" data-rateit-resetable="false"
                                     data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5">
                                </div>
                               &nbsp;<a href="#">Viết đánh giá</a>
                            </div>
                            <ul class="social-icons">
                                <li><a class="facebook" data-original-title="facebook" href="#"></a></li>
                                <li><a class="twitter" data-original-title="twitter" href="#"></a></li>
                                <li><a class="googleplus" data-original-title="googleplus" href="#"></a></li>
                                <li><a class="evernote" data-original-title="evernote" href="#"></a></li>
                                <li><a class="tumblr" data-original-title="tumblr" href="#"></a></li>
                            </ul>
                        </div>

                        <div class="product-page-content">
                            <ul id="myTab" class="nav nav-tabs">
                                <li><a href="#Description" data-toggle="tab">Mô tả</a></li>
                                <li class="active"><a href="#Reviews" data-toggle="tab">Đánh giá</a></li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane fade" id="Description">
                                    <p>${product.description}</p>
                                </div>

                                <div class="tab-pane fade in active" id="Reviews">
                                    <!--<p>There are no reviews for this product.</p>-->
                                    <div class="review-item clearfix">
                                        <div class="review-item-submitted">
                                            <strong>Hà</strong>
                                            <em>01/02/2023 - 07:37</em>
                                            <div class="rateit" data-rateit-value="5" data-rateit-ispreset="true"
                                                 data-rateit-readonly="true"></div>
                                        </div>
                                        <div class="review-item-content">
                                            <p>Tôi rất hài lòng với chất lượng của sản phẩm quần áo của shop này. Đường may chắc chắn, không bị xù lông và màu sắc vẫn giữ nguyên sau một thời gian sử dụng.</p>
                                        </div>
                                    </div>
                                    <div class="review-item clearfix">
                                        <div class="review-item-submitted">
                                            <strong>Minh</strong>
                                            <em>22/11/2022 - 17:49</em>
                                            <div class="rateit" data-rateit-value="2.5" data-rateit-ispreset="true"
                                                 data-rateit-readonly="true"></div>
                                        </div>
                                        <div class="review-item-content">
                                            <p>Sản phẩm quần áo của shop này thực sự tuyệt vời với chất lượng vượt trội. Chất liệu cao cấp và thiết kế tỉ mỉ tạo nên một sản phẩm vừa vặn, thoải mái và bền bỉ.</p>
                                        </div>
                                    </div>

                                    <!-- BEGIN FORM-->
                                    <form action="#" class="reviews-form" role="form">
                                        <h2>Viết đánh giá</h2>
                                        <div class="form-group">
                                            <label for="name">Họ tên<span class="require">*</span></label>
                                            <input type="text" class="form-control" id="name">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="text" class="form-control" id="email">
                                        </div>
                                        <div class="form-group">
                                            <label for="review">Đánh giá <span class="require">*</span></label>
                                            <textarea class="form-control" rows="8" id="review"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Xếp hạng</label>
                                            <input type="range" value="4" step="0.25" id="backing5">
                                            <div class="rateit" data-rateit-backingfld="#backing5"
                                                 data-rateit-resetable="false" data-rateit-ispreset="true"
                                                 data-rateit-min="0" data-rateit-max="5">
                                            </div>
                                        </div>
                                        <div class="padding-top-20">
                                            <button type="submit" class="btn btn-primary">Gửi</button>
                                        </div>
                                    </form>
                                    <!-- END FORM-->
                                </div>
                            </div>
                        </div>

                        <div class="sticker sticker-sale"></div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

		