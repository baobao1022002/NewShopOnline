<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="row" style="padding-left: 10px;padding-right: 10px">
	<div class="col">
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
	</div>
</div>
