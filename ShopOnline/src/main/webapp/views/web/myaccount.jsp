<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<title>Untitled Document</title>
<script src="<c:url value="/template/districts.min.js"/>"></script>


<br />
<div class="container">
	<div class="row">
		<div class="col-md-3">
			<!--left col-->
			<input name="id" value="${sessionScope.account.userId}" hidden="">
			<div class="text-center">
				<c:url value="${sessionScope.account.images}"
					   var="imgUrl"></c:url>
				<img src="${imgUrl }" width="60px" height="60px"
					 class="avatar img-circle img-thumbnail" alt="avatar">

				<%--				<h5>--%>
				<%--					<a href="<c:url value='/MyAccountServlet'/>"> <i--%>
				<%--						class="fa fa-edit"></i> Sửa hồ sơ--%>
				<%--					</a>--%>
				<p>Tên đăng nhập:<span style="color: red"> ${sessionScope.account.userName}</span></p>

				<%--				</h5>--%>
			</div>
			<hr>
			<div class="list-group">

				<a href="<c:url value='/member/orderbuy'/>"class="list-group-item list-group-item-action">
					Đơn mua
				</a>
				<a href="<c:url value='/ChangeProfile'/>"
				   class="list-group-item list-group-item-action">Tài khoản</a>
				<a href="<c:url value='/ChangePassword'/>"
				   class="list-group-item list-group-item-action">Đổi mật khẩu</a>
			</div>
		</div>

		<div class="col-md-9">

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

			<form action="ChangeProfile" method="POST">
				<input type="hidden" class="form-control" id="Id" name="Id"
					   value="${sessionScope.account.userId}">
				<div class="mb-3">
					<label>Họ tên</label> <input type="text" required
												 class="form-control" id="fullname" name="fullname" value="${sessionScope.account.fullName} "title="Nhập họ và tên mới" >
				</div>

				<div class="mb-3">
					<label>Email</label> <input type="email" required
												class="form-control" id="email" name="email" value="${sessionScope.account.email}" title="Nhập email mới">
				</div>

				<div class="mb-3">
					<label>Số điện thoại</label> <input type="text" required
														class="form-control" id="phone" name="phone" value="${sessionScope.account.phone}" title="Nhập số điện thoại mới">
				</div>
				<div class="row">

					<%--					<c:url value="member-emailphone?action=address" var="myaddress"></c:url>--%>
					<%--					<form class="form" action="${myaddress}" method="post"--%>
					<%--						  id="AddressForm">--%>

<%--					<div class="form-group">--%>
<%--						<div class="col-xs-6">--%>
<%--							<br>--%>
<%--							<h4>--%>
<%--								<label for="province">Tỉnh/Thành Phố:</label>--%>
<%--							</h4>--%>
<%--							<select class="form-control" name="calc_shipping_provinces"--%>
<%--									required>--%>
<%--								<option value="">Tỉnh / Thành phố</option>--%>
<%--							</select> <input class="billing_address_1" name="province" type="hidden" value="${user.province}">--%>

<%--						</div>--%>

<%--					</div>--%>
<%--					<div class="form-group">--%>
<%--						<div class="col-xs-6">--%>
<%--							<h4>--%>
<%--								<label for="district">Quận/Huyện/Thị Trấn:</label>--%>
<%--							</h4>--%>
<%--							<select class="form-control" name="calc_shipping_district"--%>
<%--									required>--%>
<%--								<option value="">Quận / Huyện / Thị Trấn</option>--%>
<%--							</select><input class="billing_address_2" name="district" type="hidden" value="${user.district}">--%>
<%--						</div>--%>
<%--					</div>--%>

<%--					<div class="form-group">--%>
<%--						<div class="col-xs-6">--%>
<%--							<h4>--%>
<%--								<label for="address">Địa chỉ:</label>--%>
<%--							</h4>--%>
<%--							<input type="text" class="form-control" name="address"--%>
<%--								   id="address" value="${user.address}" title="Nhập địa chỉ">--%>

<%--						</div>--%>
<%--					</div>--%>




					<%--					</form>--%>
				</div>

				<br>
				<button  class="btn btn-primary" type="submit" style="margin-left: 47%" title="Thay đổi thông tin cá nhân>">Lưu thay đổi</button>



			</form>
			<br>

		</div>
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