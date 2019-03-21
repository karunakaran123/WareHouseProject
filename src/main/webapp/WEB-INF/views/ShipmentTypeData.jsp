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
<%@include file="ShipmentHome.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary">
				<h2>ShipmentType Data</h2>
			</div>
			<div class="card-body">
				<a href="pdf">PdfExport</a> |<a href="excel">ExcelExport</a>
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover">
							<tr>
								<th>ShipmentId</th>
								<th>ShipmentMode</th>
								<th>ShipmentCode</th>
								<th>Enabled</th>
								<th>ShipmentGrade</th>
								<th>Description</th>
								<th colspan="2">Operations</th>
							</tr>
							<c:forEach items="${list}" var="smt">
								<tr>
									<td><c:out value="${smt.id}"></c:out></td>
									<td><c:out value="${smt.mode}"></c:out></td>
									<td><c:out value="${smt.code}"></c:out></td>
									<td><c:out value="${smt.enabled}"></c:out></td>
									<td><c:out value="${smt.grade}"></c:out></td>
									<td><c:out value="${smt.dsc}"></c:out></td>
									<td><a href="delete?id=${smt.id}">Delete</a></td>
									<td><a href="edit?id=${smt.id}">Edit</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-form">NO DATA FOUND IN DB</div>
					</c:otherwise>
				</c:choose>
			</div>
			

			<c:if test="${message ne null }">
			<div class="card-footer bg-warning">${message}</div>
			
			</c:if>
		</div>
	</div>
</body>
</html>