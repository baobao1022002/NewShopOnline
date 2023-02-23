<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
					<a href="<c:url value='/member/myaccount'/>"> <i
						class="fa fa-edit"></i> Sửa hồ sơ
					</a>

				</h5>

			</div>

			<hr>
			<div class="list-group">
				<a href="<c:url value='/member/myaccount'/>"
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
				<li class="nav-item"><a class="nav-link active btn-primary"
					href="#all" data-toggle="tab">Tất cả</a></li>
				<li class="nav-item"><a class="nav-link" href="#choxacnhan"
					data-toggle="tab">Chờ xác nhận</a></li>
				<li class="nav-item"><a class="nav-link" href="#cholayhang"
					data-toggle="tab">Chờ lấy hàng</a></li>
				<li class="nav-item"><a class="nav-link" href="#danggiao"
					data-toggle="tab">Đang giao <span
						class="badge badge-danger badge-pill">14</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#dagiao"
					data-toggle="tab">Đã giao</a></li>
				<li class="nav-item"><a class="nav-link" href="#dahuy"
					data-toggle="tab">Đã hủy</a></li>
			</ul>
			<br />
			<div class="tab-content">
				<div class="search-open" style="display: block;">

					<input type="text" class="form-control" autocomplete="off"
						placeholder="Tìm kiếm theo Tên Shop, ID đơn hàng hoặc Tên Sản phẩm">


				</div>
				<br />
				<div role="tabpanel" class="tab-pane active" id="all">
					<br />
					<div class="container bootstrap snippet">
						<div class="row">
							Danh sách tất cả đơn hàng <br />
						</div>
					</div>
					<br />
				</div>

				<div role="tabpanel" class="tab-pane fade" id="choxacnhan">
					Danh sách đơn hàng chờ xác nhận <br />
				</div>
				<div role="tabpanel" class="tab-pane fade" id="cholayhang">
					Danh sách đơn hàng chờ shipper lấy hàng <br />
				</div>
				<div role="tabpanel" class="tab-pane fade" id="danggiao">
					Danh sách đơn hàng đang giao <br />
				</div>
				<div role="tabpanel" class="tab-pane fade" id="dagiao">
					Danh sách đơn hàng đã giao thành công <br />
				</div>
				<div role="tabpanel" class="tab-pane fade" id="dahuy">
					Danh sách đơn hàng hủy <br />
				</div>
			</div>

		</div>
	</div>
</div>

