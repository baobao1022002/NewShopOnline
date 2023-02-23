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
						<label for="roleId">Role ID: </label> <input type="text"
							class="form-control" id="roleId" name="roleId"
							value="${role.roleId}" readonly>
					</div>

					

					<div class="mb-3">
						<label for="roleName">Role Name:</label> <input type="text"
							class="form-control" id="roleName" name="roleName"
							value="${role.roleName}">
					</div>

					
				</div>
				
			
				
		
			</form>
			<br />
					<br />
					
		
			<br />
					<div class="row">
						<div class="col-sm-12">
							<button class="btn btn-success"
								formaction="<c:url value="/admin/userRole/create"/>">
								Create <i class="fa fa-plus"></i>
							</button>

		<button  class="btn btn-warning"
								formaction="<c:url value="/admin/userRole/update"/>">
								Update <i class="fa fa-edit"></i>
							</button>
							
							<button class="btn btn-danger"
								formaction="<c:url value="/admin/userRole/delete"/>">
								Delete <i class="fa fa-trash"></i>
							</button>
							
							<button class="btn btn-primary"
								formaction="<c:url value="/admin/userRole/reset"/>">
								Reset <i class="fa fa-undo"></i>
							</button>
						</div>
					</div>
		
					<br />
		
		
		<div class="row">
			<div class="col-sm-12">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Role ID</th>
							<th scope="col">Role Name</th>
							<th scope="col">Action </th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach var="i" items="${userRoleList}" varStatus="stt">
							<tr>
							
								<th scope="row">${i.roleId}</th>
								<td>${i.roleName}</td>
								<td>  
									<%-- <a href="<c:url value="/editRole?id=${i.roleId}"/>">Edit</a> |
									<a href="<c:url value="/deleteRole?id=${i.roleId}"/>">Delete</a> --%>
									<a href="<c:url value="/admin/userRole/edit?id=${i.roleId}"/>">Edit</a> |
									<a href="<c:url value="/admin/userRole/delete?id=${i.roleId}"/>">Delete</a>
								</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>



</html>