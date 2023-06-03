<%@ page import="vn.projectLTW.util.Language" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %><%
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
            <!-- BEGIN CONTENT -->
            <div class="col-md-12 col-sm-12">
                <h1><%=showLanguage.get("shoppingcart")%></h1>
                <div class="goods-page">
                    <div class="goods-data clearfix">
                        <div class="table-wrapper-responsive">
                            <table summary="Shopping cart">
                                <tr>
                                    <th class="goods-page-image"><%=showLanguage.get("image")%></th>
                                    <th class="goods-page-description"><%=showLanguage.get("desription")%></th>
                                    <th class="goods-page-ref-no"><%=showLanguage.get("seller")%></th>
                                    <th class="goods-page-quantity"><%=showLanguage.get("quantity")%></th>
                                    <th class="goods-page-price"><%=showLanguage.get("unitprice")%></th>
                                    <th class="goods-page-total" colspan="2"><%=showLanguage.get("total")%></th>
                                </tr>
                                <c:forEach items="${sessionScope.cart}" var="map">
                                    <tr>
                                        <td class="goods-page-image">
                                            <a href="<c:url value="/product/detail?productId=${map.value.product.productId}"></c:url>"><img
                                                    src="<c:url value="/image?fname=products/${map.value.product.images}"></c:url>"
                                                    alt="${map.value.product.productName}"></a>
                                        </td>
                                        <td class="goods-page-description">
                                            <h3>
                                                <a href="<c:url value="/product/detail?productId=${map.value.product.productId}"></c:url>">${map.value.product.productName}</a>
                                            </h3>
                                            <p><strong>${map.value.product.productId}</strong></p>
                                            <em>${map.value.product.description}</em>
                                        </td>
                                        <td class="goods-page-ref-no">
                                                ${map.value.product.seller.sellerName}
                                        </td>

                                        <td class="goods-page-quantity" style="width:250px">
                                            <form name="f1" method="get"
                                                  action="<c:url value="/member/cart/updateQuantity"></c:url>">


                                                <input type="text" name="pId" id="pid"
                                                       value="${map.value.product.productId}" hidden="">

                                                <input type="text" id="stock${map.value.product.productId}"
                                                       value="${map.value.product.stoke}" hidden="">

                                                <button type="button" class="quantity-button"
                                                        name='subtract${map.value.product.productId}'
                                                        onclick='javascript: subtractQty0(${map.value.product.productId});'
                                                        value="-">-
                                                </button>

                                                <input readonly type="text" name="quantity"
                                                       value="${map.value.quantity}"
                                                       id="product-quantity${map.value.product.productId}"
                                                       style="width: 40px"/>


                                                <button type="button" class="quantity-button"
                                                        name='add${map.value.product.productId}'
                                                        onclick='javascript: subtractQty9(${map.value.product.productId});'
                                                        value="+">+
                                                </button>
                                                &nbsp;&nbsp
                                                <button type="submit" class="btn btn-danger"><%=showLanguage.get("update")%></button>

                                            </form>
                                        </td>
                                        <td class="goods-page-price">
                                            <strong><span></span>${map.value.product.price}</strong>
                                        </td>
                                        <td class="goods-page-total">
                                            <strong><span></span>${map.value.product.price * map.value.quantity}
                                            </strong>
                                        </td>
                                        <td class="del-goods-col">
                                            <a class="del-goods"
                                               href="${pageContext.request.contextPath}/member/cart/remove?pId=${map.value.product.productId}">&nbsp;</a>
                                        </td>
                                    </tr>

                                </c:forEach>
                            </table>
                        </div>

                        <div class="shopping-total">
                            <ul>
                                <li>
                                    <em><%=showLanguage.get("subtotal")%></em>
                                    <c:set var="total" value="${0}"/>
                                    <c:forEach items="${sessionScope.cart}" var="map">
                                        <c:set var="total"
                                               value="${total+map.value.quantity * map.value.product.price}"/>
                                    </c:forEach>
                                    <strong class="price"><span></span>${total}</strong>
                                </li>
                                <li>
                                    <em><%=showLanguage.get("shippingcost")%></em>
                                    <c:set var="ship" value="${total*0.005 }"></c:set>
                                    <strong class="price"><span></span>${ship}</strong>
                                </li>
                                <li class="shopping-total-price">
                                    <em><%=showLanguage.get("Total")%></em>
                                    <strong class="price"><span></span>${total+ship}</strong>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <a href="${pageContext.request.contextPath}/home" class="btn btn-default"><i
                            class="fa fa-shopping-cart" style="font-size: 20px;color: white" title="<%=showLanguage.get("continueshopping")%>"></i></a>
                    <a href="${pageContext.request.contextPath}/member/order" class="btn btn-primary"><i
                            class="fa fa-check" style="font-size: 20px;color: white" title="<%=showLanguage.get("checkout")%>"></i></a>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->


    </div>
</div>