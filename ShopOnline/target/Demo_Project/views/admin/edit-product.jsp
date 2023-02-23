<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/template/admin/static" var="url"></c:url>
<script src="https://cdn.ckeditor.com/4.17.1/standard/ckeditor.js"></script>
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Chỉnh sửa sản phẩm</h2>
						<h5>Nơi bạn có thể chỉnh sửa thông tin sản phẩm</h5>
					</div>
				</div>
				<!-- /. ROW  -->

				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-heading">Chỉnh sửa sản phẩm</div>
							<div class="panel-body">
								<c:url value="/admin-product/edit" var="edit"></c:url>
								<form role="form" action="${edit }" method="post"
									enctype="multipart/form-data">

									<div class="row">
										<div class="col-md-4">
											<h3>Sản phẩm:</h3>
											<input name="id" value="${product.id }" hidden="">
											<div class="form-group">
												<label>Tên sản phẩm:</label> <input type="text"
													class="form-control" value="${product.name }" name="name" />
											</div>
											<div class="form-group">
												<label>Tiêu đề:</label> <input type="text"
													class="form-control" value="${product.title}" name="title" />
											</div>

										</div>

										<div class="col-md-4">

											<div class="form-group">
												<label>Price ($)</label> <input class="form-control"
													value="${product.price }" type="number" name="price" />
											</div>
											<div class="form-group">
												<label>Category</label>
												<div class="checkbox">
													<select name="cate">
														<option value="${product.category.id}">${product.category.name}</option>
														<c:forEach items="${categories}" var="c">
															<option value="${c.id}">${c.name}</option>
														</c:forEach>
													</select>
												</div>

											</div>
											<div class="form-group">
												<label>Nhà bán hàng</label>
												<div class="checkbox">
													<select name="sellerid">
														<option value="${product.isseller.sell_id}">${product.isseller.sell_name}</option>

														<c:forEach items="${sellers}" var="c">
															<option value="${c.sell_id}">${c.sell_name}</option>
														</c:forEach>
													</select>
												</div>

											</div>
											<div class="form-group">
												<label>Trạng thái</label>
												<input id="statuson"
												class="form-check-input" type="radio" name="status"
												${product.status==1?'checked':''} value="true"> <label
												for="statuson" class="form-check-label">Hoạt động</label> <input
												id="statusoff" class="form-check-input" type="radio"
												name="status" ${product.status==0?'checked':''} value="false">
											<label for="statusoff" class="form-check-label">Khóa</label>

											</div>



										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label>Images:</label>
												<c:if test="${product.image!=null }">
													<img class="img-responsive" width="180px" src="<c:url value="/image?fname=${product.image}"/>" alt=""> 
												</c:if>
												<c:if test="${ product.image==null}">
														<img class="img-responsive" width="180px" src="<c:url value="/template/images/product.jpg"/>" alt=""> 
												</c:if>
												<br/>
													<input type="file" name="image" value="${product.image }"  />
											</div>
											<button type="submit" class="btn green">Edit</button>
											<button type="reset" class="btn btn-primary">Reset</button>
										
										</div>
										

									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>Description </label> <br>
												<textarea rows="10" cols="90%" name="des" id="editor1">${product.des }</textarea>
											</div>
											<script>
												CKEDITOR.replace('editor1', {
													width : '90%',
													height : '300px'
												});
											</script>
										</div>
									</div>
								</form>
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

