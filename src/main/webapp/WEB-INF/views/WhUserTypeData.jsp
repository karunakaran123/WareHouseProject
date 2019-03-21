<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="WhUserHome.jsp"%>
<div class="container">
<div class="card">
<div class="card-header bg-danger">
	<h2>WhUserData!..</h2>
	</div>
	<div class="card-body">
	<a href="pdf">PdfExport</a> | <a href="excel">ExcelExport</a>
	<c:choose>
	<c:when test="${!empty list }">  
    <table class="table table-hover">
		<tr>
			<th>Id</th>
			<th>UserType</th>
			<th>UserCode</th>
			<th>UsedFor</th>
			<th>Email</th>
			<th>Contact</th>
			<th>IdType</th>
			<th>ifOther</th>
			<th>IdNumber</th>
			<th colspan="2">Operations</th>
		</tr>
		<c:forEach items="${list}" var="wh">
			<tr>
				<td><c:out value="${wh.id}"></c:out></td>
				<td><c:out value="${wh.type}"></c:out></td>
				<td><c:out value="${wh.code}"></c:out></td>
				<td><c:out value="${wh.forType}"></c:out></td>
				<td><c:out value="${wh.email}"></c:out></td>
				<td><c:out value="${wh.contact}"></c:out></td>
				<td><c:out value="${wh.idType}"></c:out></td>
				<td><c:out value="${wh.ifOther}"></c:out></td>
				<td><c:out value="${wh.idNum}"></c:out></td>
				<td><a href="delete?id=${wh.id}" class="btn btn-danger">Delete</a></td>
				<td><a href="edit?id=${wh.id}" class="btn btn-success">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
	 <div class="text-form">NO Data Found in DATABASE</div>
	</c:otherwise>
	</c:choose>
	</div>
	<c:if test="${message ne null}">
	 <div class="card-footer bg-warning">${message}</div>
	</c:if>
	</div><!--  div card end -->
	</div> <!-- div container end -->
	</body>
</html>