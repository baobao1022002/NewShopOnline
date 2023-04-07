<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="page-content-wrapper">
	<div class="page-content">

<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Chỉnh sửa danh mục</h2>
				<h5>Nơi bạn có thể chỉnh sửa thông tin danh mục</h5>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Chỉnh sửa danh mục</div>
					<div class="panel-body">
					<!-- Hiển thị thông báo -->
									<%@include file="/common/info.jsp"%>
									<!-- Kết thúc hiển thị thông báo -->
						<div class="row">
							<div class="col-md-6">
								<h3>Danh mục:</h3>
								<c:url value="/admin-category/edit" var="edit"></c:url>
								<form role="form" action="${edit}" method="post"
									enctype="multipart/form-data">
									<input name="id" value="${category.id }" hidden="">
									<div class="form-group">
										<label>Tên danh sách:</label> <input type="text"
											class="form-control" value="${category.name }" name="name" />
									</div>

									<div class="form-group">
										<c:url value="/image?fname=${category.icon }" var="imgUrl"></c:url>
										<img class="img-responsive" width="100px" src="${imgUrl}"
											alt=""> <label>Ảnh đại diện</label> <input type="file"
											name="icon" value="${category.icon }" />
									</div>
									<div class="form-group">

										<label>Trạng thái</label> 
										<select class="form-control"
											id="status" name="status">
											<option value="${category.status}">
												<c:if test="${category.status == 1}">
											<span class="label label-sm label-success">
												Hoạt động 
											</span>
										</c:if>
										<c:if test="${category.status ==0}">
											<span class="label label-sm label-warning">
												Khóa 
											</span>
										</c:if>
											</option>
											<option value="1">Hoạt động</option>
											<option value="0">Khóa</option>
											
										</select> 
										</div>
									<button type="submit" class="btn btn-default">Edit</button>
									<button type="reset" class="btn btn-primary">Reset</button>
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
</div>
</div>