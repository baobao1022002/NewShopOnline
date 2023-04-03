<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row">
			<div class="col-md-9">
				<c:url value="/admin-category/add" var="edit"></c:url>
								<form role="form" action="${edit}" method="post"
									enctype="multipart/form-data">
					<br />
					<div class="form-group">
						<label for="CategoryName">Category Name:</label> <input type="text"
							name="name" value="" id="name"
							class="form-control"/>
					</div>
					
					<div class="form-group">
						<label for="images">Images:</label> <input type="file"
							class="form-control" name="icon" id="icon"
							value="" />
					</div>
					<div class="form-check form-check-inline">
						<label for="status">Status:</label> <input id="statuson"
							class="form-check-input" type="radio" name="status"
							 value="true"> <label
							for="statuson" class="form-check-label">Hoạt động</label> <input
							id="statusoff" class="form-check-input" type="radio"
							name="status" value="false">
						<label for="statusoff" class="form-check-label">Khóa</label>
					</div>
					<br />
					<hr>
					<div class="form-group">
						<button type="submit" class="btn green"> Create <i class="fa fa-plus"></i>
						</button>
						
						<button type="reset" class="btn btn-success">
							Reset <i class="fa fa-undo"></i>
						</button>
					</div>

				</form>
			</div>

		</div>
	</div>
</div>

<!-- /. NAV SIDE  -->
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Thêm danh mục</h2>
				<h5>Thêm danh mục mà bạn cần bán</h5>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="panel-heading">Thêm danh mục</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<h3>Thông tin danh mục:</h3>

								<form role="form" action="add" method="post"
									enctype="multipart/form-data">
									<div class="form-group">
										<label>Tên danh mục:</label> <input class="form-control"
											placeholder="please enter category Name" name="name" />
									</div>

									<div class="form-group">
										<label>Ảnh đại diện</label> <input type="file" name="icon" />
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

