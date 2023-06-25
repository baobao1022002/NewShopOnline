<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

		<div class="row">
			<div class="col">
				<c:if test="${not empty message }">
					<div class="alert alert-success">${message}</div>
				</c:if>

				<c:if test="${not empty error }">
					<div class="alert alert-danger">${error}</div>
				</c:if>

			</div>

		</div>

		<form action="#" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<div class="mb-3">
						<label for="categoryId">Category ID: </label> <input type="text"
							class="form-control" id="categoryId" name="categoryId"
							value="${category.categoryId}" readonly>
					</div>

					<div class="mb-3">
						<label for="categoryName">Category Name:</label> <input
							type="text" class="form-control" id="categoryName"
							name="categoryName" value="${category.categoryName}">
					</div>

				</div>
				<div class="col-sm-6">
						<script>
						function chooseFile(fileInput) {
							if(fileInput.files && fileInput.files[0]){
								var reader=new FileReader();
								
								reader.onload=function(e){
									$('#images').attr('src',e.target.result);
								}
								reader.readAsDataURL(fileInput.file[0]);
							}
						}
					</script>

					<div class="mb-3">
						<label for="Images">Images:</label>
						<c:if test="${category.images==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${category.images!=null }">
							<c:url value="/uploads/category/${category.images}" var="imgURL"></c:url>
						</c:if>

						<img alt="images" src="${imgURL}" width="80px" height="80px"
							id="images" class="rounded-circle"> <input type="file"
							class="form-control" onchange="chooseFile(this)" name="images"
							value="${category.images}">
					</div>

					<label for="status">Status:</label>
					<div class="form-check form-check-inline">
						<input type="radio" class="form-check-input" id="statusOn"
							name="status" value="1" ${category.status==1?'checked':'' }>
						<label class="form-check-label">Hoạt động</label> <input
							type="radio" class="form-check-input" id="statusOff"
							name="status" value="0" ${category.status==0?'checked':'' }>
						<label class="form-check-label">Khóa</label>
					</div>
					<br />

					<button class="btn btn-success"
						formaction="<c:url value="/admin/category/create"/>">
						Create <i class="fa fa-plus"></i>
					</button>

					<button class="btn btn-warning"
						formaction="<c:url value="/admin/category/update"/>">
						Update <i class="fa fa-edit"></i>
					</button>

					<button class="btn btn-danger"
						formaction="<c:url value="/admin/category/delete"/>">
						Delete <i class="fa fa-trash"></i>
					</button>

					<button class="btn btn-primary"
						formaction="<c:url value="/admin/category/reset"/>">
						Reset <i class="fa fa-undo"></i>
					</button>
					<br />

				</div>
			</div>
		</form>
		<br />
<div class="row">
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 margin-bottom-10">
		<div class="dashboard-stat blue-madison">
			<div class="visual">
				<i class="fa fa-briefcase fa-icon-medium"></i>
			</div>
			<div class="details">
				<div class="number">
					<%--									 $168,492.54--%>
					<li>
						<c:set var="total" value="${totalRevenue}"/>

						<strong class="price">${total}</strong>
					</li>
					<%--									<p class="font-weight-bold" name="payment" id="payment" >${total+ship}</p>--%>
					<%--									<input type="hidden" name="payment" value="${total+ship}">--%>
				</div>
				<div class="desc">
					Lifetime Sales
				</div>
			</div>
			<a class="more" href="#">
				View more <i class="m-icon-swapright m-icon-white"></i>
			</a>
		</div>
	</div>
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
		<div class="dashboard-stat red-intense">
			<div class="visual">
				<i class="fa fa-shopping-cart"></i>
			</div>
			<div class="details">
				<div class="number">
					<%--									1,127,390--%>
					<li>
						<c:set var="total" value="${countToTalOrder}"/>

						<strong class="price">${total}</strong>
					</li>
				</div>
				<div class="desc">
					Total Orders
				</div>
			</div>
			<a class="more" href="#">
				View more <i class="m-icon-swapright m-icon-white"></i>
			</a>
		</div>
	</div>

</div>

		<div class="row">
			<div class="col-sm-12">
				<table class="table table-striped table-bordered table-hover" id="sample_2">
					<thead>
						<tr>
							<th scope="col">Category ID</th>
							<th scope="col">Images</th>
							<th scope="col">Category Name</th>
							
							<th scope="col">Status</th>
							<th scope="col">Action</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${categoryList}" varStatus="stt">
							<tr>
								<th scope="row">${i.categoryId}</th>
								<td><c:url value="/uploads/category/${i.images}"
										var="imgURL"></c:url> <img width="80px" height="80px"
									src="${imgURL}" class="rounded-circle"></td>
								<td>${i.categoryName}</td>
						
								<td>${i.status==1?'Hoạt động':'Khóa'}</td>


								<td><a
										href="<c:url value="/admin/category/edit?categoryId=${i.categoryId}"/>"><i class="fa fa-pencil" title="edit" style="color: #f1c40f; font-size: 20px"> </i></a>
									| <a
											href="<c:url value="/admin/category/delete?categoryId=${i.categoryId}"/>"><i class="fa fa-trash" title="Delete" style="color: red;font-size: 20px"></i></a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>



