<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="/common/taglib.jsp"%>
<c:url value="/template/admin/static" var="url"></c:url>

		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Chỉnh sửa tài khoản</h2>
						<h5>Bạn có thể chỉnh sửa tài khoản người dùng</h5>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">Thông tin bạn có thể thay đổi</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
										<h3>${alert}</h3>
										<c:url value="/admin/user/edit" var="edit"></c:url>
										<form role="form" action="${edit }" method="post"
											enctype="multipart/form-data">
											<input name="id" value="${user.id }" type="text" hidden="">
											<div class="form-group">
												<label>Tên tài khoản:</label> <input class="form-control"
													value="${user.userName }" name="username" />
											</div>
											<div class="form-group">
												<label>Email:</label> <input class="form-control"
													value="${user.email }" name="email" />
											</div>
											<div class="form-group">
												<label>Họ và tên:</label> <input class="form-control"
													value="${user.fullName }" name="fullname" />
											</div>
											<div class="form-group">
												<label>Mật khẩu</label> <input class="form-control"
													value="${user.passWord }" type="password" name="password" />
											</div>
											<div class="form-group">
												<label>Phone:</label> <input class="form-control"
													value="${user.phone }" name="phone" />
											</div>
											<div class="form-group">
												<label>Quyền</label>
												<div class="checkbox">
													<label> <input type="radio" value="1" name="role" />Admin
													</label> <br> 
													<label> <input type="radio" value="2"
														name="role" checked="checked"/>Manager
													</label>
													<br> 
													<label> <input type="radio" value="3"
														name="role" checked="checked"/>Seller
													</label>
													<br> 
													<label> <input type="radio" value="5"
														name="role" checked="checked"/>Client
													</label>
												</div>

											</div>

											<div class="form-group">
												<label>Hình đại diện</label> <input type="file"
													name="avatar" />
											</div>
											<button type="submit" class="btn btn-default">Sửa</button>
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
	