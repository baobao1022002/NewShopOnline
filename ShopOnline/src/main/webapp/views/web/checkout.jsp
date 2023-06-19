<%@ page import="java.util.Map" %>
<%@ page import="vn.projectLTW.util.Language" %>
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
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
<title>checkout</title>
<script src="<c:url value="/template/districts.min.js"/>"></script>


<br />
<div class="container">
	<div class="row">


			<c:if test="${not empty error}">
				<div class="alert alert-danger" role="alert">
						${error}
				</div>
			</c:if>
			<c:if test="${not empty success}">
				<div class="alert alert-success" role="alert">
						${success}
				</div>
			</c:if>


		<!-- Checkout Start -->
		<div class="container-fluid pt-5">
			<form action="${pageContext.request.contextPath}/checkout" method="POST">
			<div class="row px-xl-5">
				<div class="col-lg-8">
					<div class="mb-4">

						<h4 class="font-weight-semi-bold mb-4"><%=showLanguage.get("paymentinfomation")%></h4>
						<div class="row">
							<div class="col-md-6 form-group">
								<label><%=showLanguage.get("fullname")%></label> <input value="${sessionScope.account.userName}"
																class="form-control" type="text" placeholder="Họ và tên"
																name="buyerName"id="buyerName" required>
							</div>
							<div class="col-md-6 form-group">
								<label>Email</label> <input value="${sessionScope.account.email }"
															class="form-control" type="text" placeholder="Email"
															name="buyerEmail" id="buyerEmail" required>
							</div>
							<div class="col-md-6 form-group">
								<label><%=showLanguage.get("phone")%></label> <input value="${sessionScope.account.phone}"
																	class="form-control" type="text" placeholder="Số điện thoại"
																	name="buyerPhone" id="buyerPhone" required>
							</div>
							<div class="col-md-6 form-group">
								<label><%=showLanguage.get("DetailedAddress")%></label> <input
															  class="form-control" type="text" placeholder="Địa chỉ"
															  name="address" id="address" required>
							</div>
							<div class="form-group">
								<div class="col-xs-6">
									<label for="province"><%=showLanguage.get("Province/City")%>:</label>

									<select class="form-control" name="calc_shipping_provinces"
											required>
										<option value="">Tỉnh / Thành phố</option>
									</select> <input class="billing_address_1" name="province" id="province" type="hidden">

								</div>

							</div>
							<div class="form-group">
								<div class="col-xs-6">
										<label for="district"><%=showLanguage.get("District/Town")%>:</label>
									<select class="form-control" name="calc_shipping_district"
											required>
										<option value="">Quận / Huyện / Thị Trấn</option>
									</select><input class="billing_address_2" name="district" id="district" type="hidden">
								</div>
							</div>
						</div>
					</div><br>

<%--					<a href="${pageContext.request.contextPath}/home" style="color: white; "><button--%>
<%--							class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3" style="width: fit-content;margin-left: 0px">Tiếp tục mua sắm</button> </a>--%>
					<a href="${pageContext.request.contextPath}/home" class="btn btn-default"><i
							class="fa fa-shopping-cart" style="font-size: 20px;color:#5ea8dc" title="<%=showLanguage.get("continueshopping")%>"></i></a>
				</div>

				<div class="col-lg-4">
					<div class="card border-secondary mb-5">
						<div class="card-header bg-secondary border-0">
							<h4 class="font-weight-semi-bold m-0"><%=showLanguage.get("totalOrder")%></h4>
						</div>
						<div class="card-body">
							<p class="font-weight-medium mb-3"><%=showLanguage.get("products")%></p>
							<c:forEach items="${sessionScope.cart}" var="map">
								<c:set var="total"
									   value="${total+map.value.quantity * map.value.product.price}"/>
								<c:set var="ship" value="${total*0.005 }"></c:set>
								<div class="d-flex justify-content-between">
									<p>${map.value.product.productName}(x${map.value.quantity})</p>
									<p>${map.value.product.price * map.value.quantity} VNĐ</p>
								</div>
							</c:forEach>
							<hr>

							<h5 class="font-weight-bold"><%=showLanguage.get("shippingcost")%></h5>
							<p class="font-weight-bold">${ship}</p>

							<div class="card-footer border-secondary bg-transparent">
								<div class="d-flex justify-content-between mt-2">

									<b><h4 class="font-weight-bold"><%=showLanguage.get("Total")%></h4></b>
									<p class="font-weight-bold" name="payment" id="payment" >${total+ship}</p>
									<input type="hidden" name="payment" value="${total+ship}">
								</div>

							</div>
						</div>
						<hr>
						<div class="card border-secondary mb-5">

							<div class="header-tags">
								<div class="overflow-h">
									<h4><%=showLanguage.get("paymentMethod")%></h4>
								</div>
							</div>

								<div class="row">
										<!-- Accordion -->
										<div class="accordion-v2">
											<div class="panel-group" id="accordion">
												<div class="panel panel-default">
													<div class="panel-heading">
														<p class="panel-title">
															<a data-toggle="collapse" data-parent="#accordion"
															   href="#collapse1"> <i class="fa fa-bus"></i> <%=showLanguage.get("CODpayment")%>
															</a>
														</p>
													</div>
													<div id="collapse1" class="panel-collapse collapse in">
														<div class="content margin-left-10">
															<label class="container">
																<input type="checkbox" checked="checked" name="codcheck" id="myCheck" onclick="myFunction()">
																Thanh toán khi nhận hàng (COD)

															</label>
															<br/>
															Phương thức này người mua sẽ thanh toán tiền cho shipper khi nhận hàng.
														</div>
													</div>
												</div>


												<div class="panel panel-default">
													<div class="panel-heading">
														<p class="panel-title">
															<a data-toggle="collapse" data-parent="#accordion"
															   href="#collapseOne"> <i class="fa fa-credit-card"></i>
																<%=showLanguage.get("Pay by credit card")%>
															</a>
														</p>
													</div>
													<div id="collapseOne" class="panel-collapse collapse">
														<div class="panel-body cus-form-horizontal">
															<div class="form-group">
																<label class="col-sm-4 no-col-space control-label">Cardholder
																	Name</label><br>
																<div class="col-sm-8">
																	<input type="text" class="form-control required"
																		   name="cardholder" placeholder="">
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-4 no-col-space control-label">Card
																	Number</label><br>
																<div class="col-sm-8">
																	<input type="text" class="form-control required"
																		   name="cardnumber" placeholder="">
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-4 no-col-space control-label">Payment
																	Types</label><br>
																<div class="col-sm-8">
																	<ul class="list-inline payment-type">
																		<li><i class="fa fa-cc-paypal"></i></li>
																		<li><i class="fa fa-cc-visa"></i></li>
																		<li><i class="fa fa-cc-mastercard"></i></li>
																		<li><i class="fa fa-cc-discover"></i></li>
																	</ul>
																</div>
															</div>


														</div>
													</div>
												</div>

											</div>
										</div>
										<!-- End Accordion -->
									</div>
							<div class="card-footer border-secondary bg-transparent">
									<a href="${pageContext.request.contextPath}/checkout" style="color: white"><button
										class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3" style="width: fit-content; margin-right: 0px"><%=showLanguage.get("order")%></button> </a>

							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
			<!-- Checkout End -->
	</div>
</div>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- <script
src="https://cdn.jsdelivr.net/gh/vietblogdao/js/districts.min.js"></script> -->
<script>//<![CDATA[
if (address_2 = localStorage.getItem('address_2_saved')) {
	$('select[name="calc_shipping_district"] option').each(function() {
		if ($(this).text() == address_2) {
			$(this).attr('selected', '')
		}
	})
	$('input.billing_address_2').attr('value', address_2)
}
if (district = localStorage.getItem('district')) {
	$('select[name="calc_shipping_district"]').html(district)
	$('select[name="calc_shipping_district"]').on('change', function() {
		var target = $(this).children('option:selected')
		target.attr('selected', '')
		$('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
		address_2 = target.text()
		$('input.billing_address_2').attr('value', address_2)
		district = $('select[name="calc_shipping_district"]').html()
		localStorage.setItem('district', district)
		localStorage.setItem('address_2_saved', address_2)
	})
}

if (states = localStorage.getItem('states')) {
	$('select[name="calc_shipping_states"]').html(states)
	$('select[name="calc_shipping_states"]').on('change', function() {
		var target = $(this).children('option:selected')
		target.attr('selected', '')
		$('select[name="calc_shipping_states"] option').not(target).removeAttr('selected')
		address_3 = target.text()
		$('input.billing_address_3').attr('value', address_3)
		states = $('select[name="calc_shipping_states"]').html()
		localStorage.setItem('states', states)
		localStorage.setItem('address_3_saved', address_3)
	})
}

$('select[name="calc_shipping_provinces"]').each(function() {
	var $this = $(this),
			stc = ''
	c.forEach(function(i, e) {
		e += +1
		stc += '<option value=' + e + '>' + i + '</option>'
		$this.html('<option value="">Tỉnh / Thành phố</option>' + stc)
		if (address_1 = localStorage.getItem('address_1_saved')) {
			$('select[name="calc_shipping_provinces"] option').each(function() {
				if ($(this).text() == address_1) {
					$(this).attr('selected', '')
				}
			})
			$('input.billing_address_1').attr('value', address_1)
		}
		$this.on('change', function(i) {
			i = $this.children('option:selected').index() - 1
			var str = '',
					r = $this.val()
			if (r != '') {
				arr[i].forEach(function(el) {
					str += '<option value="' + el + '">' + el + '</option>'
					$('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện / Thị Trấn</option>' + str)
				})
				var address_1 = $this.children('option:selected').text()
				var district = $('select[name="calc_shipping_district"]').html()
				localStorage.setItem('address_1_saved', address_1)
				localStorage.setItem('district', district)
				$('select[name="calc_shipping_district"]').on('change', function() {
					var target = $(this).children('option:selected')
					target.attr('selected', '')
					$('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
					var address_2 = target.text()
					$('input.billing_address_2').attr('value', address_2)
					district = $('select[name="calc_shipping_district"]').html()
					localStorage.setItem('district', district)
					localStorage.setItem('address_2_saved', address_2)
				})
			} else {
				$('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện /Thị Trấn</option>')
				district = $('select[name="calc_shipping_district"]').html()
				localStorage.setItem('district', district)
				localStorage.removeItem('address_1_saved', address_1)
			}
		})
	})
})

//]]></script>