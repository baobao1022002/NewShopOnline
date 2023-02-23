<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box green">
					<div class="portlet-title">
						<div class="caption green">
							<i class="fa fa-globe"></i>Quản lý Users Roles
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<!-- Hiển thị thông báo -->
							<%@include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
							
								<div class="row">
								<form action="admin-userrole" method="post">
									<div class="col-md-4">
										<div class="form-group">
											
											<label for="RoleID">Role ID:</label> 
											<input name="roleid" value="${userrole.roleid }" type="text" class="form-control" readonly>
											

										</div>
										<div class="form-group">
												<label for="UserName">Role Name:</label> <input type="text"
												name="rolename" id="rolename" class="form-control"
												value="${userrole.rolename }"/>
										</div>
										<hr>
										<div class="form-group">
											<button class="btn green"
												formaction="<c:url value="/admin-userrole/create"/>">
												Create <i class="fa fa-plus"></i>
											</button>
											<button class="btn btn-warning"
												formaction="<c:url value="/admin-userrole/update"/>">
												Update <i class="fa fa-edit"></i>
											</button>

											<button class="btn btn-danger"
												formaction="<c:url value="/admin-userrole/delete"/>">
												Delete <i class="fa fa-trash"></i>
											</button>
											<button class="btn btn-success"
												formaction="${pageContext.request.contextPath }/admin-userrole/reset">
												Reset <i class="fa fa-undo"></i>
											</button>
										</div>
									</div>
									</form>
									<div class="col-md-8">

											<div class="row">

								<div class="col-md-12"
									style="padding-right: 25px; padding-left: 25px">
									<div class="row">
										<div class="col-md-6"></div>
										<div class="col-md-6">
											<div class="btn-group pull-right">
												<button class="btn dropdown-toggle" data-toggle="dropdown">
													Tools <i class="fa fa-angle-down"></i>
												</button>
												<ul class="dropdown-menu pull-right">
													<li><a href="#"> Print </a></li>
													<li><a href="#"> Save as PDF </a></li>
													<li><a href="#"> Export to Excel </a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="row">
										<table class="table table-striped table-bordered table-hover"
											id="sample_2">
											<thead>
												<tr>
													<th>STT</th>													
													<th>Role ID</th>
													<th>Role Name</th>
													<th>Created Date</th>
													<th>Modified Date</th>													
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${userRoles}" var="list" varStatus="stt">
													<tr class="odd gradeX">
														<td>${stt.index+1 }</td>
														<td>${list.roleid }</td>
														<td>${list.rolename }</td>
														<td><fmt:formatDate pattern = "dd-MM-yyyy" 
         value = "${list.createdDate }" /></td>
														<td><fmt:formatDate pattern = "dd-MM-yyyy hh:mm:ss" type = "both" 
         value = "${list.modifiedDate }" /></td>
														<td><a
															href="<c:url value='/admin-userrole/edit?roleid=${list.roleid }'/>"
															class="center">Sửa</a> | <a
															href="<c:url value='/admin-userrole/delete?roleid=${list.roleid }'/>"
															class="center">Xóa</a></td>

													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
								</div>
							</div>
				

									</div>
									

								</div>
							
							
								</div>


					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
	</div>
</div>
