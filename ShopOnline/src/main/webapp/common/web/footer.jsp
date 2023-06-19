<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/template/assets" var="url"></c:url>

<div class="pre-footer">
  <div class="container">
    <div class="row">
      <!-- BEGIN BOTTOM ABOUT BLOCK -->
      <div class="col-md-3 col-sm-6 pre-footer-col">
        <h2>Giới thiệu</h2>
        <p>Shop Thời Trang với phương châm "Đồng hành cùng phong cách thời trang của bạn" sẽ là nơi mua sắm an toàn và uy tín, bởi chúng tôi lu
          ôn đề cao tiêu chí mang đến cho quý khách những sản phẩm chất lượng nhất với giá cả luôn phải chăng. </p>
      </div>
      <!-- END BOTTOM ABOUT BLOCK -->
      <!-- BEGIN BOTTOM INFO BLOCK -->
      <div class="col-md-3 col-sm-6 pre-footer-col">
        <h2>Thông tin</h2>
        <ul class="list-unstyled">
          <li><i class="fa fa-angle-right"></i> <a href="<c:url value="/home"></c:url>">Trang chủ</a></li>
          <li><i class="fa fa-angle-right"></i> <a href="#">Sản phẩm</a></li>
          <li><i class="fa fa-angle-right"></i> <a href="${pageContext.request.contextPath}/member/cart">Giỏ hàng</a></li>
          <li><i class="fa fa-angle-right"></i> <a href="<c:url value="/member/orderbuy"></c:url>">Đơn mua</a></li>
          <li><i class="fa fa-angle-right"></i> <a href="<c:url value="/ChangeProfile"></c:url>">Tài khoản</a></li>

        </ul>
      </div>
      <!-- END INFO BLOCK -->
      <!-- BEGIN BOTTOM CONTACTS -->
      <div class="col-md-3 col-sm-6 pre-footer-col">
        <h2>Liên hệ</h2>
        <address class="margin-bottom-40">
          35, Linh Trung<br>
          Thủ Đức, TP HCM<br>
          Phone: 098 7654 321<br> Fax: 300 323 1456<br>
          Email: <a href="#">info@metronic.com</a><br>

        </address>
      </div>
      <!-- END BOTTOM CONTACTS -->
      <!-- BEGIN TWITTER BLOCK -->
      <div class="col-md-3 col-sm-6 pre-footer-col">

        <h2>Nhận thông báo</h2>
        <form action="#">
          <div class="input-group">
            <input type="text" placeholder="email@gmail.com" class="form-control">
            <span class="input-group-btn">
                    <button class="btn btn-primary" type="submit">Đăng kí</button>
                  </span>
          </div>
        </form>

      </div>
      <!-- END TWITTER BLOCK -->


    </div>


