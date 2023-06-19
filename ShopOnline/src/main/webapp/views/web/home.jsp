<%@ page import="java.util.Map" %>
<%@ page import="vn.projectLTW.util.Language" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
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

<!-- BEGIN SLIDER -->
<div class="page-slider margin-bottom-35">
    <!-- LayerSlider start -->
    <div id="layerslider"
         style="width: 100%; height: 494px; margin: 0 auto;">

        <!-- slide one start -->
        <div class="ls-slide ls-slide1"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 24,25,27,28;">

            <img src="${url}/frontend/pages/img/layerslider/slide1/bg.jpg"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title"
                 style="top: 96px; left: 35%; white-space: nowrap;"
                 data-ls="
            fade: true; 
            fadeout: true; 
            durationin: 750; 
            durationout: 750; 
            easingin: easeOutQuint; 
            rotatein: 90; 
            rotateout: -90; 
            scalein: .5; 
            scaleout: .5; 
            showuntil: 4000;
          ">
                Tones of <strong>shop UI features</strong> designed
            </div>

            <div class="ls-l ls-mini-text"
                 style="top: 338px; left: 35%; white-space: nowrap;"
                 data-ls="
          fade: true; 
          fadeout: true; 
          durationout: 750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          showuntil: 4000;
          ">
                Lorem ipsum dolor sit amet constectetuer diam<br> adipiscing
                elit euismod ut laoreet dolore 22.
            </div>
        </div>
        <!-- slide one end -->

        <!-- slide two start -->
        <div class="ls-slide ls-slide2"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

            <img src="${url}/frontend/pages/img/layerslider/slide2/bg.jpg"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title"
                 style="top: 40%; left: 21%; white-space: nowrap;"
                 data-ls="
          fade: true; 
          fadeout: true;  
          durationin: 750; durationout: 109750; 
          easingin: easeOutQuint; 
          easingout: easeInOutQuint; 
          delayin: 0; 
          delayout: 0; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;
          ">
                <strong>Unlimted</strong> Layout Options <em>Fully Responsive</em>
            </div>

            <div class="ls-l ls-price"
                 style="top: 50%; left: 45%; white-space: nowrap;"
                 data-ls="
          fade: true; 
          fadeout: true;  
          durationout: 109750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          scalein: .8; 
          scaleout: .8; 
          showuntil: 4000;">
                <b>from</b> <strong><span>$</span>25</strong>
            </div>

            <a href="#" class="ls-l ls-more"
               style="top: 72%; left: 21%; display: inline-block; white-space: nowrap;"
               data-ls="
          fade: true; 
          fadeout: true; 
          durationin: 750; 
          durationout: 750; 
          easingin: easeOutQuint; 
          easingout: easeInOutQuint; 
          delayin: 0; 
          delayout: 0; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;">See
                More Details </a>
        </div>
        <!-- slide two end -->

        <!-- slide three start -->
        <div class="ls-slide ls-slide3"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 92,93,105;">

            <img src="${url}/frontend/pages/img/layerslider/slide3/bg.jpg"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title"
                 style="top: 83px; left: 33%; white-space: nowrap;"
                 data-ls="
          fade: true; 
          fadeout: true; 
          durationin: 750; 
          durationout: 750; 
          easingin: easeOutQuint; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;
          ">
                Full Admin &amp; Frontend <strong>eCommerce UI</strong> Is Ready For
                Your Project
            </div>
            <div class="ls-l"
                 style="top: 333px; left: 33%; white-space: nowrap; font-size: 20px; font: 20px 'Open Sans Light', sans-serif;"
                 data-ls="
          fade: true; 
          fadeout: true; 
          durationout: 750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          scalein: .8; 
          scaleout: .8; 
          showuntil: 4000;
          ">
                <a href="#" class="ls-buy"> Buy It Now! </a>
                <div class="ls-price">
                    <span>All these for only:</span> <strong>25<sup>$</sup></strong>
                </div>
            </div>
        </div>
        <!-- slide three end -->

        <!-- slide four start -->
        <div class="ls-slide ls-slide4"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

            <img src="${url}/frontend/pages/img/layerslider/slide5/bg.jpg"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title"
                 style="top: 35%; left: 60%; white-space: nowrap;"
                 data-ls="
          fade: true; 
          fadeout: true; 
          durationin: 750; 
          durationout: 750; 
          easingin: easeOutQuint; 
          rotatein: 90; 
          rotateout: -90; 
          scalein: .5; 
          scaleout: .5; 
          showuntil: 4000;">
                The most<br> wanted bijouterie
            </div>

            <div class="ls-l ls-mini-text"
                 style="top: 70%; left: 60%; white-space: nowrap;"
                 data-ls="
          fade: true; 
          fadeout: true;  
          durationout: 750; 
          easingin: easeOutQuint; 
          delayin: 300; 
          scalein: .8; 
          scaleout: .8; 
          showuntil: 4000;">
                <span>Lorem ipsum and</span> <a href="#">Buy It Now!</a>
            </div>

        </div>
        <!-- slide four end -->
    </div>
    <!-- LayerSlider end -->
</div>
<!-- END SLIDER -->

<div class="main">
    <div class="container-fluid">
        <%--        <%--%>
        <%--            String id = request.getAttribute("id").toString();--%>
        <%--            String name = request.getAttribute("name").toString();--%>
        <%--            String email = request.getAttribute("email").toString();--%>
        <%--            out.print("Id: " + id);--%>
        <%--            out.print("<br/>Name: " + name);--%>
        <%--            out.print("<br/>Email: " + email);--%>
        <%--        %>--%>
        <!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SALE PRODUCT -->

            <div class="col-md-12 sale-product">
                <h2><%=showLanguage.get("newproducts")%></h2>
                <div class="owl-carousel owl-carousel5">
                    <c:forEach items="${productListNew}" var="proList">
                        <div>
                            <div class="product-item">
                                <div class="pi-img-wrapper">
                                    <img src="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                         class="img-responsive" alt="Berry Lace Dress">
                                    <div>
                                        <a href="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                           class="btn btn-default fancybox-button"><i class="fa fa-search" style="color: white;font-size: 20px" title="<%=showLanguage.get("zoom")%> "></i></a>
                                        <a href="#product-pop-up${proList.productId}"
                                           class="btn btn-default fancybox-fast-view"> <i class="fa fa-eye" style="color: white;font-size: 20px" title="<%=showLanguage.get("view")%> "></i></a>
                                    </div>
                                </div>
                                <h3>
                                    <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>">${proList.productName}</a>
                                </h3>
                                <div class="pi-price">${proList.price}</div>
                                <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"
                                   class="btn btn-default add2cart" class="btn btn-default add2cart">
                                    <i class="fa fa-shopping-cart" title="  <%=showLanguage.get("addtocart")%>" style="font-size: 20px"></i>
                                </a>

                                <div class="sticker sticker-sale"></div>
                            </div>
                        </div>

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
                                            <a href="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"
                                               class="active"><img alt="Berry Lace Dress"
                                                                   src="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"></a>

                                            <a href="<c:url value="/image?fname=products/${proList.image3 }"></c:url>">
                                                <img alt="Berry Lace Dress"
                                                     src="<c:url value="/image?fname=products/${proList.image3 }"></c:url>"></a>

                                            <a href="<c:url value="/image?fname=products/${proList.image4 }"></c:url>">
                                                <img
                                                        alt="Berry Lace Dress"
                                                        src="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image5 }"></c:url>">
                                                <img
                                                        alt="Berry Lace Dress"
                                                        src="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"></a>
                                            <br>




                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-9">
                                        <h2>${proList.productName}</h2>
                                        <h4><%=showLanguage.get("category")%>: ${proList.category.categoryName} -
                                            <%=showLanguage.get("shop")%>: ${proList.seller.sellerName }</h4>
                                        <div class="price-availability-block clearfix">
                                            <div class="price">
                                                <strong>${proList.price }</strong>
                                                <em><span>${proList.price/0.8 }</span></em>
                                            </div>
                                            <div class="availability">
                                                <%=showLanguage.get("inventory")%>: <strong>${proList.stoke}</strong>
                                            </div>
                                        </div>
                                        <div class="description">
                                            <p>${proList.description }</p>
                                        </div>
                                        <div class="product-page-options">
                                            <div class="pull-left">
                                                <label class="control-label"><%=showLanguage.get("size")%>:</label> <select
                                                    class="form-control input-sm">
                                                <option>L</option>
                                                <option>M</option>
                                                <option>XL</option>
                                            </select>
                                            </div>
                                            <div class="pull-left">
                                                <label class="control-label"><%=showLanguage.get("color")%>:</label> <select
                                                    class="form-control input-sm">
                                                <option>Red</option>
                                                <option>Blue</option>
                                                <option>Black</option>
                                            </select>
                                            </div>
                                        </div>
                                        <div class="product-page-cart">
                                            <form name="f1" method="get"
                                                  action="<c:url value="/member/cart/add"></c:url>">
                                                <input type="text" name="pId" id="pid1"
                                                       value="${proList.productId}" hidden="">
                                                <input type="text" id="stock1${proList.productId}" value="${proList.stoke}"
                                                       hidden="">

                                                <button type="button" class="quantity-button"
                                                        name='subtract${proList.productId}'
                                                        onclick='javascript: subtractQty1(${proList.productId});'
                                                        value="-">-
                                                </button>

                                                <input readonly type="text" name="quantity"
                                                       value="1"
                                                       id="product-quantity1${proList.productId}"
                                                       style="width: 50px"/>
                                                <button type="button" class="quantity-button"
                                                        name='add${proList.productId}'
                                                        onclick='javascript: subtractQty2(${proList.productId});'
                                                        value="+">+
                                                </button>
                                                &nbsp;
                                                &nbsp;
                                                <button type="submit" class="btn btn-primary" title="<%=showLanguage.get("addtocart")%>"><%=showLanguage.get("addtocart")%></button>

                                            </form>
                                            <hr>
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
            </div>
            <!-- END SALE PRODUCT -->
        </div>
        <!-- END SALE PRODUCT & NEW ARRIVALS -->

        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40 ">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-4">
                <ul class="list-group margin-bottom-25 sidebar-menu">

                    <c:forEach items="${categoryList}" var="cateList">
                        <li class="list-group-item clearfix"><a
                                href="<c:url value="/product/list?categoryId=${cateList.categoryId}&sellerId=0"></c:url>">
                            <img
                                    style="width: 22px; margin-right: 10px"
                                    src="<c:url value="/image?fname=category/${cateList.images }"></c:url>">
                            <i
                                    class="fa fa-angle-right"></i>${cateList.categoryName}</a></li>

                        <!-- BEGIN fast view of a product -->
                        <div id="product-pop-upp${proList.productId }" style="display: none; width: 700px;">
                            <div class="product-page product-pop-upp${proList.productId }">
                                <div class="row">
                                    <div class="col-md-6 col-sm-6 col-xs-3">
                                        <div class="product-main-image">
                                            <img src="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                                 alt="Cool green dress with red bell 12" class="img-responsive">
                                        </div>
                                        <div class="product-other-images">

                                            <a href="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"
                                               class="active"><img alt="Berry Lace Dress"
                                                                   src="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image3 }"></c:url>">
                                                <img alt="Berry Lace Dress"
                                                     src="<c:url value="/image?fname=products/${proList.image3 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"><img
                                                    alt="Berry Lace Dress"
                                                    src="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"></a>
                                            <br>

                                            <a href="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"><img
                                                    alt="Berry Lace Dress"
                                                    src="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"></a>

                                        </div>
                                        <div class="col-md-6 col-sm-6 col-xs-9">
                                            <h2>${proList.productName}</h2>
                                            <h4><%=showLanguage.get("category")%>: ${proList.category.categoryName} -
                                                <%=showLanguage.get("shop")%>: ${proList.seller.sellerName }</h4>
                                            <div class="price-availability-block clearfix">
                                                <div class="price">
                                                    <strong>${proList.price }</strong>
                                                    <em><span>${proList.price/0.8 }</span></em>
                                                </div>
                                                <div class="availability">
                                                    <%=showLanguage.get("inventory")%>: <strong>${proList.amount}</strong>
                                                </div>
                                            </div>
                                            <div class="description">
                                                <p>${proList.description }</p>
                                            </div>
                                            <div class="product-page-options">
                                                <div class="pull-left">
                                                    <label class="control-label"><%=showLanguage.get("size")%>:</label> <select
                                                        class="form-control input-sm">
                                                    <option>L</option>
                                                    <option>M</option>
                                                    <option>XL</option>
                                                </select>
                                                </div>
                                                <div class="pull-left">
                                                    <label class="control-label"><%=showLanguage.get("color")%>:</label> <select
                                                        class="form-control input-sm">
                                                    <option>Red</option>
                                                    <option>Blue</option>
                                                    <option>Black</option>
                                                </select>
                                                </div>
                                            </div>
                                            <div class="product-page-cart">
                                                <form name="f1" method="get"
                                                      action="<c:url value="/member/cart/add"></c:url>">
                                                    <input type="text" name="pId" id="pid2"
                                                           value="${proList.productId}" hidden="">
                                                    <input type="text" id="stock2${proList.productId}" value="${proList.stoke}"
                                                           hidden="">

                                                    <button type="button" class="quantity-button"
                                                            name='subtract${proList.productId}'
                                                            onclick='javascript: subtractQty3(${proList.productId});'
                                                            value="-">-
                                                    </button>

                                                    <input readonly type="text" name="quantity"
                                                           value="1"
                                                           id="product-quantity2${proList.productId}"
                                                           style="width: 50px"/>
                                                    <button type="button" class="quantity-button"
                                                            name='add${proList.productId}'
                                                            onclick='javascript: subtractQty4(${proList.productId});'
                                                            value="+">+
                                                    </button>
                                                    &nbsp;
                                                    &nbsp;
                                                    <button type="submit" class="btn btn-primary"><%=showLanguage.get("addtocart")%></button>

                                                </form>
                                                <div class="product-quantity">
                                                    <input id="product-quantity2" type="text" value="1" readonly
                                                           name="product-quantity2" class="form-control input-sm">
                                                </div>
                                                <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"
                                                   class="btn btn-primary add2cart" type="submit">Cho vào giỏ hàng</a>
                                                <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>"
                                                   class="btn btn-default"><%=showLanguage.get("seedetails")%></a>
                                            </div>
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
                                                Số lượng tồn: <strong>${proList.amount}</strong>
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
                                            <form name="f1" method="get"
                                                  action="<c:url value="/member/cart/add"></c:url>">
                                                <input type="text" name="pId" id="pid3"
                                                       value="${proList.productId}" hidden="">
                                                <input type="text" id="stock2${proList.productId}" value="${proList.stoke}"
                                                       hidden="">


                                                <button type="button" class="quantity-button"
                                                        name='subtract${proList.productId}'
                                                        onclick='javascript: subtractQty3(${proList.productId});'
                                                        value="-">-
                                                </button>

                                                <input readonly type="text" name="quantity"
                                                       value="1"
                                                       id="product-quantity2${proList.productId}"
                                                       style="width: 50px"/>
                                                <button type="button" class="quantity-button"
                                                        name='add${proList.productId}'
                                                        onclick='javascript: subtractQty4(${proList.productId});'
                                                        value="+">+
                                                </button>
                                                &nbsp;
                                                &nbsp;
                                                <button type="submit" class="btn btn-primary">Thêm vào giỏ hàng</button>

                                            </form>
                                                <%--                                            <div class="product-quantity">--%>
                                                <%--                                                <input id="product-quantity2" type="text" value="1" readonly--%>
                                                <%--                                                       name="product-quantity2" class="form-control input-sm">--%>
                                                <%--                                            </div>--%>
                                                <%--                                            <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"--%>
                                                <%--                                               class="btn btn-primary add2cart" type="submit">Cho vào giỏ hàng</a>--%>
                                            <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>"
                                               class="btn btn-default">Xem chi tiết</a>
                                        </div>
                                    </div>

                                    <div class="sticker sticker-sale"></div>
                                </div>
                            </div>
                        </div>
                        <!-- END fast view of a product -->
                    </c:forEach>

                </ul>

                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <c:forEach items="${sellerList}" var="sellerList">
                        <li class="list-group-item clearfix"><a
                                href="<c:url value="/product/list?sellerId=${sellerList.sellerId}&categoryId=0"></c:url>"><img
                                style="width: 22px"
                                src="<c:url value="/image?fname=seller/${sellerList.images }"></c:url>">
                            <i class="fa fa-angle-right"></i>${sellerList.sellerName}</a></li>
                    </c:forEach>

                </ul>

            </div>
            <!-- END SIDEBAR -->

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-8">
                <h2><%=showLanguage.get("products")%></h2>
                <div class="owl-carousel owl-carousel3">


                    <c:forEach items="${productListNew}" var="proList">
                        <div>
                            <div class="product-item">
                                <div class="pi-img-wrapper">
                                    <img src="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                         class="img-responsive" alt="Berry Lace Dress">
                                    <div>
                                        <a href="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                           class="btn btn-default fancybox-button"><i class="fa fa-search" style="color: white;font-size: 20px" title="<%=showLanguage.get("zoom")%> "></i></a>
                                        <a href="#product-pop-up${proList.productId}"
                                           class="btn btn-default fancybox-fast-view"> <i class="fa fa-eye" style="color: white;font-size: 20px" title="<%=showLanguage.get("view")%> "></i></a>
                                    </div>
                                </div>
                                <h3>
                                    <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>">${proList.productName}</a>
                                </h3>
                                <div class="pi-price">${proList.price}</div>
                                <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"
                                   class="btn btn-default add2cart" class="btn btn-default add2cart">
                                    <i class="fa fa-shopping-cart" title="  <%=showLanguage.get("addtocart")%>" style="font-size: 20px"></i>
                                </a>
                                <div class="sticker sticker-new"></div>
                            </div>
                        </div>


                        <!-- BEGIN fast view of a product -->
                        <div id="product-pop-upp${proList.productId }" style="display: none; width: 700px;">
                            <div class="product-page product-pop-up${proList.productId }">
                                <div class="row">
                                    <div class="col-md-6 col-sm-6 col-xs-3">
                                        <div class="product-main-image">
                                            <img src="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                                 alt="Cool green dress with red bell 89" class="img-responsive">
                                        </div>
                                        <div class="product-other-images">
                                            <a href="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"
                                               class="active"><img alt="Berry Lace Dress"
                                                                   src="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image3 }"></c:url>">
                                                <img alt="Berry Lace Dress"
                                                     src="<c:url value="/image?fname=products/${proList.image3 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"><img
                                                    alt="Berry Lace Dress"
                                                    src="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"><img
                                                    alt="Berry Lace Dress"
                                                    src="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"></a>
                                            <br>


                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-9">
                                        <h2>${proList.productName}</h2>
                                        <h4><%=showLanguage.get("category")%>: ${proList.category.categoryName} -
                                            <%=showLanguage.get("shop")%>: ${proList.seller.sellerName }</h4>
                                        <div class="price-availability-block clearfix">
                                            <div class="price">
                                                <strong>${proList.price }</strong>
                                                <em><span>${proList.price/0.8 }</span></em>
                                            </div>
                                            <div class="availability">
                                                <%=showLanguage.get("inventory")%>: <strong>${proList.stoke}</strong>
                                            </div>
                                        </div>
                                        <div class="description">
                                            <p>${proList.description }</p>
                                        </div>
                                        <div class="product-page-options">
                                            <div class="pull-left">
                                                <label class="control-label"><%=showLanguage.get("size")%>:</label> <select
                                                    class="form-control input-sm">
                                                <option>L</option>
                                                <option>M</option>
                                                <option>XL</option>
                                            </select>
                                            </div>
                                            <div class="pull-left">
                                                <label class="control-label"><%=showLanguage.get("color")%>:</label> <select
                                                    class="form-control input-sm">
                                                <option>Red</option>
                                                <option>Blue</option>
                                                <option>Black</option>
                                            </select>
                                            </div>
                                        </div>
                                        <div class="product-page-cart">
                                            <form name="f1" method="get"
                                                  action="<c:url value="/member/cart/add"></c:url>">
                                                <input type="text" name="pId" id="pid4"
                                                       value="${proList.productId}" hidden="">
                                                <input type="text" id="stock3${proList.productId}" value="${proList.stoke}"
                                                       hidden="">

                                                <button type="button" class="quantity-button"
                                                        name='subtract${proList.productId}'
                                                        onclick='javascript: subtractQty5(${proList.productId});'
                                                        value="-">-
                                                </button>

                                                <input readonly type="text" name="quantity"
                                                       value="1"
                                                       id="product-quantity3${proList.productId}"
                                                       style="width: 50px"/>
                                                <button type="button" class="quantity-button"
                                                        name='add${proList.productId}'
                                                        onclick='javascript: subtractQty6(${proList.productId});'
                                                        value="+">+
                                                </button>
                                                &nbsp;
                                                &nbsp;
                                                <button type="submit" class="btn btn-primary"><%=showLanguage.get("addtocart")%></button>

                                            </form>

                                                <%--                                            <div class="product-quantity">--%>
                                                <%--                                                <input id="product-quantity3" type="text" value="1" readonly--%>
                                                <%--                                                       name="product-quantity3" class="form-control input-sm">--%>
                                                <%--                                            </div>--%>

                                                <%--                                            <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"--%>
                                                <%--                                               class="btn btn-primary add2cart" type="submit">Cho vào giỏ hàng</a>--%>
                                            <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>"
                                               class="btn btn-default"><%=showLanguage.get("seedetails")%></a>
                                        </div>
                                    </div>

                                    <div class="sticker sticker-sale"></div>
                                </div>
                            </div>
                        </div>
                        <!-- END fast view of a product -->
                    </c:forEach>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->

        <!-- BEGIN TWO PRODUCTS & PROMO -->
        <div class="row margin-bottom-35 ">
            <!-- BEGIN TWO PRODUCTS -->
            <div class="col-md-6 two-items-bottom-items">
                <h2><%=showLanguage.get("products")%></h2>
                <div class="owl-carousel owl-carousel2">
                    <c:forEach items="${productListNew}" var="proList">
                        <div>

                            <div class="product-item">
                                <div class="pi-img-wrapper">
                                    <img
                                            src="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                            class="img-responsive" alt="Berry Lace Dress">
                                    <div>
                                        <a href="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                           class="btn btn-default fancybox-button"><i class="fa fa-search" style="color: white;font-size: 20px" title="<%=showLanguage.get("zoom")%> "></i></a>
                                        <a href="#product-pop-up${proList.productId}"
                                           class="btn btn-default fancybox-fast-view"> <i class="fa fa-eye" style="color: white;font-size: 20px" title="<%=showLanguage.get("view")%> "></i></a>
                                    </div>
                                </div>
                                <h3>
                                    <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>">${proList.productName}</a>

                                </h3>
                                <div class="pi-price"> ${proList.price}</div>
                                <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"
                                   class="btn btn-default add2cart" class="btn btn-default add2cart">
                                    <i class="fa fa-shopping-cart" title="  <%=showLanguage.get("addtocart")%>" style="font-size: 20px"></i>
                                </a>
                            </div>
                        </div>

                        <!-- BEGIN fast view of a product -->
                        <div id="product-pop-up${proList.productId }" style="display: none; width: 700px;">
                            <div class="product-page product-pop-uppp${proList.productId }">
                                <div class="row">
                                    <div class="col-md-6 col-sm-6 col-xs-3">
                                        <div class="product-main-image">
                                            <img src="<c:url value="/image?fname=products/${proList.images }"></c:url>"
                                                 alt="Cool green dress with red bell 00" class="img-responsive">
                                        </div>

                                        <div class="product-other-images">
                                            <a href="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"
                                               class="active"><img alt="Berry Lace Dress"
                                                                   src="<c:url value="/image?fname=products/${proList.image2 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image3 }"></c:url>">
                                                <img alt="Berry Lace Dress"
                                                     src="<c:url value="/image?fname=products/${proList.image3 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"><img
                                                    alt="Berry Lace Dress"
                                                    src="<c:url value="/image?fname=products/${proList.image4 }"></c:url>"></a>
                                            <a href="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"><img
                                                    alt="Berry Lace Dress"
                                                    src="<c:url value="/image?fname=products/${proList.image5 }"></c:url>"></a>
                                            <br>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-9">
                                        <h2>${proList.productName}</h2>
                                        <h4><%=showLanguage.get("category")%>: ${proList.category.categoryName} -
                                            <%=showLanguage.get("shop")%>: ${proList.seller.sellerName }</h4>
                                        <div class="price-availability-block clearfix">
                                            <div class="price">
                                                <strong>${proList.price }</strong>
                                                <em><span>${proList.price/0.8 }</span></em>
                                            </div>
                                            <div class="availability">
                                                <%=showLanguage.get("inventory")%>: <strong>${proList.stoke}</strong>
                                            </div>
                                        </div>
                                        <div class="description">
                                            <p>${proList.description }</p>
                                        </div>
                                        <div class="product-page-options">
                                            <div class="pull-left">
                                                <label class="control-label"><%=showLanguage.get("size")%>:</label> <select
                                                    class="form-control input-sm">
                                                <option>L</option>
                                                <option>M</option>
                                                <option>XL</option>
                                            </select>
                                            </div>
                                            <div class="pull-left">
                                                <label class="control-label"><%=showLanguage.get("color")%>:</label> <select
                                                    class="form-control input-sm">
                                                <option>Red</option>
                                                <option>Blue</option>
                                                <option>Black</option>
                                            </select>
                                            </div>
                                        </div>
                                        <div class="product-page-cart">
                                            <form name="f1" method="get"
                                                  action="<c:url value="/member/cart/add"></c:url>">
                                                <input type="text" name="pId" id="pid5"
                                                       value="${proList.productId}" hidden="">
                                                <input type="text" id="stock4${proList.productId}" value="${proList.stoke}"
                                                       hidden="">

                                                <button type="button" class="quantity-button"
                                                        name='subtract${proList.productId}'
                                                        onclick='javascript: subtractQty7(${proList.productId});'
                                                        value="-">-
                                                </button>

                                                <input readonly type="text" name="quantity"
                                                       value="1"
                                                       id="product-quantity4${proList.productId}"
                                                       style="width: 50px"/>
                                                <button type="button" class="quantity-button"
                                                        name='add${proList.productId}'
                                                        onclick='javascript: subtractQty8(${proList.productId});'
                                                        value="+">+
                                                </button>
                                                &nbsp;
                                                &nbsp;
                                                <button type="submit" class="btn btn-primary"><%=showLanguage.get("addtocart")%></button>

                                            </form>
                                                <%--                                            <div class="product-quantity">--%>
                                                <%--                                                <input id="product-quantity" type="text" value="1" readonly--%>
                                                <%--                                                       name="product-quantity" class="form-control input-sm">--%>
                                                <%--                                            </div>--%>
                                                <%--                                            <a href="<c:url value="/member/cart/add?pId=${proList.productId}&quantity=1"/>"--%>
                                                <%--                                               class="btn btn-primary add2cart" type="submit">Cho vào giỏ hàng</a>--%>
                                            <a href="<c:url value="/product/detail?productId=${proList.productId }"></c:url>"
                                               class="btn btn-default"><%=showLanguage.get("seedetails")%></a>
                                        </div>
                                    </div>

                                    <div class="sticker sticker-sale"></div>
                                </div>
                            </div>
                        </div>
                        <!-- END fast  of a product -->
                    </c:forEach>

                </div>
            </div>
            <!-- END TWO PRODUCTS -->
            <!-- BEGIN PROMO -->
            <div class="col-md-6 shop-index-carousel">
                <div class="content-slider">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="${url}/frontend/pages/img/index-sliders/slide1.jpg"
                                     class="img-responsive" alt="Berry Lace Dress">
                            </div>
                            <div class="item">
                                <img src="${url}/frontend/pages/img/index-sliders/slide2.jpg"
                                     class="img-responsive" alt="Berry Lace Dress">
                            </div>
                            <div class="item">
                                <img src="${url}/frontend/pages/img/index-sliders/slide3.jpg"
                                     class="img-responsive" alt="Berry Lace Dress">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PROMO -->
        </div>
        <!-- END TWO PRODUCTS & PROMO -->
    </div>
</div>

<!-- BEGIN STEPS -->
<div class="steps-block steps-block-red">
    <div class="container">
        <div class="row">
            <div class="col-md-4 steps-block-col">
                <i class="fa fa-truck"></i>
                <div>
                    <h2>Free shipping</h2>
                    <em>Express delivery withing 3 days</em>
                </div>
                <span>&nbsp;</span>
            </div>
            <div class="col-md-4 steps-block-col">
                <i class="fa fa-gift"></i>
                <div>
                    <h2>Daily Gifts</h2>
                    <em>3 Gifts daily for lucky customers</em>
                </div>
                <span>&nbsp;</span>
            </div>
            <div class="col-md-4 steps-block-col">
                <i class="fa fa-phone"></i>
                <div>
                    <h2>0987 654 321</h2>
                    <em>24/7 customer care available</em>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END STEPS -->