<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%@include file="OrderHome.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-warning text-white">
				<h2>Order Method Data</h2>
			</div>
			<div class="card-body">
				<a href="excel">Excel Export</a> | <a href="pdf">Pdf Export</a>
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover">
							<tr>
								<th>Id</th>
								<th>Mode</th>
								<th>Code</th>
								<th>Method</th>
								<th>Accept</th>
								<th>Description</th>
								<th colspan="2">Operations</th>
							</tr>
							<c:forEach items="${list}" var="om">
								<tr>
									<td><c:out value="${om.id}"></c:out></td>
									<td><c:out value="${om.mode}"></c:out></td>
									<td><c:out value="${om.code}"></c:out></td>
									<td><c:out value="${om.method}"></c:out></td>
									<td><c:out value="${om.accept}"></c:out></td>
									<td><c:out value="${om.dsc}"></c:out></td>
									<td><a href="delete?id=${om.id}" class="btn btn-danger">Delete</a></td>
									<td><a href="edit?id=${om.id}" class="btn btn-success">Edit</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">NO Data Found</div>
					</c:otherwise>
					</c:choose>
				</div>
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>
		</div><!--  card end -->
	</div><!-- container end -->
</body>
</html>