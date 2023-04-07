<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglib.jsp"%>
<c:url value="/template/admin/static" var="url"></c:url>

		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Thêm tài khoản</h2>
						<h5>Bạn có thể thêm mới tài khoản người dùng</h5>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">Thêm tài khoản</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<h3>Tài khoản: ${errMsg}</h3>
										<form role="form" action="add"  method="post" enctype="multipart/form-data">
											<div class="form-group">
												<label>Tên tài khoản:</label> <input class="form-control"
													placeholder="Nhập tài khoản" name="username" />
											</div>
											<div class="form-group">
												<label>Họ tên</label> <input class="form-control"
													placeholder="Nhập họ tên" type="text"
													name="fullname" />
											</div>
											<div class="form-group">
												<label>Mật khẩu</label> <input class="form-control"
													placeholder="Nhập mật khẩu" type="password"
													name="password" />
											</div>
											
											<div class="form-group">
												<label>Email:</label> <input class="form-control"
													placeholder="Nhập Email" name="email" />
											</div>
											<div class="form-group">
												<label>Quyền</label>
												<div class="checkbox">
													<label> <input type="radio" value="1" name="role"/>Admin
													</label>
													<br>
													<label> <input type="radio" value="2" name="role" />Manager
													</label>
													<br>
													<label> <input type="radio" value="3" name="role" />Seller
													</label>
													<br>
													<label> <input type="radio" value="5" name="role" />Client
													</label>
												</div>
												
											</div>
											<div class="form-group">
												<label>Hình đại diện</label> <input type="file" name="avatar" />
											</div>
											<button type="submit" class="btn btn-default">Thêm</button>
											<button type="reset" class="btn btn-primary">Hủy</button>
										</form>


									</div>
								</div>
							</div>
						</div>
						<!-- End Form Elements -->
					</div>
				</div>
				<!-- /. ROW  -->
				<div class="row">
					<div class="col-md-12"></div>
				</div>
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	
