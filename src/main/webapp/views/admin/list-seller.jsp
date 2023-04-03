<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<label for="sellerId">Seller ID: </label> <input type="text"
							class="form-control" id="sellerId" name="sellerId"
							value="${seller.sellerId}" readonly>
					</div>

					<div class="mb-3">
						<label for="sellerName">Seller Name:</label> <input
							type="text" class="form-control" id="sellerName"
							name="sellerName" value="${seller.sellerName}">
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
						<c:if test="${seller.images==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${seller.images!=null }">
							<c:url value="/image?fname=seller/${seller.images}" var="imgURL"></c:url>
						</c:if>

						<img alt="images" src="${imgURL}" width="80px" height="80px"
							id="images" class="rounded-circle"> <input type="file"
							class="form-control" onchange="chooseFile(this)" name="images"
							value="${seller.images}">
					</div>

					<label for="status">Status:</label>
					<div class="form-check form-check-inline">
						<input type="radio" class="form-check-input" id="statusOn"
							name="status" value="1" ${seller.status==1?'checked':'' }>
						<label class="form-check-label">Hoạt động</label> <input
							type="radio" class="form-check-input" id="statusOff"
							name="status" value="0" ${seller.status==0?'checked':'' }>
						<label class="form-check-label">Khóa</label>
					</div>
					<br />

					<button class="btn btn-success"
						formaction="<c:url value="/admin/seller/create"/>">
						Create <i class="fa fa-plus"></i>
					</button>

					<button class="btn btn-warning"
						formaction="<c:url value="/admin/seller/update"/>">
						Update <i class="fa fa-edit"></i>
					</button>

					<button class="btn btn-danger"
						formaction="<c:url value="/admin/seller/delete"/>">
						Delete <i class="fa fa-trash"></i>
					</button>

					<button class="btn btn-primary"
						formaction="<c:url value="/admin/seller/reset"/>">
						Reset <i class="fa fa-undo"></i>
					</button>
					<br />

				</div>
			</div>
		</form>
		<br />

		<div class="row">
			<div class="col-sm-12">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Seller ID</th>
							<th scope="col">Images</th>
							<th scope="col">seller Name</th>
							
							<th scope="col">Status</th>
							<th scope="col">Action</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${sellerList}" varStatus="stt">
							<tr>
								<th scope="row">${i.sellerId}</th>
								<td><c:url value="/image?fname=seller/${i.images}"
										var="imgURL"></c:url> <img width="80px" height="80px"
									src="${imgURL}" class="rounded-circle"></td>
								<td>${i.sellerName}</td>
						
								<td>${i.status==1?'Hoạt động':'Khóa'}</td>


								<td><a
									href="<c:url value="/admin/seller/edit?sellerId=${i.sellerId}"/>">Edit</a>
									| <a
									href="<c:url value="/admin/seller/delete?sellerId=${i.sellerId}"/>">Delete</a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>


</body>
</html>