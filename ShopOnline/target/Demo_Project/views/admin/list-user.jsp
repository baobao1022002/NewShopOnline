<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<label for="userID">User ID: </label> <input type="text"
							class="form-control" id="userId" name="userId"
							value="${user.userId}" readonly>
					</div>

					<div class="mb-3">
						<label for="userName">User Name:</label> <input type="text"
							class="form-control" id="userName" name="userName"
							value="${user.userName}">
					</div>

					<div class="mb-3">
						<label for="fullName">Full Name:</label> <input type="text"
							class="form-control" id="fullName" name="fullName"
							value="${user.fullName}">
					</div>

					<div class="mb-3">
						<label for="email">Email:</label> <input type="text"
							class="form-control" id="email" name="email"
							value="${user.email}">

					</div>
				</div>
				<div class="col-sm-6">

					<div class="mb-3">
						<label for="phone">Phone:</label> <input type="text"
							class="form-control" id="phone" name="phone"
							value="${user.phone}">
					</div>

					<div class="mb-3">
						<label for="passWord">Password:</label> <input type="password"
							class="form-control" id="passWord" name="passWord"
							value="${user.passWord}">
					</div>
					
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
						<c:if test="${user.images==null }">
							<c:url value="/template/images/avatar.png" var="imgURL"></c:url>
						</c:if>
						<c:if test="${user.images!=null }">
							<c:url value="/image?fname=users/${user.images}" var="imgURL"></c:url>
						</c:if>
						
						<img alt="images" src="${imgURL}" width="80px" height="80px" id="images" class="rounded-circle">
						<input type="file" class="form-control" onchange="chooseFile(this)"  name="images" value="${user.images}">
					</div>
					
					<div class="mb-3">
						<label for="Roles">Roles:</label> 
						<select name="roleId">
							<c:forEach items="${roles}" var="item">
								<option value="${item.roleId}" ${user.roleId==item.roleId?'selected':''}>${item.roleName}</option>		
							</c:forEach>
						</select>
					</div>

					<label for="status">Status:</label>
					<div class="form-check form-check-inline">
						<input type="radio" class="form-check-input" id="statusOn"
							name="status" value="1" ${user.status==1?'checked':'' }> <label class="form-check-label">Hoạt
							động</label> 
							
						<input type="radio" class="form-check-input" id="statusOff"
							name="status" value="0" ${user.status==0?'checked':'' }> <label class="form-check-label">Khóa</label>
					</div>
					<br />
					
					<button class="btn btn-success"
						formaction="<c:url value="/admin/user/create"/>">
						Create <i class="fa fa-plus"></i>
					</button>
					
					<button  class="btn btn-warning"
						formaction="<c:url value="/admin/user/update"/>">
						Update <i class="fa fa-edit"></i>
					</button>
					
					<button class="btn btn-danger"
						formaction="<c:url value="/admin/user/delete"/>">
						Delete <i class="fa fa-trash"></i>
					</button>
					
					<button class="btn btn-primary"
						formaction="<c:url value="/admin/user/reset"/>">
						Reset <i class="fa fa-undo"></i>
					</button>
					<br />

				</div>
			</div>
		</form>
		<br />

		<div class="row">
			<div class="col-sm-12">
				<table class="table table-striped table-bordered table-hover" id="sample_2">
					<thead>
						<tr>
							<th scope="col">User ID</th>
							<th scope="col">Images</th>
							<th scope="col">User Name</th>
							<th scope="col">Full name</th>
							<th scope="col">Email</th>
							<th scope="col">Roles</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${userList}" varStatus="stt">
							<tr>
								<th scope="row">${i.userId}</th>
								<td>
									<c:url value="/image?fname=users/${i.images}" var="imgURL"></c:url>
									<img width="80px" height="80px" src="${imgURL}" class="rounded-circle">
								</td>
								<td>${i.userName}</td>
								<td>${i.fullName}</td>
								<td>${i.email}</td>
								<td>${i.roles.roleName}</td>
								<td>${i.status==1?'Hoạt động':'Khóa'}</td>


								<td>
									<a href="<c:url value="/admin/user/edit?userId=${i.userId}"/>">Edit</a> |
								    <a href="<c:url value="/admin/user/delete?userId=${i.userId}"/>">Delete</a>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

