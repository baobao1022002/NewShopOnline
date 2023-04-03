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
			<input name="id" value="${sessionScope.account.id }" hidden="">
			<div class="text-center">
				<c:url value="/image?fname=${sessionScope.account.avatar }"
					var="imgUrl"></c:url>
				<img src="${imgUrl }" width="60px" height="60px"
					class="avatar img-circle img-thumbnail" alt="avatar">
				${sessionScope.account.userName }
				<h5>
					<a href="<c:url value='/member-myaccount'/>"> <i
						class="fa fa-edit"></i> Sửa hồ sơ
					</a>
				</h5>
			</div>
			<hr>
			<div class="list-group">
				<a href="<c:url value='/member-myaccount'/>"
					class="list-group-item list-group-item-action"> Tài khoản của
					tôi </a> <a href="<c:url value='/member/orderbuylist'/>"
					class="list-group-item list-group-item-action">Đơn mua<span
					class="badge badge-success badge-pill">14</span></a> <a href="#"
					class="list-group-item list-group-item-action">Thông báo <span
					class="badge badge-success badge-pill">14</span></a> <a href="#"
					class="list-group-item list-group-item-action">Hình thức thanh
					toán</a> <a href="#" class="list-group-item list-group-item-action">Ví
					của tôi</a>
			</div>
		</div>
		<div class="col-md-9">
			<ul class="nav nav-tabs flex-column font-weight-bold">
				<li class="nav-item"><a class="nav-link btn-primary"
					href="#details" data-toggle="tab">Thông tin người dùng</a></li>
				<li class="nav-item"><a class="nav-link btn-info"
					href="#mailform" data-toggle="tab">Cập nhật Email</a></li>
				<li class="nav-item"><a class="nav-link btn-warning"
					href="#phones" data-toggle="tab">Cập nhật số điện thoại</a></li>
				<li class="nav-item"><a class="nav-link btn-success"
					href="#address" data-toggle="tab">Cập nhật địa chỉ</a></li>
				<li class="nav-item"><a class="nav-link btn-danger"
					href="#forgetpass" data-toggle="tab">Đổi mật khẩu</a></li>
			</ul>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="details">
					<br />
					<div class="bootstrap snippet">
						<!-- Hiển thị thông báo -->
						<%@include file="/common/info.jsp"%>
						<!-- Kết thúc hiển thị thông báo -->
						<div class="row">
							<c:url value="member-myaccount" var="myaccount"></c:url>
							<form class="form" action="${myaccount }" method="post"
								id="registrationForm" enctype="multipart/form-data">

								<div class="col-sm-4">
									<!--left col-->
									<input name="roleid" value="${sessionScope.account.roleid }"
										hidden=""> <input name="id"
										value="${sessionScope.account.id }" hidden="">
									<div class="text-center">
										<c:url value="/image?fname=${sessionScope.account.avatar }"
											var="imgUrl"></c:url>
										<img src="${imgUrl }" class="avatar img-circle img-thumbnail"
											alt="avatar">
										<h6>
											Loại thành viên:
											<c:if test="${sessionScope.account.roleid==1}">
							Quản trị
						</c:if>
											<c:if test="${sessionScope.account.roleid==2}">
							Quản lý
						</c:if>
											<c:if test="${sessionScope.account.roleid==3}">
							Người bán
						</c:if>
											<c:if test="${sessionScope.account.roleid==5}">
							Người mua <br />
												<a
													href="<c:url value='emailphone?id=${sessionScope.account.id }'/>">Kích
													hoạt kênh người bán</a>
											</c:if>
										</h6>
										<input type="file" name="avatar"
											class="text-center center-block file-upload">
									</div>

									<br>
								</div>
								<!--/col-3-->
								<div class="col-sm-8">
									<div class="tab-content">
										<div class="tab-pane active" id="home">

											<div class="form-group">
												<div class="col-xs-6">
													<h4>
														<label for="first_name">Tài khoản:</label>
													</h4>
													<input type="text" class="form-control" name="username"
														value="${sessionScope.account.userName }"
														title="Nhập tên tài khoản đăng nhập" readonly>
												</div>
											</div>
											<div class="form-group">
												<div class="col-xs-6">
													<h4>
														<label for="full_name">Họ tên:</label>
													</h4>
													<input type="text" class="form-control" name="fullname"
														id="full_name" value="${sessionScope.account.fullName }"
														title="Nhập họ tên đầy đủ">
												</div>
											</div>
											<div class="form-group">
												<div class="col-xs-6">
													<h4>
														<label for="phone">Số điện thoại:</label>
													</h4>
													<input type="text" class="form-control" name="phone"
														value="${sessionScope.account.phone }"
														title="Nhập số điện thoại" readonly>
												</div>
											</div>
											<div class="form-group">
												<div class="col-xs-6">
													<h4>
														<label for="email">Email:</label>
													</h4>
													<input type="text" class="form-control" name="email"
														id="email" value="${sessionScope.account.email }"
														title="Nhập email" readonly>

												</div>
											</div>
											<div class="form-group">
												<div class="col-xs-6">
													<h4>
														<label for="pass">Mật khẩu</label>
													</h4>
													<input type="password" class="form-control" name="password"
														value="${sessionScope.account.passWord }"
														title="Nhập mật khẩu">
												</div>
											</div>
											<div class="form-group">
												<div class="col-xs-12">
													<br>
													<button class="btn btn-lg btn-success" type="submit">
														<i class="glyphicon glyphicon-ok-sign"></i> Lưu
													</button>
													<a class="btn btn-lg btn-default" href="member-myaccount">
									<i class="glyphicon glyphicon-repeat"></i> Thoát
								</a>
												</div>
											</div>

											<hr>

										</div>
									</div>
								</div>
							</form>
						</div>
					</div>


					<br />
				</div>
				<div role="tabpanel" class="tab-pane fade" id="mailform">
					<!-- Hiển thị thông báo -->
							<%@include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
					<div class="row">
					
					
					<c:url value="member-emailphone?action=mail" var="myemail"></c:url>
					<form class="form" action="${myemail}" method="post" id="EmailForm">
						
						<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="email1">Nhập địa chỉ Email mới muốn thay
										đổi:</label>
								</h4>
								<input type="text" class="form-control" name="email1"
									value="${sessionScope.account.email }"
									title="Nhập email mới muốn thay đổi">
							</div>
						</div>
						<div class="form-group" hidden="hidden">
							<div class="col-xs-6">
								<h4>
									<label for="id">ID:</label>
								</h4>
								<input type="text" class="form-control" name="id" id="id"
									value="${sessionScope.account.id }">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Lưu
								</button>
								<a class="btn btn-lg btn-default" href="member-myaccount">
									<i class="glyphicon glyphicon-repeat"></i> Thoát
								</a>
							</div>
						</div>
					</form>

					</div>
					<br />
				</div>
				<br />
				<div role="tabpanel" class="tab-pane fade" id="phones">
					<!-- Hiển thị thông báo -->
							<%@include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
					<div class="row">
					
					<c:url value="member-emailphone?action=phone" var="myphone"></c:url>
					<form class="form" action="${myphone}" method="post" id="PhoneForm">
						<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="phone_name">Nhập Số điện thoại mới muốn
										thay đổi:</label>
								</h4>
								<input type="text" class="form-control" name="phone1"
									value="${sessionScope.account.phone }"
									title="Nhập số điện thoại">

							</div>
						</div>
						<div class="form-group" hidden="hidden">
							<div class="col-xs-6">
								<h4>
									<label for="email1">Email:</label>
								</h4>
								<input type="text" class="form-control" name="email1"
									value="${sessionScope.account.email }" title="Nhập email">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Lưu
								</button>
								<a class="btn btn-lg btn-default" href="member-myaccount">
									<i class="glyphicon glyphicon-repeat"></i> Thoát
								</a>
							</div>
						</div>
					</form>
					</div>
					<br />
				</div>
				<br />
				<div role="tabpanel" class="tab-pane fade" id="address"
					x-data='formApp'>
					<!-- Hiển thị thông báo -->
							<%@include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
					<div class="row">
					
					<c:url value="member-emailphone?action=address" var="myaddress"></c:url>
					<form class="form" action="${myaddress}" method="post"
						id="AddressForm">
						
						<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="provine">Tỉnh/Thành Phố:</label>
								</h4>
								<select class="form-control" name="calc_shipping_provinces"
									required>
									<option value="">Tỉnh / Thành phố</option>
								</select> <input class="billing_address_1" name="" type="hidden" value="">

							</div>

						</div>
						<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="states">Quận/Huyện/Thị Trấn:</label>
								</h4>
								<select class="form-control" name="calc_shipping_district"
									required>
									<option value="">Quận / Huyện / Thị Trấn</option>
								</select> <input class="billing_address_2" name="states" type="text" value="">
							</div>
						</div>
						
<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="address_name">Địa chỉ:</label>
								</h4>
								<input type="text" class="form-control" name="adress"
									id="address" value="" title="Nhập địa chỉ">

							</div>
						</div>

						

						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Lưu
								</button>
								<a class="btn btn-lg btn-default" href="member-myaccount">
									<i class="glyphicon glyphicon-repeat"></i> Thoát
								</a>
							</div>
						</div>
					</form>
					</div>
					
				</div>
				
				<div role="tabpanel" class="tab-pane fade" id="forgetpass">
					<!-- Hiển thị thông báo -->
							<%@include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
					<div class="row">
					
					<c:url value="member-emailphone?action=changepass" var="changepass"></c:url>
					<form class="form" action="${changepass}" method="post"
						id="changepass">
						<div class="form-group" hidden="hidden">
							<div class="col-xs-6">
								<h4>
									<label for="id">ID:</label>
								</h4>
								<input type="text" class="form-control" name="id" id="id"
									value="${sessionScope.account.id }">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="passold">Nhập mật khẩu cũ:</label>
								</h4>
								<input type="password" class="form-control" name="passold" value="${sessionScope.account.passWord }"
									title="Nhập mật khẩu cũ">

							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="passnew">Nhập mật khẩu mới:</label>
								</h4>
								<input type="password" class="form-control" name="passnew" value=""
									title="Nhập mật khẩu mới" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-6">
								<h4>
									<label for="passnew1">Nhập lại mật khẩu mới:</label>
								</h4>
								<input type="password" class="form-control" name="passnew1" value=""
									title="Nhập lại mật khẩu mới" required="required">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Lưu
								</button>
								<a class="btn btn-lg btn-default" href="member-myaccount">
									<i class="glyphicon glyphicon-repeat"></i> Thoát
								</a>
							</div>
						</div>
					</form>
					</div>
					<br />
				</div>
			</div>
			<br />
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